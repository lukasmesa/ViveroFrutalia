/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function editarEmpleado(id) {
    window.location = "empleadosCRUD_consultar.htm?cedula="+id;
}
function redimensionar(i, ii, j) {
    document.getElementById("panelEdicion").setAttribute("style", " visibility: visible ");
    document.getElementById("panelVista").setAttribute("class", " col-xs-" + i + " col-xs-offset-" + ii);
    document.getElementById("panelEdicion").setAttribute("class", " col-xs-" + j);
}
function agregarEmpleado() {
    
    $("#cedula").val = "";
    $("#nombre").val = "";
    $("#apellido").val = "";
    $("#telefono").val = "";
    $("#correo").val = "";
    $("#hoja_vida").val = "";
    redimensionar(10, 1, 10);
}
function eliminarEmpleado(id){
        window.location = "empleadosCRUD_eliminar.htm?cedula="+id;
}

function redirigir() {
    redimensionar(8, 2, 0);
    document.getElementById("panelEdicion").setAttribute("style", " visibility: hidden ");
}

