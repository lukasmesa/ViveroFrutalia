
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cd_modelos_dao.ReportesDeVentasDAO;
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
public class regVentaController {

    @RequestMapping(value = "/reportesDeVentas.htm", method = RequestMethod.GET)
    public String consultarReportesDeVentas(@RequestParam("tipo") String tipo, @RequestParam("fi") String fi, @RequestParam("ff") String ff, Model model) {
        ReportesDeVentasDAO repDAO = new ReportesDeVentasDAO();

//        if (prov.equals("0")) {
//            prov = "";
//        } else {
//            prov = " where proveedores_cedula = " + prov;
//        }

        switch (tipo) {
            case "0":   //TODOS
                model.addAttribute(
                        "reportesDeVentas",
                        repDAO.consultarVentas(
                                true,
                                true,
                                "from VentasPlanta" ,
                                "from VentaSuministros" ,
                                fi,
                                ff
                        )
                );
                break;
            case "1":   //PLANTAS
                model.addAttribute(
                        "reportesDeVentas",
                        repDAO.consultarVentas(
                                true,
                                false,
                                "from VentasPlanta" ,
                                "",
                                fi,
                                ff
                        )
                );
                break;
            case "2":   //SUMINISTROS
                model.addAttribute(
                        "reportesDeVentas",
                        repDAO.consultarVentas(
                                false,
                                true,
                                "",
                                "from VentaSuministros" ,
                                fi,
                                ff
                        )
                );
                break;
        }

        return "reportesDeVentas";
    }

    @RequestMapping(value = "/detallesDeVentaPlanta.htm", method = RequestMethod.GET)
    public String consultarDetallesDeVentaPlanta(@RequestParam("id") String id, Model model) {
        model.addAttribute("reportesDeVentasPlanta", new ReportesDeVentasDAO().consultarVentaPlanta(Integer.parseInt(id)));
        return "reportesDeVentasPlanta";
    }

    @RequestMapping(value = "/detallesDeVentaSuministro.htm", method = RequestMethod.GET)
    public String consultarDetallesDeVentaSuministro(@RequestParam("id") String id, Model model) {
        model.addAttribute("reportesDeVentasSuministro", new ReportesDeVentasDAO().consultarVentaSuministro(Integer.parseInt(id)));
        return "reportesDeVentasSuministro";
    }

}
