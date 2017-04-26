
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Extras.JJSON;
import cd_modelos_dao.ClientesDAO;
import cd_modelos_dao.PlantasDAO;
import cl_modelos_pojos.Clientes;
import cl_modelos_pojos.Plantas;
import cl_modelos_pojos.TipoPlanta;
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
public class plantasController {
    
    @RequestMapping(value = "/registrar_planta.htm", method = RequestMethod.POST)
    public @ResponseBody
    String registrarPlanta(@RequestParam("nombre") String nombre, @RequestParam("tipo") int tipo, @RequestParam("descripcion") String descripcion, @RequestParam("imagen") String imagen) {
        PlantasDAO plantaDAO = new PlantasDAO();
        TipoPlanta tipoP = new TipoPlanta();
        tipoP.setId(tipo);
        plantaDAO.registrarPlanta(nombre, tipoP, descripcion, imagen);
        JJSON convertidor = new JJSON();
        return convertidor.mapaPlantas(plantaDAO.obtenerPlantas());
    }

    @RequestMapping(value = "/editar_planta.htm", method = RequestMethod.POST)
    public @ResponseBody
    String editarPlanta(@RequestParam("id") int id, @RequestParam("nombre") String nombre, @RequestParam("tipo") int tipo, @RequestParam("descripcion") String descripcion, @RequestParam("imagen") String imagen) {
        PlantasDAO plantaDAO = new PlantasDAO();
        TipoPlanta tipoP = new TipoPlanta();
        tipoP.setId(tipo);
        plantaDAO.actualizarPlanta(id, nombre, tipoP, descripcion, imagen);
        JJSON convertidor = new JJSON();
        return convertidor.mapaPlantas(plantaDAO.obtenerPlantas());
    }

    @RequestMapping(value = "/eliminar_planta.htm", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarPlanta(@RequestParam("id") int id) {
        PlantasDAO plantaDAO = new PlantasDAO();
        plantaDAO.eliminarPlanta(id);
        JJSON convertidor = new JJSON();
        return convertidor.mapaPlantas(plantaDAO.obtenerPlantas());
    }

    @RequestMapping(value = "/plantas_consultarTodosJS.htm", method = RequestMethod.GET)
    public @ResponseBody
    String consultarPlantas() {
        PlantasDAO plantasDAO = new PlantasDAO();
        JJSON convertidor = new JJSON();
        return convertidor.mapaPlantas(plantasDAO.obtenerPlantas());
    }
    
    @RequestMapping(value = "/administrar_plantas.htm", method = RequestMethod.GET)
    public String administrarPlantas() {
        return "adminPlantas";
    }

    @RequestMapping(value = "/plantas_consultarId.htm", method = RequestMethod.GET)
    public @ResponseBody
    String consultarPlantaPorId(@RequestParam("id") String id, Model model) {
        PlantasDAO plantaDAO = new PlantasDAO();
        Plantas planta = plantaDAO.consultarPlantaPorId(Integer.parseInt(id));
        JJSON convertidor = new JJSON();
        return convertidor.jsonPlanta(planta);
    }
    
    @RequestMapping(value = "/ingresosEgresosPlanta.htm", method = RequestMethod.GET)
    public String ingresosEgresosPlanta() {
        return "ingresosEgresosPlanta";
    }

    @RequestMapping(value = "/consultar_flujoIngresos.htm", method = RequestMethod.POST)
    public @ResponseBody
        String consultarIngresosPorPlanta(@RequestParam("id") int id) {
        PlantasDAO plantaDAO = new PlantasDAO();
        JJSON convertidor = new JJSON();        
        //return plantaDAO == null ? "nulo" : plantaDAO.consultarVentaPorId(id).toString();
        return convertidor.mapaIngresosPlanta(plantaDAO.consultarIngresosPlanta(id));
    }
        
    @RequestMapping(value = "/consultar_flujoEgresos.htm", method = RequestMethod.POST)
    public @ResponseBody
        String consultarEgresosPorPlanta(@RequestParam("id") int id) {
        PlantasDAO plantaDAO = new PlantasDAO();
        JJSON convertidor = new JJSON();        
        //return plantaDAO == null ? "nulo" : plantaDAO.consultarVentaPorId(id).toString();
        return convertidor.mapaEgresosPlanta(plantaDAO.consultarEgresosPlanta(id));
    }

}