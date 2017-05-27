
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.MensajesDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pochechito
 */
@Controller
public class MensajesController {

    @RequestMapping(value = "/enviarMensajes.htm", method = RequestMethod.GET)
    public String consultarMensajes(Model model) {
        return "enviarMensajes";
    }

    @RequestMapping(value = "/registrarMensaje.htm", method = RequestMethod.POST)
    public String registrarMensaje(@RequestParam("nombre") String nombre, @RequestParam("correo") String correo, @RequestParam("mensaje") String mensaje, Model model) {
        if (!nombre.equals("") && !correo.equals("") && !mensaje.equals("")) {
            new MensajesDAO().ingresarMensaje(nombre, correo, mensaje);
            return "index";
        }
        return "enviarMensajes";
    }
    
    @RequestMapping(value = "/revisarMensajes.htm", method = RequestMethod.GET)
    public String revisarMensajes(Model model) {
        return "revisarMensajes";
    }

}
