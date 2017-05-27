/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Etapas;
import cl_modelos_pojos.VentasPlanta;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;

/**
 *
 * @author Pochechito
 */
public class ModificacionesVentasPlantaDAO {

    public ModificacionesVentasPlantaDAO() {

    }
  
    public int maxId() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("select max(id) from ModificacionesVentasPlanta ");
        List<VentasPlanta> listado = q.list();
        int res = 0;
        try {
           res =  Integer.parseInt(listado.get(0) + "");
        } catch (Exception e) {
        }
        return res;
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
