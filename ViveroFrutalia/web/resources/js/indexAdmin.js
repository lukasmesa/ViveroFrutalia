/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    
    $("#btnCerrarSesion").on("click", function (){
        if (localStorage.usuario !== undefined) {
            localStorage.removeItem("usuario");            
        } else{
            console.log("LocalStorage es " + localStorage.usuario);
        }
        window.location = "index.htm";
    });

    console.log(localStorage.usuario);

    if (localStorage.usuario !== undefined) {
        $("#dropCerrar").append("Sesion iniciada como " + localStorage.usuario + "<span class='glyphicon glyphicon-log-out'></span>");        
        $("#aside").attr('style', "background-color:#333333");
        $("#aside").show();
    } else {
        console.log("error " + localStorage.usuario);
    }

});
