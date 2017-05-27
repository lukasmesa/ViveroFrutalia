/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import Modelos.PlantaReporte;
import Modelos.Reporte;
import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.PlantasVenta;
import cl_modelos_pojos.Suministros;
import cl_modelos_pojos.VentasPlanta;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;

/**
 *
 * @author Angie
 */
public class ReportesDePlantasDAO {

    public ReportesDePlantasDAO() {

    }

    public Reporte consultarTodos(String queryPlantas, String querySuministros) {
        Reporte obj = new Reporte();
        obj.setPlantas(consultarPlantasQuery(queryPlantas));
        obj.setSuministros(consultarSuministrosQuery(querySuministros));
        return obj;
    }

    public Reporte consultarPlantas(String queryPlantas) {
        Reporte obj = new Reporte();
        System.out.println("Solo plantas");
//        List<Plantas> plantas = new LinkedList<>();
//
//        for (Plantas cp : consultarPlantasQuery(queryPlantas)) {
//            plantas.add(new Planta(cp.getId(), cp.getTipoPlanta(), cp.getNombre(), cp.getDescripcion(), cp.getImagen()));
//        }
        obj.setPlantas(consultarPlantasQuery(queryPlantas));
        return obj;
    }

    public Reporte consultarSuministros(String querySuministros) {
        Reporte obj = new Reporte();
//        List<Suministro> suministros = new LinkedList<>();
//
//        for (Suministros cs : consultarSuministrosQuery(querySuministros)) {
//            suministros.add(new Suministro(cs.getId(), cs.getNombre(), cs.getDescripcion(), "suministro.png"));
//        }
        obj.setSuministros(consultarSuministrosQuery(querySuministros));
        return obj;
    }

    public List<PlantaReporte> consultarPlantasQuery(String consulta) {

        List<EtapasPlanta> lista = new LinkedList<>();
        List<PlantaReporte> listaReporte = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery(consulta);
        try {
            lista = q.list();

        } catch (Exception e) {
        }
        for (int i = 0; i < lista.size(); i++) {
            EtapasPlanta a = (EtapasPlanta) lista.get(i);
            Etapas b = (Etapas) a.getEtapas();
            Plantas c = (Plantas) a.getPlantas();
            listaReporte.add(new PlantaReporte(c.getNombre(), c.getDescripcion(), b.getNombre(), c.getImagen(), a.getPrecioVenta()));
        }
        s.close();
        return listaReporte;
    }

    public List<Suministros> consultarSuministrosQuery(String consulta) {
        List<Suministros> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery(consulta);
        try {
            lista = q.list();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        s.close();
        return lista;
    }

    public VentasPlanta consultarPrecioPlanta() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        List<PlantasVenta> listado = new LinkedList<>();
        Query q = s.createQuery("select etapasPlanta from PlantasVenta");

        try {
            listado = q.list();

        } catch (Exception e) {
            System.out.println("____________________________________________________");
            System.out.println(e);
            System.out.println("____________________________________________________");
        }
        for (int i = 0; i < q.list().size(); i++) {
            EtapasPlanta a = (EtapasPlanta) q.list().get(i);
            Etapas b = (Etapas) a.getEtapas();
            Plantas c = (Plantas) a.getPlantas();
            System.out.println(c.getNombre() + " " + b.getNombre() + " " + a.getPrecioVenta());
        }

        /*for (int i = 0; i < listado.size(); i++) {
            Plantas p = (Plantas) s.get(Plantas.class, listado.get(i).getEtapasPlanta().getPlantas().getId());
            Etapas p1 = (Etapas) s.get(Etapas.class, listado.get(i).getEtapasPlanta().getEtapas().getId());
            EtapasPlanta ePlanta = (EtapasPlanta) s.get(EtapasPlanta.class, listado.get(i).getEtapasPlanta().getId());
            listado.get(i).setEtapasPlanta(new EtapasPlanta());
            listado.get(i).getEtapasPlanta().setPlantas(p);
            listado.get(i).getEtapasPlanta().setEtapas(p1);
            listado.get(i).getEtapasPlanta().setPrecioVenta(ePlanta.getPrecioVenta());
        }

        Set<PlantasVenta> listado2 = new HashSet<>(listado);
        ser.setPlantasVentas(listado2);
        s.close();
        if (ser != null) {
            return ser;
        }*/
        return null;
    }
}
