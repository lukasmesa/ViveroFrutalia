/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Clientes;
import java.sql.Connection;
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
public class ClientesDAO {

    public ClientesDAO() {

    }

    public void ingresarCliente(int cedula, String nombre, String apellido, String telefono, String correo) {
        Clientes ser = new Clientes(cedula, nombre, apellido, telefono, correo);
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

    public Clientes consultarClientePorCedula(int cedula) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Clientes ser = (Clientes) s.get(Clientes.class, cedula);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void eliminarCliente(String cedula) {
        List<Clientes> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Clientes where cedula = :cedula");
        q.setString("cedula", cedula);
        q.executeUpdate();
        t.commit();
        s.close();

//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session s = sf.openSession();
//        Servicios ser = consultarServicioPorId(id);
//        System.out.println("el servicio es " + ser.getNombre());
//        System.out.println("el servicio es " + ser.getId());
//        s.delete(ser);
//        s.close();
    }

    public Clientes actualizarCliente(int cedula, String nombre, String apellido, String telefono, String correo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Clientes u = new Clientes(cedula, nombre, apellido, telefono, correo);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }

    public List<Clientes> obtenerClientes() {
        List<Clientes> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Clientes");
        lista = q.list();
        s.close();

        return lista;
    }

}
