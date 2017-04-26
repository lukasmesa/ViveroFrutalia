/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var banderaFecha = false;

function mostrarDetallesDeCompra(id, detalle) {
    if (detalle !== "SUMINISTRO") {
        window.location = "detallesDeCompraPlanta.htm?id=" + id;
    } else {
        window.location = "detallesDeCompraSuministro.htm?id=" + id;
    }
}

function irAReportesCompra() {
    window.location = "reportesDeCompras.htm?tipo=0&prov="+ localStorage.getItem("cedProv") +"&fi=&ff=";
}

function filtrarDetalleYProveedor() {

    var fechaIn = ordenarFecha("fechaInicioRC");
    var fechaFin = ordenarFecha("fechaFinRC");

    localStorage.setItem("fechaInicioRC", document.getElementById("fechaInicioRC").value);
    localStorage.setItem("fechaFinRC", document.getElementById("fechaFinRC").value);

    banderaFecha = false;

    var check1 = document.getElementById("checkboxDetalle1").checked;
    var check2 = document.getElementById("checkboxDetalle2").checked;

    var cedProv = $("#listaProveedores").val();
    localStorage.setItem("cedProv", cedProv);

    if (check1 && check2) {
        localStorage.setItem("checkboxDetalle1", true);
        localStorage.setItem("checkboxDetalle2", true);
        window.location = "reportesDeCompras.htm?tipo=0&prov=" + cedProv + "&fi=" + fechaIn + "&ff=" + fechaFin;
    }
    if (!check1 && !check2) {
        localStorage.setItem("checkboxDetalle1", false);
        localStorage.setItem("checkboxDetalle2", false);
        window.location = "reportesDeCompras.htm?tipo=0&prov=" + cedProv + "&fi=" + fechaIn + "&ff=" + fechaFin;
    }
    if (check1 && !check2) {
        localStorage.setItem("checkboxDetalle1", true);
        localStorage.setItem("checkboxDetalle2", false);
        window.location = "reportesDeCompras.htm?tipo=2&prov=" + cedProv + "&fi=" + fechaIn + "&ff=" + fechaFin;
    }
    if (!check1 && check2) {
        localStorage.setItem("checkboxDetalle1", false);
        localStorage.setItem("checkboxDetalle2", true);
        window.location = "reportesDeCompras.htm?tipo=1&prov=" + cedProv + "&fi=" + fechaIn + "&ff=" + fechaFin;
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

$(document).ready(function () {
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

    $('#listaProveedores > option[value="' + localStorage.getItem("cedProv") + '"]').attr('selected', 'selected');

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
    localStorage.setItem("cedProv", "0");
    localStorage.setItem("checkboxDetalle1", "true");
    localStorage.setItem("checkboxDetalle2", "true");
    $("#checkboxDetalle1").prop("checked", true);
    $("#checkboxDetalle2").prop("checked", true);
    $('#listaProveedores > option[value=0]').attr('selected', 'selected');
}