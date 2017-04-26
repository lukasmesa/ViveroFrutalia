
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.ReportesDeComprasDAO;
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
public class regCompraController {

   @RequestMapping(value = "/reportesDeCompras.htm", method = RequestMethod.GET)
    public String consultarReportesDeCompras(@RequestParam("tipo") String tipo, @RequestParam("prov") String prov, @RequestParam("fi") String fi, @RequestParam("ff") String ff, Model model) {
        ReportesDeComprasDAO repDAO =  new ReportesDeComprasDAO();
        
        if(prov.equals("0")){
            prov = "";
        }else{
            prov = " where proveedores_cedula = " + prov;
        }
        
        switch(tipo){
            case "0":   //TODOS
                model.addAttribute("reportesDeCompras", repDAO.consultarCompras(true, true, "from ComprasPlanta" + prov, "from CompraSuministros" + prov, fi, ff));
                break;
            case "1":   //PLANTAS
                model.addAttribute("reportesDeCompras", repDAO.consultarCompras(true, false, "from ComprasPlanta" + prov, "", fi, ff));
                break;
            case "2":   //SUMINISTROS
                model.addAttribute("reportesDeCompras", repDAO.consultarCompras(false, true, "", "from CompraSuministros" + prov, fi, ff));
                break;
        }
        
        return "reportesDeCompras";
    }
    
    @RequestMapping(value = "/detallesDeCompraPlanta.htm", method = RequestMethod.GET)
    public String consultarDetallesDeCompraPlanta(@RequestParam("id") String id, Model model) {
        model.addAttribute("reportesDeComprasPlanta", new ReportesDeComprasDAO().consultarCompraPlanta(Integer.parseInt(id)));
        return "reportesDeComprasPlanta";
    }
    
    @RequestMapping(value = "/detallesDeCompraSuministro.htm", method = RequestMethod.GET)
    public String consultarDetallesDeCompraSuministro(@RequestParam("id") String id, Model model) {
        model.addAttribute("reportesDeComprasSuministro", new ReportesDeComprasDAO().consultarCompraSuministro(Integer.parseInt(id)));
        return "reportesDeComprasSuministro";
    }



}
