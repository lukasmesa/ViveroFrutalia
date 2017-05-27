
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Extras.JJSON;
import cd_modelos_dao.EtapasDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Pochechito
 */
@Controller
public class etapasController {


    @RequestMapping(value = "/etapas_consultarTodosJS.htm", method = RequestMethod.GET)
    public @ResponseBody
    String consultarPlantas(Model model) {
        EtapasDAO etapasDAO = new EtapasDAO();
        JJSON convertidor = new JJSON();
        return convertidor.convertirListadoEtapas(etapasDAO.obtenerEtapas());
    }


}
