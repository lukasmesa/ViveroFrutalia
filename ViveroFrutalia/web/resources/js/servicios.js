/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("#btnCerrarSesion").on("click", function () {
        if (localStorage.usuario !== undefined) {
            localStorage.removeItem("usuario");
        } else {
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

function editarServicio(id) {
    window.location = "serviciosCRUD_consultar.htm?id=" + id;
}
function redimensionar(i, ii, j) {
    document.getElementById("panelEdicion").setAttribute("style", " visibility: visible ");
    document.getElementById("panelVista").setAttribute("class", " col-xs-" + i + " col-xs-offset-" + ii);
    document.getElementById("panelEdicion").setAttribute("class", " col-xs-offset-1  col-xs-" + j);
}
function agregarServicio() {
    document.getElementById("nombre").value = "";
    document.getElementById("descripcion").value = "";
    redimensionar(6, 0, 5);
}
function eliminarServicio(id) {

    window.location = "serviciosCRUD_eliminar.htm?id=" + id;


}


function redirigir() {
    redimensionar(8, 2, 0);
    document.getElementById("panelEdicion").setAttribute("style", " visibility: hidden ");
}

