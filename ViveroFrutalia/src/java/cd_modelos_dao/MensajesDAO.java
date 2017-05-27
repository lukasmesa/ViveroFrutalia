/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Mensajes;
import cl_modelos_pojos.PlantasVenta;
import java.util.Date;
import java.util.LinkedList;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;

/**
 *
 * @author Pochechito
 */
public class MensajesDAO {

    public MensajesDAO() {

    }


    public int maxId() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("select max(id) from Mensajes");
        
        List<PlantasVenta> listado = q.list();
        
        try{
            return Integer.parseInt(listado.get(0) + "");
        }catch(Exception e){
            return 0;
        }
    }

    public void ingresarMensaje(String nombre, String correo, String cad) {
        Mensajes mensaje = new Mensajes(maxId() + 1, new Date(), cad, correo, nombre);
        //System.out.println("--------------->>>"+mensaje.getId());
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            s.save(mensaje);
            t.commit();
            s.close();
          
        } catch (Exception e) {
            t.rollback();
            throw new RuntimeException("No se pudo guardar.");
        }
    }
    
    public List<Mensajes> obtenerMensajes() {
        List<Mensajes> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Mensajes order by fecha desc");
        lista = q.list();
        s.close();
        return lista;
    }
    
}
