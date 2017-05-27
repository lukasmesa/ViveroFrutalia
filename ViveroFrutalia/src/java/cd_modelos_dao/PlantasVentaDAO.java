/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.PlantasVenta;
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
public class PlantasVentaDAO {

    public PlantasVentaDAO() {

    }

        public int maxId() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("select max(id) from PlantasVenta ");
        List<PlantasVenta> listado = q.list();
        int res = 0;
        try {
           res =  Integer.parseInt(listado.get(0) + "");
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return res;
    }
    public void ingresarPlantasVenta(PlantasVenta ep) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.saveOrUpdate(ep.getVentasPlanta());
            s.saveOrUpdate(ep);
            t.commit();
            s.close();
        } catch (HibernateException e) {
            e.getMessage();
            System.out.println("plantas ventas dao");
            System.out.println(e);
        }
    }
    
}
