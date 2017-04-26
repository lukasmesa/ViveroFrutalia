/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import Modelos.Compra;
import Modelos.ComprasProveedores;
import cl_modelos_pojos.CompraSuministros;
import cl_modelos_pojos.ComprasPlanta;
import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.PlantasCompra;
import cl_modelos_pojos.Proveedores;
import cl_modelos_pojos.Suministros;
import cl_modelos_pojos.SuministrosCompra;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;

/**
 *
 * @author Pochechito
 */
public class ReportesDeComprasDAO {

    public ReportesDeComprasDAO() {

    }

    public ComprasProveedores consultarCompras(boolean enable1, boolean enable2, String queryPlantas, String querySum, String fi, String ff) {
        
        ComprasProveedores obj = new ComprasProveedores();
        List<Compra> compras = new LinkedList<>();
        
        if (enable1) {
            for (ComprasPlanta cp : consultarComprasDePlantas(queryPlantas)) {
                compras.add(new Compra(cp.getId(), cp.getNroFactura(), "PLANTA", cp.getFecha(), cp.getProveedores().getCedula()));
            }
        }
        if (enable2) {
            for (CompraSuministros cs : consultarComprasDeSuministros(querySum)) {
                compras.add(new Compra(cs.getId(), cs.getNroFactura(), "SUMINISTRO", cs.getFecha(), cs.getProveedores().getCedula()));
            }
        }
        
        eliminarComprasPorFechas(compras, fi, ff);
        
        obj.setCompras(compras);
        obj.setProveedores(consultarProveedores());
        return obj;
    }
    
    public void eliminarComprasPorFechas(List<Compra> compras, String fi, String ff){
        Date fechaIn = null, fechaFin = null;
        if(!fi.equals("")){
            fechaIn = toDate(fi);
        }
        if(!ff.equals("")){
            fechaFin = toDate(ff);
        }
        
        List<Compra> itemsBorrar = new LinkedList<>();
        
        for(Compra c : compras){
            int compare;
            if(!fi.equals("")){
                compare = c.getFecha().compareTo(fechaIn);
                if(compare == -1){
                    itemsBorrar.add(c);
                }
            }
            if(!ff.equals("")){
                compare = c.getFecha().compareTo(fechaFin);
                if(compare == 1){
                    itemsBorrar.add(c);
                }
            }
        }
        
        itemsBorrar.forEach((c) -> {
            compras.remove(c);
        });
    }

    public List<Proveedores> consultarProveedores() {
        List<Proveedores> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Proveedores");
        lista = q.list();
        s.close();

        return lista;
    }
    
    public List<ComprasPlanta> consultarComprasDePlantas(String consulta) {
        List<ComprasPlanta> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery(consulta);
        lista = q.list();
        s.close();

        return lista;
    }

    public List<CompraSuministros> consultarComprasDeSuministros(String consulta) {
        List<CompraSuministros> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery(consulta);
        lista = q.list();
        s.close();

        return lista;
    }

    public List<PlantasCompra> consultarCompraPlanta(int id) {
        List<PlantasCompra> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from PlantasCompra where id_compras_planta = " + id);
        lista = q.list();
        
        for (PlantasCompra sc : lista) {
            Plantas ser = (Plantas) s.get(Plantas.class, sc.getEtapasPlanta().getPlantas().getId());
            EtapasPlanta et = (EtapasPlanta) s.get(EtapasPlanta.class, sc.getEtapasPlanta().getId());
            
            sc.setEtapasPlanta(et);
            sc.getEtapasPlanta().setPlantas(ser);
        }
        
        s.close();
        return lista;
    }

    public List<SuministrosCompra> consultarCompraSuministro(int id) {
        List<SuministrosCompra> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        //Query q = s.createQuery("from SuministrosCompra where compraSuministros.getId() = "+ id +"");
        Query q = s.createQuery("from SuministrosCompra where id_compra_suministros = " + id);
        lista = q.list();
        
        for (SuministrosCompra sc : lista) {
            Suministros ser = (Suministros) s.get(Suministros.class, sc.getSuministros().getId());
            sc.setSuministros(ser);
        }
        s.close();
        return lista;

    }
    
    public static Date toDate(String fecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
