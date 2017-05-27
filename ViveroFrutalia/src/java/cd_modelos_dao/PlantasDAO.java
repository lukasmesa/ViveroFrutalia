/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.ComprasPlanta;
import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.PlantasCompra;
import cl_modelos_pojos.PlantasVenta;
import cl_modelos_pojos.TipoPlanta;
import cl_modelos_pojos.VentasPlanta;
import java.util.HashSet;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Pochechito
 */
public class PlantasDAO {

    public PlantasDAO() {

    }
    
    public void registrarPlanta(String nombre, TipoPlanta tipo, String descripcion, String imagen) {
        Plantas planta = new Plantas(tipo, nombre, descripcion, imagen);
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.save(planta);
            t.commit();
            s.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            t.rollback();
            throw new RuntimeException("No se pudo guardar la planta");
        }
    }
    
    public Plantas consultarPlantaPorId(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Plantas planta = (Plantas) s.get(Plantas.class, id);
        s.close();
        if (planta != null) {
            return planta;
        }
        return null;
    }
    
    public Plantas actualizarPlanta(int id, String nombre, TipoPlanta tipo, String descripcion, String imagen) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Plantas plantaAcutalizada = new Plantas(id, tipo, nombre, descripcion, imagen);
            s.update(plantaAcutalizada);
            t.commit();
            s.close();
            return plantaAcutalizada;
        } catch (HibernateException he) {
            he.getMessage();
        }

        return null;
    }
    
    public void eliminarPlanta(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Plantas where id = :id");
        q.setInteger("id", id);
        q.executeUpdate();
        t.commit();
        s.close();
    }

    public List<Plantas> obtenerPlantas() {
        List<Plantas> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Plantas order by id");
        lista = q.list();
        s.close();

        return lista;
    }
    
    public VentasPlanta consultarIngresosPlanta(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        VentasPlanta ser = (VentasPlanta) s.get(VentasPlanta.class, id);
        List<PlantasVenta> listado = new LinkedList<>();
        Query q = s.createQuery("from PlantasVenta where plantas_id = " + id);
        try {
            listado = q.list();

        } catch (Exception e) {
            System.out.println("____________________________________________________");
            System.out.println(e);
            System.out.println("____________________________________________________");
        }
        for (int i = 0; i < listado.size(); i++) {
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
        }
        return null;
    }
    
    public ComprasPlanta consultarEgresosPlanta(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        ComprasPlanta ser = (ComprasPlanta) s.get(ComprasPlanta.class, id);
        List<PlantasCompra> listado = new LinkedList<>();
        Query q = s.createQuery("from PlantasCompra where plantas_id = " + id);
        try {
            listado = q.list();

        } catch (Exception e) {
            System.out.println("____________________________________________________");
            System.out.println(e);
            System.out.println("____________________________________________________");
        }
        for (int i = 0; i < listado.size(); i++) {
            System.out.println(listado.size());
            Plantas p = (Plantas) s.get(Plantas.class, listado.get(i).getEtapasPlanta().getPlantas().getId());
            Etapas p1 = (Etapas) s.get(Etapas.class, listado.get(i).getEtapasPlanta().getEtapas().getId());
            EtapasPlanta ePlanta = (EtapasPlanta) s.get(EtapasPlanta.class, listado.get(i).getEtapasPlanta().getId());
            listado.get(i).setEtapasPlanta(new EtapasPlanta());
            listado.get(i).getEtapasPlanta().setPlantas(p);
            listado.get(i).getEtapasPlanta().setEtapas(p1);
            listado.get(i).getEtapasPlanta().setPrecioCompra(ePlanta.getPrecioCompra());
        }

        Set<PlantasCompra> listado2 = new HashSet<>(listado);
        ser.setPlantasCompras(listado2);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

}
