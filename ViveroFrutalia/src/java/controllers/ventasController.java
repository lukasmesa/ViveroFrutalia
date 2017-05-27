
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.VentasDAO;
import cl_modelos_pojos.VentasPlanta;
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
public class ventasController {

    @RequestMapping(value = "/ventas_plantas_consultarTodos.htm", method = RequestMethod.GET)
    public String consultarVentas(Model model) {
        VentasDAO ventasDAO = new VentasDAO();
        model.addAttribute("ventas", ventasDAO.obtenerVentas());
        return "ventas";
    }



    @RequestMapping(value = "/ventas_consultar.htm", method = RequestMethod.GET)
    public String consultarVentaPorId(@RequestParam("id") int id, Model model) {
        VentasDAO ventasDAO = new VentasDAO();
        VentasPlanta s = ventasDAO.consultarVentaPorId(id);
        model.addAttribute("venta", s);
        return "ventasDetalle";
    }

    @RequestMapping(value = "/ventas_registrar.htm", method = RequestMethod.POST)
    public @ResponseBody
    String registrarVenta(@RequestParam("data") String data, Model model) {

        VentasDAO ventasDAO = new VentasDAO();
        ventasDAO.ingresarVenta(data);
        return "";
    }

    @RequestMapping(value = "/ventas_actualizar.htm", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarVenta(@RequestParam("data") String data, Model model) {
        VentasDAO ventasDAO = new VentasDAO();
        ventasDAO.actualizarVenta(data);
        return "";
    }

    @RequestMapping(value = "/ventas_eliminar.htm", method = RequestMethod.GET)
    public String eliminarVentaPorId(@RequestParam("id") int id, Model model) {
        VentasDAO ventasDAO = new VentasDAO();
        ventasDAO.eliminarVenta(id);
        model.addAttribute("ventas", ventasDAO.obtenerVentas());
        return "ventas";
    }
}
