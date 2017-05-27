/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.PlantasCompra;
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
public class PlantasCompraDAO {

    public PlantasCompraDAO() {

    }

        public int maxId() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("select max(id) from PlantasCompra ");
        List<PlantasCompra> listado = q.list();
        int res = 0;
        try {
           res =  Integer.parseInt(listado.get(0) + "");
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return res;
    }
    public void ingresarPlantasCompra(PlantasCompra ep) {
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.saveOrUpdate(ep.getComprasPlanta());
            s.saveOrUpdate(ep);
            t.commit();
            s.close();
        } catch (HibernateException e) {
            e.getMessage();
            System.out.println("plantas compras dao");
            System.out.println(e);
        }
    }
    
}
