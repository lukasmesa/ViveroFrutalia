
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.ComprasDAO;
import cl_modelos_pojos.ComprasPlanta;
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
public class comprasController {

    @RequestMapping(value = "/compras_plantas_consultarTodos.htm", method = RequestMethod.GET)
    public String consultarCompras(Model model) {
        ComprasDAO comprasDAO = new ComprasDAO();
        model.addAttribute("compras", comprasDAO.obtenerCompras());
        return "compras";
    }



    @RequestMapping(value = "/compras_consultar.htm", method = RequestMethod.GET)
    public String consultarCompraPorId(@RequestParam("id") int id, Model model) {
        ComprasDAO comprasDAO = new ComprasDAO();
        ComprasPlanta s = comprasDAO.consultarCompraPorId(id);
        model.addAttribute("compra", s);
        return "comprasDetalle";
    }

    @RequestMapping(value = "/compras_registrar.htm", method = RequestMethod.POST)
    public @ResponseBody
    String registrarCompra(@RequestParam("data") String data, Model model) {
        ComprasDAO comprasDAO = new ComprasDAO();
        comprasDAO.ingresarCompra(data);
        return "";
    }

    @RequestMapping(value = "/compras_actualizar.htm", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarCompra(@RequestParam("data") String data, Model model) {
        ComprasDAO comprasDAO = new ComprasDAO();
        comprasDAO.actualizarCompra(data);
        return "";
    }

    @RequestMapping(value = "/compras_eliminar.htm", method = RequestMethod.GET)
    public String eliminarCompraPorId(@RequestParam("id") int id, Model model) {
        ComprasDAO comprasDAO = new ComprasDAO();
        comprasDAO.eliminarCompra(id);
        model.addAttribute("compras", comprasDAO.obtenerCompras());
        return "compras";
    }
}
