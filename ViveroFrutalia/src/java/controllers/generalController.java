
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Pochechito
 */
@Controller
public class generalController {

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String registrar(Model model) {
        return "index";
    }
    @RequestMapping(value = "/nosotros.htm", method = RequestMethod.GET)
    public String nosotros(Model model) {
        return "nosotros";
    }

}
