
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.EmpleadosDAO;
import cl_modelos_pojos.Empleados;
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
public class empleadosController {

    @RequestMapping(value = "/empleadosCRUD_registrar.htm", method = RequestMethod.POST)
    public String registrar(@RequestParam("cedula") String cedula, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("telefono") String telefono, @RequestParam("correo") String correo, @RequestParam("hoja_vida") String HV, Model model) {
        EmpleadosDAO empleadoDAO = new EmpleadosDAO();
        empleadoDAO.ingresarEmpleado(cedula, nombre, apellido, telefono, correo,HV);
        model.addAttribute("empleados", empleadoDAO.obtenerEmpleados());
        return "empleados";
    }

    @RequestMapping(value = "/empleadosCRUD_consultarTodos.htm", method = RequestMethod.GET)
    public String consultarServicios(Model model) {
        EmpleadosDAO empleadoDAO = new EmpleadosDAO();
        model.addAttribute("empleados", empleadoDAO.obtenerEmpleados());
        return "empleados";
    }

    @RequestMapping(value = "/empleadosCRUD_consultar.htm", method = RequestMethod.GET)
    public String consultarempleadoPorCedula(@RequestParam("cedula") String cedula, Model model) {
        EmpleadosDAO empleadoDAO = new EmpleadosDAO();
        Empleados s = empleadoDAO.consultarEmpleadoPorCedula(cedula);
        model.addAttribute("empleado", s);
        return "empleadosDetalle";

    }

    @RequestMapping(value = "/empleadosCRUD_eliminar.htm", method = RequestMethod.GET)
    public String eliminarempleadoPorCedula(@RequestParam("cedula") String cedula, Model model) {
        EmpleadosDAO empleadoDAO = new EmpleadosDAO();
        empleadoDAO.eliminarEmpleado((cedula));
        model.addAttribute("empleados", empleadoDAO.obtenerEmpleados());
        return "empleados";
    }

    @RequestMapping(value = "/empleadosCRUD_actualizar.htm", method = RequestMethod.POST)
    public String actualizarServicio(@RequestParam("cedula") String cedula, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("telefono") String telefono, @RequestParam("correo") String correo,@RequestParam("hoja_vida") String HV, Model model) {
        EmpleadosDAO EmpleadoDAO = new EmpleadosDAO();
        Empleados s = EmpleadoDAO.actualizarEmpleado(cedula, nombre, apellido, telefono, correo,HV);
        model.addAttribute("empleado", s);
        return "empleadosDetalle";
    }

}
