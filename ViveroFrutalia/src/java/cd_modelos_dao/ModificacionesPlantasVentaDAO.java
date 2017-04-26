/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

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
public class ModificacionesPlantasVentaDAO {

    public ModificacionesPlantasVentaDAO() {

    }
  
    public int maxId() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("select max(id) from ModificacionesPlantaVenta ");
        List<PlantasVenta> listado = q.list();
        int res = 0;
        try {
           res =  Integer.parseInt(listado.get(0) + "");
        } catch (Exception e) {
        }
        return res;
    }


    
}
