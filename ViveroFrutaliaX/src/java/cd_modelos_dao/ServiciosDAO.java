/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Servicios;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import java.util.List;

/**
 *
 * @author Pochechito
 */
public class ServiciosDAO {

    public ServiciosDAO() {

    }

    public void ingresarServicio( String nombre, String descripcion) {
        Servicios ser = new Servicios( nombre, descripcion);
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.save(ser);
            t.commit();
            s.close();
        } catch (Exception e) {
            t.rollback();
            throw new RuntimeException("No se pudo guardar el servicio");
        }
    }

    public Servicios consultarServicioPorId(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Servicios ser = (Servicios) s.get(Servicios.class, id);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void eliminarServicio(int id) {
        List<Servicios> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("delete from Servicios where id = :id");
        q.setInteger("id", id);
        q.executeUpdate();
        s.close();

//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session s = sf.openSession();
//        Servicios ser = consultarServicioPorId(id);
//        System.out.println("el servicio es " + ser.getNombre());
//        System.out.println("el servicio es " + ser.getId());
//        s.delete(ser);
//        s.close();
    }

    public Servicios actualizarServicio(int id, String nombre, String descripcion, int costo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Servicios u = new Servicios();
            u.setNombre(nombre);
            u.setDescripcion(descripcion);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }

    public List<Servicios> obtenerServicios() {
        List<Servicios> lista = new LinkedList<>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();
            Query q = s.createQuery("from Servicios");
            lista = q.list();
            s.close();
        } catch (Exception e) {
            System.out.println(e + "_______________--");
        }

        return lista;
    }

}
