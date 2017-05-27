
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Extras.JJSON;
import cd_modelos_dao.UsuarioDAO;
import cl_modelos_pojos.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Pochechito
 */
@Controller
public class usuarioController {
    
    @RequestMapping(value = "/usuario_iniciarSesion.htm", method = RequestMethod.POST)
    public @ResponseBody
    String iniciarSesion(@RequestParam("correo") String correo, @RequestParam("clave") String clave) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.consultarUsuario(correo, clave);
        JJSON convertidor = new JJSON();
        return convertidor.jsonUsuario(usuario);
    }
}