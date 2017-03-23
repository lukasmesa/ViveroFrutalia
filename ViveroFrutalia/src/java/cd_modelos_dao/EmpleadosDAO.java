/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Empleados;
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
public class EmpleadosDAO {

    public EmpleadosDAO() {

    }

    public void ingresarEmpleado(String cedula, String nombre, String apellido, String telefono, String correo, String HV) {
        Empleados ser = new Empleados(cedula, nombre, apellido, telefono, correo, HV);
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

    public Empleados consultarEmpleadoPorCedula(String cedula) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Empleados ser = (Empleados) s.get(Empleados.class, cedula);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void eliminarEmpleado(String cedula) {
        List<Empleados> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;

        Session s = sf.openSession();
        t = s.beginTransaction();
        Query q = s.createQuery("delete from Empleados where cedula = :cedula");
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

    public Empleados actualizarEmpleado(String cedula, String nombre, String apellido, String telefono, String correo, String HV) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Empleados u = new Empleados(cedula, nombre, apellido, telefono, correo, HV);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }

    public List<Empleados> obtenerEmpleados() {
        List<Empleados> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = null;
        t = s.beginTransaction();
        Query q = s.createQuery("from Empleados");
        lista = q.list();
        t.commit();
        s.close();

        return lista;
    }

}
