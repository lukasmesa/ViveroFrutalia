
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.ServiciosDAO;
import cl_modelos_pojos.Servicios;
import java.util.List;
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
public class serviciosController {

    @RequestMapping(value = "/serviciosCRUD_registrar.htm", method = RequestMethod.POST)
    public String registrar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, Model model) {
        ServiciosDAO servicioDAO = new ServiciosDAO();
        servicioDAO.ingresarServicio(nombre, descripcion);
        model.addAttribute("servicios", servicioDAO.obtenerServicios());
        return "servicios";
    }

    @RequestMapping(value = "/serviciosCRUD_consultarTodos.htm", method = RequestMethod.GET)
    public String consultarServicios(Model model) {
        ServiciosDAO servicioDAO = new ServiciosDAO();
        model.addAttribute("servicios", servicioDAO.obtenerServicios());
        return "servicios";
    }

    @RequestMapping(value = "/serviciosCRUD_consultar.htm", method = RequestMethod.GET)
    public String consultarServicioPorId(@RequestParam("id") String id, Model model) {
        ServiciosDAO servicioDAO = new ServiciosDAO();
        Servicios s = servicioDAO.consultarServicioPorId(Integer.parseInt(id));
        model.addAttribute("servicio", s);
        return "serviciosDetalle";

    }

    @RequestMapping(value = "/serviciosCRUD_eliminar.htm", method = RequestMethod.GET)
    public String eliminarServicioPorId(@RequestParam("id") int id, Model model) {
        ServiciosDAO servicioDAO = new ServiciosDAO();
        servicioDAO.eliminarServicio((id));
        model.addAttribute("servicios", servicioDAO.obtenerServicios());
        return "servicios";

    }

    @RequestMapping(value = "/serviciosCRUD_actualizar.htm", method = RequestMethod.POST)
    public String actualizarServicio(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, Model model) {
        ServiciosDAO servicioDAO = new ServiciosDAO();
        Servicios s = servicioDAO.actualizarServicio(nombre, descripcion);
        model.addAttribute("servicio", s);
        return "serviciosDetalle";

    }

}
