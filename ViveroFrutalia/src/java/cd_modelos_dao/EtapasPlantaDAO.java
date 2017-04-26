/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.EtapasPlanta;
import cl_modelos_pojos.PlantasVenta;
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
public class EtapasPlantaDAO {

    public EtapasPlantaDAO() {

    }

    public void ingresarEtapasPlanta(EtapasPlanta ep) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.save(ep);
        } catch (Exception e) {
        }
    }
    public void ingresarActualizarEtapasPlanta(EtapasPlanta ep) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.saveOrUpdate(ep);
        } catch (Exception e) {
        }
    }
    public void actualizarEtapasPlanta(EtapasPlanta ep) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.update(ep);
            t.commit();
        } catch (Exception e) {
            System.out.println("Exception "+ e);
        }
    }

    public List<EtapasPlanta> obtenerEtapasPlanta() {
        List<EtapasPlanta> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from EtapasPlanta");
        lista = q.list();
        s.close();

        return lista;
    }

}
