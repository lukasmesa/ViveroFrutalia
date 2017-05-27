/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var idUser = "";


$(function () {

        //menuAdministrador();
        
    var validatorLogIn = $("#formIniciarSesion").validate({
        rules: {
            txtCorreo: "required",
            txtPass: {
                required: true,
                minlength: 8,
                maxlength: 16
            }
        },
        messages: {
            txtCorreo: "Correo requerido",
            txtPass: {
                required: "Contraseña requerida",
                minlength: "La contraseña debe tener al menos 8 caracteres",
                maxlength: "la contraseña debe tener menos de 16 caracteres"
            }
        }
    });

    $("#dropIniciar").click(function () {
        validatorLogIn.resetForm();
        $("#txtCorreo").val("");
        $("#txtPass").val("");
    });



    $("#formIniciarSesion").on("submit", function (event) {
        event.preventDefault();
        if ($("#formIniciarSesion").valid()) {
            var correo = $("#txtCorreo").val();
            var clave = $("#txtPass").val();
            console.log("Correo: " + correo + "\nPass: " + clave);
            $.post({
                url: "usuario_iniciarSesion.htm",
                data: {
                    correo: correo,
                    clave: clave
                },
                success: function (respuesta) {
                    console.log(respuesta);
                    var datos = $.parseJSON(respuesta);
                    console.log(datos);
                    localStorage.setItem("usuario", datos.correo);
                    window.location = "indexAdmin.htm";
                    /*for (var i in datos) {
                     console.log(datos[i].id + " " + datos[i].nombre);
                     var contenidoGeneral =
                     "<option id=\"" + "option_" + datos[i].id + "\">\ " + datos[i].nombre + "</option>\ ";
                     $("#selectPlantas").append(contenidoGeneral);
                     $("#selectPlantas").selectpicker("refresh");
                     }*/
                }

            });
        }
    });

}//Función Global

);//Evento Global


function menuAdministrador() {
    console.log(localStorage.usuario);

    if (localStorage.usuario !== undefined) {
        $("#dropCerrar").append("Sesion iniciada como " + localStorage.usuario + "<span class='glyphicon glyphicon-log-out'></span>");
        $("#aside").attr('style', "background-color:#333333");
        $("#aside").show();
    } else {
        console.log("error " + localStorage.usuario);
    }
    
}