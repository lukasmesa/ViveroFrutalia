/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var clientes;
var contadorNuevos = 0;
var lineas = new Array();


function editarVenta(id) {
    window.location = "ventas_consultar.htm?id=" + id;
}
function redimensionar(i, ii, j) {
    document.getElementById("panelEdicion").setAttribute("style", " visibility: visible ");
    document.getElementById("panelVista").setAttribute("class", " col-xs-" + i + " col-xs-offset-" + ii);
    //document.getElementById("panelEdicion").setAttribute("class", " col-xs-" + j);
}
function agregarVenta() {

    $("#cedula").val = "";
    $("#nombre").val = "";
    $("#apellido").val = "";
    $("#telefono").val = "";
    $("#correo").val = "";
    redimensionar(10, 1, 10);
}
function eliminarVenta(id) {
    window.location = "ventas_eliminar.htm?id=" + id;
}

function redirigir() {
    redimensionar(8, 2, 0);
    document.getElementById("panelEdicion").setAttribute("style", " visibility: hidden ");
}

function eliminarNuevaLineaVenta(id) {
    for (var i = 0; i < lineas.length; i++) {
        if (lineas[i].attr("id").substring(11) == id) {
            lineas.splice(i, 1);
            break;
        }
    }
    $('#panelNuevo_' + id).remove();
}
function eliminarLineaVentaAdicionada(id) {
    for (var i = 0; i < lineas.length; i++) {
        if (lineas[i].attr("id").substring(11) == id) {
            lineas.splice(i, 1);
            break;
        }
    }
    $('#panelNuevo_' + id).remove();
}
function crearTDLineaVenta() {
    mensaje =
            "<td >" +
            "<div  class='col-xs-12 frm form-group'>" +
            "<div style='margin-bottom:10px;' class=' col-xs-1 col-xs-offset-11'>" +
            "<div onclick='eliminarNuevaLineaVenta(" + contadorNuevos + " )' class='btn btn-danger'>-</div>" +
            "</div>" +
            "<div class='col-xs-3'>" +
            "<label class='control-label'>Planta</label>" +
            "</div>" +
            "<div class='col-xs-9'>" +
            "<select id='planta_" + contadorNuevos + "' class='form-control'>";
    consultarPlantas();
    var plantas = JSON.parse(localStorage.getItem('plantas'));
    for (var i = 0; i < plantas.length; i++) {

        mensaje += '<option>';
        mensaje += plantas[i][1] + ' (' + plantas[i][0] + ')';
        mensaje += '</option>';
    }
    mensaje +=
            "</select>" +
            "</div>" +
            "</div>" +
            "<div class='col-xs-12 frm form-group'>" +
            "<div class='col-xs-3'>" +
            "<label class='control-label'>Etapa </label>" +
            "</div>" +
            "<div class='col-xs-9'>" +
            "    <select id='etapa_" + contadorNuevos + "' class='form-control'>";

    consultarEtapas();
    var etapas = JSON.parse(localStorage.getItem("etapas"))
    for (var i = 0; i < etapas.length; i++) {

        mensaje += '<option>';
        mensaje += (etapas[i][1] + ' (' + etapas[i][0] + ')');
        mensaje += '</option>';
    }
    mensaje += "</select>" +
            "</div>" +
            "</div>" +
            "<div class='col-xs-12 frm form-group'>" +
            "<div class='col-xs-3'>" +
            "<label class='control-label'>Cantidad </label>" +
            "</div>" +
            "<div class='col-xs-3'>" +
            "<input type='text' class='form-control' value='0'  id='cantidad_" + contadorNuevos + "' >" +
            "</div>" +
            "<div class='col-xs-3'>" +
            "<label class='control-label'>Descuento</label>" +
            "</div>" +
            "<div class='col-xs-3'>" +
            "<input type='text' class='form-control' value='0' id='descuento_" + contadorNuevos + "' >" +
            "</div>" +
            "</div>" +
            "</td>";
    contadorNuevos++;

    return mensaje;

}
function limpiar() {

    lineas = new Array();
}
function agregarNuevaLineaVenta() {
    var mensaje =
            "<tr id = 'panelNuevo_" + contadorNuevos + "'>" +
            crearTDLineaVenta() +
            "</tr>";
    var elemento = $(mensaje);
    lineas.push(elemento);

    $('#tablaPlantas').append(elemento);
}

function agregarLineaVentaAdicionada() {
    var mensaje =
            "<tr id = 'panelNuevo_" + contadorNuevos + "'> <td></td>" +
            crearTDLineaVenta() +
            "</tr>";
    var elemento = $(mensaje);
    lineas.push(elemento);
    $('#tablaPlantas').append(elemento);
}

function registrarVenta() {
    var data = {
        cliente: $("#nombreCliente").val(),
        empleado: $("#nombreEmpleado").val(),
        fecha: $("#fecha").val().replace("-", "/").replace("-", "/"),
        factura: $("#factura").val()
    };
    var lines = new Array();
    for (var i = 0; i < lineas.length; i++) {
        id = lineas[i].attr("id").substring(11);
        linea = {
            planta: $("#planta_" + id).val(),
            etapa: $("#etapa_" + id).val(),
            cantidad: $("#cantidad_" + id).val(),
            descuento: $("#descuento_" + id).val()
        };
        lines.push(linea);
    }
    data['lineas'] = lines;
    $.post("ventas_registrar.htm", {data: JSON.stringify(data)}, function (respuesta) {

        location.reload(true);
    });

}


function actualizarVenta() {

    var st = "wert";
    var t = st.replace("-", "/")
    var data = {
        id: $("#idGeneral").val(),
        cliente: $("#nombreCliente").val(),
        empleado: $("#nombreEmpleado").val(),
        fecha: $("#fecha").val().replace("-", "/").replace("-", "/"),
        factura: $("#factura").val()
    }
    var lines = new Array();
    for (var i = 0; i < lineas.length; i++) {
        id = lineas[i].attr("id").substring(11);
        linea = {
            planta: $("#planta_" + id).val(),
            etapa: $("#etapa_" + id).val(),
            cantidad: $("#cantidad_" + id).val(),
            descuento: $("#descuento_" + id).val()
        }
        lines.push(linea);
    }
    data['lineas'] = lines;


    var linesExistentes = new Array();
    $('.viejo').each(function (key, value) {
        id = value.id.substring(15);

        linea = {
            id: $("#id_" + id).val(),
            planta: $("#plantaExistente_" + id).val(),
            etapa: $("#etapaExistente_" + id).val(),
            cantidad: $("#cantidadExistente_" + id).val(),
            descuento: $("#descuentoExistente_" + id).val()
        };
        linesExistentes.push(linea);

    });
    data['lineasExistentes'] = linesExistentes;
    console.log(data);
    $.post(
            "ventas_actualizar.htm",
            {data: JSON.stringify(data)},
            function (respuesta) {
                location.reload(true);
            });



}