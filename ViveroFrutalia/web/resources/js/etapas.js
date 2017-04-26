/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function consultarEtapas() {

    $.get("etapas_consultarTodosJS.htm", {}, function (respuesta) {
       localStorage.setItem("etapas", respuesta);
    });
}