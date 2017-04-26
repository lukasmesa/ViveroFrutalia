/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Clientes;
import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.Plantas;
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
public class EtapasDAO {

    public EtapasDAO() {

    }
  
    

    public List<Etapas> obtenerEtapas() {
        List<Etapas> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Etapas");
        lista = q.list();
        s.close();

        return lista;
    }

}
