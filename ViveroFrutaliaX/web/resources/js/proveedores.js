/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function editarProveedor(id) {
    window.location = "proveedoresCRUD_consultar.htm?cedula="+id;
}
function redimensionar(i, ii, j) {
    document.getElementById("panelEdicion").setAttribute("style", " visibility: visible ");
    document.getElementById("panelVista").setAttribute("class", " col-xs-" + i + " col-xs-offset-" + ii);
    document.getElementById("panelEdicion").setAttribute("class", " col-xs-offset-2 col-xs-" + j);
}
function agregarProveedor() {
    
    $("#cedula").val = "";
    $("#nombre").val = "";
    $("#apellido").val = "";
    $("#telefono").val = "";
    $("#correo").val = "";
    redimensionar(10, 1, 8);
}
function eliminarProveedor(id){
        window.location = "proveedoresCRUD_eliminar.htm?cedula="+id;
}

function redirigir() {
    redimensionar(8, 2, 0);
    document.getElementById("panelEdicion").setAttribute("style", " visibility: hidden ");
}

