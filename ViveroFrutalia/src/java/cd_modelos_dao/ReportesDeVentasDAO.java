/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import Modelos.Venta;
import Modelos.VentasProveedores;
import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.EtapasPlantaId;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.PlantasVenta;
import cl_modelos_pojos.SuministrosVenta;
import cl_modelos_pojos.VentaSuministros;
import cl_modelos_pojos.VentasPlanta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import java.util.List;

/**
 *
 * @author Pochechito
 */
public class ReportesDeVentasDAO {

    public ReportesDeVentasDAO() {
    }

    public VentasProveedores consultarVentas(boolean enable1, boolean enable2, String queryPlantas, String querySum, String fi, String ff) {

        VentasProveedores obj = new VentasProveedores();
        List<Venta> ventas = new LinkedList<>();
        if (enable1) {
            for (VentasPlanta cp : consultarVentasDePlantas(queryPlantas)) {
                ventas.add(
                        new Venta(
                                cp.getId(),
                                cp.getNroFactura(),
                                "PLANTA",
                                cp.getFecha()
                        )
                );
            }
        }
        if (enable2) {
            for (VentaSuministros cs : consultarVentasDeSuministros(querySum)) {
                ventas.add(
                        new Venta(
                                cs.getId(),
                                cs.getNroFactura(),
                                "SUMINISTRO",
                                cs.getFecha()
                        )
                );
            }
        }

        eliminarVentasPorFechas(ventas, fi, ff);

        obj.setVentas(ventas);
        return obj;
    }

    public void eliminarVentasPorFechas(List<Venta> ventas, String fi, String ff) {
        Date fechaIn = null, fechaFin = null;
        if (!fi.equals("")) {
            fechaIn = toDate(fi);
        }
        if (!ff.equals("")) {
            fechaFin = toDate(ff);
        }

        List<Venta> itemsBorrar = new LinkedList<>();

        for (Venta c : ventas) {
            int compare;
            if (!fi.equals("")) {
                compare = c.getFecha().compareTo(fechaIn);
                if (compare == -1) {
                    itemsBorrar.add(c);
                }
            }
            if (!ff.equals("")) {
                compare = c.getFecha().compareTo(fechaFin);
                if (compare == 1) {
                    itemsBorrar.add(c);
                }
            }
        }

        itemsBorrar.forEach((c) -> {
            ventas.remove(c);
        });
    }

    public List<VentasPlanta> consultarVentasDePlantas(String consulta) {
        List<VentasPlanta> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery(consulta);
        lista = q.list();
        s.close();

        return lista;
    }

    public List<VentaSuministros> consultarVentasDeSuministros(String consulta) {
        List<VentaSuministros> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery(consulta);
        lista = q.list();
        s.close();
        return lista;
    }

    public List<PlantasVenta> consultarVentaPlanta(int id) {
        List<PlantasVenta> listado = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from PlantasVenta where id_ventas_planta = " + id);
        try {

            listado = q.list();

            for (int i = 0; i < listado.size(); i++) {
                Plantas p = (Plantas) s.get(Plantas.class, listado.get(i).getEtapasPlanta().getPlantas().getId());
                Etapas p1 = (Etapas) s.get(Etapas.class, listado.get(i).getEtapasPlanta().getEtapas().getId());

                EtapasPlanta ep = (EtapasPlanta) s.get(
                        EtapasPlanta.class,
                        new EtapasPlantaId(
                                p.getId(),
                                p1.getId()
                        )
                );
                ep.setPlantas(p);
                ep.setEtapas(p1);
                listado.get(i).setEtapasPlanta(ep);

            }
        } catch (Exception e) {
            System.out.println("Esta es la exception");
        }

        s.close();
        return listado;
    }

    public List<SuministrosVenta> consultarVentaSuministro(int id) {
        try {
            List<SuministrosVenta> lista = new LinkedList<>();
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session s = sf.openSession();

            Query q = s.createQuery("from SuministrosVenta where id_venta_suministros = " + id);
            lista = q.list();
            s.close();

            
            return lista;
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;

    }

    public static Date toDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.getMessage();
            return null;
        }
    }

}
