
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Extras.JJSON;
import cd_modelos_dao.ClientesDAO;
import cl_modelos_pojos.Clientes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Pochechito
 */
@Controller
public class clientesController {

    @RequestMapping(value = "/clientesCRUD_registrar.htm", method = RequestMethod.POST)
    public String registrar(@RequestParam("cedula") int cedula, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("telefono") String telefono, @RequestParam("correo") String correo, Model model) {
        ClientesDAO clienteDAO = new ClientesDAO();
        clienteDAO.ingresarCliente(cedula, nombre, apellido, telefono, correo);
        model.addAttribute("clientes", clienteDAO.obtenerClientes());
        return "clientes";
    }

    @RequestMapping(value = "/clientesCRUD_consultarTodos.htm", method = RequestMethod.GET)
    public String consultarServicios(Model model) {
        ClientesDAO clienteDAO = new ClientesDAO();
        model.addAttribute("clientes", clienteDAO.obtenerClientes());
        return "clientes";
    }

    @RequestMapping(value = "/clientesCRUD_consultarTodosJS.htm", method = RequestMethod.GET)
    public @ResponseBody
    String consultarClientes(Model model) {
        ClientesDAO clienteDAO = new ClientesDAO();
        JJSON convertidor = new JJSON();
        return convertidor.convertirListadoClientes(clienteDAO.obtenerClientes());
    }

    @RequestMapping(value = "/clientesCRUD_consultar.htm", method = RequestMethod.GET)
    public String consultarClientePorCedula(@RequestParam("cedula") int cedula, Model model) {
        ClientesDAO clienteDAO = new ClientesDAO();
        Clientes s = clienteDAO.consultarClientePorCedula(cedula);
        model.addAttribute("cliente", s);
        return "clientesDetalle";

    }

    @RequestMapping(value = "/clientesCRUD_eliminar.htm", method = RequestMethod.GET)
    public String eliminarClientePorCedula(@RequestParam("cedula") String cedula, Model model) {
        ClientesDAO clienteDAO = new ClientesDAO();
        clienteDAO.eliminarCliente((cedula));
        model.addAttribute("clientes", clienteDAO.obtenerClientes());
        return "clientes";
    }

    @RequestMapping(value = "/clientesCRUD_actualizar.htm", method = RequestMethod.POST)
    public String actualizarServicio(@RequestParam("cedula") int cedula, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("telefono") String telefono, @RequestParam("correo") String correo, Model model) {
        ClientesDAO clienteDAO = new ClientesDAO();
        Clientes s = clienteDAO.actualizarCliente(cedula, nombre, apellido, telefono, correo);
        model.addAttribute("cliente", s);
        return "clientesDetalle";
    }

}
