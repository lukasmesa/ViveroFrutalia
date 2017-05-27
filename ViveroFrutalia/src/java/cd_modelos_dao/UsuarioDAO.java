/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_modelos_dao;

import cl_modelos_pojos.Usuario;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

/**
 *
 * @author Lukas
 * @version 20/05/2017
 */
public class UsuarioDAO {

    public UsuarioDAO() {

    }

    public Usuario consultarUsuario(String correo, String clave) {
        List<Usuario> lista = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        String hql = "from Usuario where correo = :correo and clave = :clave";
        Query q = s.createQuery(hql).setString("correo", correo).setString("clave", clave);
        lista = q.list();
        s.close();
        if (lista.size() > 0) {
            return lista.get(0);
        }
        return null;
    }

}
