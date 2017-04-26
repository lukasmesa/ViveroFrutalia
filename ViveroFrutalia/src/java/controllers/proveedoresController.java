
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.ProveedoresDAO;
import cl_modelos_pojos.Proveedores;
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
public class proveedoresController {

        ProveedoresDAO proveedorDAO = new ProveedoresDAO();
    @RequestMapping(value = "/proveedoresCRUD_registrar.htm", method = RequestMethod.POST)
    public String registrar(@RequestParam("cedula") int cedula, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("telefono") String telefono, @RequestParam("correo") String correo, Model model) {
        proveedorDAO.ingresarproveedor(cedula, nombre, apellido, telefono, correo);
        model.addAttribute("proveedores", proveedorDAO.obtenerProveedores());
        return "proveedores";
    }

    @RequestMapping(value = "/proveedoresCRUD_consultarTodos.htm", method = RequestMethod.GET)
    public String consultarServicios(Model model) {
        model.addAttribute("proveedores", proveedorDAO.obtenerProveedores());
        return "proveedores";
    }

    @RequestMapping(value = "/proveedoresCRUD_consultar.htm", method = RequestMethod.GET)
    public String consultarproveedorPorCedula(@RequestParam("cedula") String cedula, Model model) {
        Proveedores s = proveedorDAO.consultarproveedorPorCedula(Integer.parseInt(cedula));
        model.addAttribute("proveedor", s);
        return "proveedoresDetalle";

    }

    @RequestMapping(value = "/proveedoresCRUD_eliminar.htm", method = RequestMethod.GET)
    public String eliminarproveedorPorCedula(@RequestParam("cedula") String cedula, Model model) {
        proveedorDAO.eliminarproveedor(Integer.parseInt(cedula));
        model.addAttribute("proveedores", proveedorDAO.obtenerProveedores());
        return "proveedores";
    }

    @RequestMapping(value = "/proveedoresCRUD_actualizar.htm", method = RequestMethod.POST)
    public String actualizarServicio(@RequestParam("cedula") int cedula, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("telefono") String telefono, @RequestParam("correo") String correo, Model model) {
        Proveedores s = proveedorDAO.actualizarproveedor(cedula, nombre, apellido, telefono, correo);
        model.addAttribute("proveedor", s);
        return "proveedoresDetalle";
    }

}
