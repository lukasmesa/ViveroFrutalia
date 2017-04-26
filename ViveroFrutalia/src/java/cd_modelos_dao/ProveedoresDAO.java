/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Proveedores;
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
public class ProveedoresDAO {

    public ProveedoresDAO() {

    }

    public void ingresarproveedor(int cedula, String nombre, String apellido, String telefono, String correo) {
        Proveedores ser = new Proveedores(cedula, nombre, apellido, telefono, correo);
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

    public Proveedores consultarproveedorPorCedula(int cedula) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Proveedores ser = (Proveedores) s.get(Proveedores.class, cedula);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void eliminarproveedor(int cedula) {
        List<Proveedores> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("delete from Proveedores where cedula = :cedula");
        q.setInteger("cedula", cedula);
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

    public Proveedores actualizarproveedor(int cedula, String nombre, String apellido, String telefono, String correo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Proveedores u = new Proveedores(cedula, nombre, apellido, telefono, correo);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }

    public List<Proveedores> obtenerProveedores() {
        List<Proveedores> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Proveedores");
        lista = q.list();
        s.close();

        return lista;
    }

}
