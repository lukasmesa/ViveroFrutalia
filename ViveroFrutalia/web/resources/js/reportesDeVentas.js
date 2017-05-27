/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var banderaFecha = false;

function mostrarDetallesDeVenta(id, detalle) {
    if (detalle !== "SUMINISTRO") {
        window.location = "detallesDeVentaPlanta.htm?id=" + id;
    } else {
        window.location = "detallesDeVentaSuministro.htm?id=" + id;
    }
}

function irAReportesVenta() {
    window.location = "reportesDeVentas.htm?tipo=0&fi=&ff=";
}

function filtrarDetalleYProveedor() {

    var fechaIn = ordenarFecha("fechaInicioRC");
    var fechaFin = ordenarFecha("fechaFinRC");

    localStorage.setItem("fechaInicioRC", document.getElementById("fechaInicioRC").value);
    localStorage.setItem("fechaFinRC", document.getElementById("fechaFinRC").value);

    banderaFecha = false;

    var check1 = document.getElementById("checkboxDetalle1").checked;
    var check2 = document.getElementById("checkboxDetalle2").checked;


    if (check1 && check2) {
        localStorage.setItem("checkboxDetalle1", true);
        localStorage.setItem("checkboxDetalle2", true);
        window.location = "reportesDeVentas.htm?tipo=0&fi=" + fechaIn + "&ff=" + fechaFin;
    }
    if (!check1 && !check2) {
        localStorage.setItem("checkboxDetalle1", false);
        localStorage.setItem("checkboxDetalle2", false);
        window.location = "reportesDeVentas.htm?tipo=0&fi=" + fechaIn + "&ff=" + fechaFin;
    }
    if (check1 && !check2) {
        localStorage.setItem("checkboxDetalle1", true);
        localStorage.setItem("checkboxDetalle2", false);
        window.location = "reportesDeVentas.htm?tipo=2&fi=" + fechaIn + "&ff=" + fechaFin;
    }
    if (!check1 && check2) {
        localStorage.setItem("checkboxDetalle1", false);
        localStorage.setItem("checkboxDetalle2", true);
        window.location = "reportesDeVentas.htm?tipo=1&fi=" + fechaIn + "&ff=" + fechaFin;
    }
}

function ordenarFecha(id) {
    if (banderaFecha) {
        var fecha = document.getElementById(id).value;
        if (fecha === "") {
            return "";
        } else {
            var fecha = fecha.split("-");
            return fecha[2] + "-" + fecha[1] + "-" + fecha[0];
        }
    } else {
        return "";
    }

}

function habilitarFecha() {
    banderaFecha = true;
    filtrarDetalleYProveedor();
}

$(function () {
        
    if (localStorage.getItem("checkboxDetalle1") === "true") {
        $("#checkboxDetalle1").prop("checked", true);
    }
    if (localStorage.getItem("checkboxDetalle1") === "false") {
        $("#checkboxDetalle1").prop("checked", false);
    }
    if (localStorage.getItem("checkboxDetalle2") === "true") {
        $("#checkboxDetalle2").prop("checked", true);
    }
    if (localStorage.getItem("checkboxDetalle2") === "false") {
        $("#checkboxDetalle2").prop("checked", false);
    }

    
    $("#fechaInicioRC").prop("value", localStorage.getItem("fechaInicioRC"));
    $("#fechaFinRC").prop("value", localStorage.getItem("fechaFinRC"));

});


function refrescarFechasRC() {
    $("#fechaInicioRC").prop("value", "");
    $("#fechaFinRC").prop("value", "");
}

function refrescarTodosRC() {
    refrescarFechasRC();
    localStorage.setItem("fechaInicioRC", "");
    localStorage.setItem("fechaFinRC", "");
    localStorage.setItem("checkboxDetalle1", "true");
    localStorage.setItem("checkboxDetalle2", "true");
    $("#checkboxDetalle1").prop("checked", true);
    $("#checkboxDetalle2").prop("checked", true);
}