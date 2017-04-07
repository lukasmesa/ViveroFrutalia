/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function editarServicio(id) {
    window.location = "serviciosCRUD_consultar.htm?id="+id;
}
function redimensionar(i, ii, j) {
    document.getElementById("panelEdicion").setAttribute("style", " visibility: visible ");
    document.getElementById("panelVista").setAttribute("class", " col-xs-" + i + " col-xs-offset-" + ii);
    document.getElementById("panelEdicion").setAttribute("class", " col-xs-" + j);
}
function agregarServicio() {
    document.getElementById("nombre").value = "";
    document.getElementById("descripcion").value = "";
    redimensionar(6, 0, 6);
}
function eliminarServicio(id){
    
        window.location = "serviciosCRUD_eliminar.htm?id="+id;

    
}


function redirigir() {
    redimensionar(8, 2, 0);
    document.getElementById("panelEdicion").setAttribute("style", " visibility: hidden ");
}

