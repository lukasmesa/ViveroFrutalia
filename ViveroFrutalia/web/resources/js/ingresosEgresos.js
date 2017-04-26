/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var idUser = "";

$(document).ready(function () {

    
    $("#divFechaInicial").datetimepicker({
        format: "YYYY-MM-DD",
        locale: "es",
        defaultDate: moment()
    });
    $("#divFechaFinal").datetimepicker({
        format: "YYYY-MM-DD",
        locale: "es",
        defaultDate: moment()
    });

    $.ajax({
        type: "get",
        url: "plantas_consultarTodosJS.htm",
        success: function (respuesta) {
            console.log(respuesta);
            var datos = $.parseJSON(respuesta);
            console.log(datos);
            for (var i in datos) {
                console.log(datos[i].id + " " + datos[i].nombre);
                var contenidoGeneral =
                        "<option id=\"" + "option_" + datos[i].id + "\">\ " + datos[i].nombre + "</option>\ ";
                $("#selectPlantas").append(contenidoGeneral);
                $("#selectPlantas").selectpicker("refresh");
            }
        }
    });

    $("#btnConsultar").on("click", function (event) {
        event.preventDefault();
        var fechaInicial = moment($("#fechaInicial").val()).format('YYYY-MM-DD');
        var fechaFinal = moment($("#fechaFinal").val()).format('YYYY-MM-DD');
        var idPlanta = $("#selectPlantas option:selected").attr("id");
        idPlanta = idPlanta.substring(7);
        var ingresos;
        var egresos;
        var contenidoGeneral = "<tr>";
        var ingresosPlanta = 0;
        var egresosPlanta = 0;
        console.log("FechaInicial: " + fechaInicial + " FechaFinal: " + fechaFinal + " idPlanta: " + idPlanta);
        $.ajax({
            type: "post",
            url: "consultar_flujoIngresos.htm",
            data: {
                id: idPlanta
            },
            success: function (respuesta) {
                console.log("Ingresos: " + respuesta);
                ingresos = $.parseJSON(respuesta);
                console.log(ingresos);
                for (var i in ingresos) {
                    var fechaIngreso = moment(ingresos[i].fecha).format('YYYY-MM-DD');
                    console.log("FechaVentaPlanta: " + fechaIngreso);
                    if (moment(fechaIngreso).isBetween(moment(fechaInicial), moment(fechaFinal), null, '[)')) {
                        console.log(i + ": " + " " + ingresos[i].id);
                        console.log(i + ": " + " " + ingresos[i].nombre);
                        console.log(i + ": " + " " + ingresos[i].ingresos);
                        ingresosPlanta = ingresosPlanta + parseInt(ingresos[i].ingresos);
                    }
                }
                console.log("ingresosPlanta: "+ingresosPlanta);
                contenidoGeneral = contenidoGeneral + "<td class=\"td_nombre text-center\">\ " + ingresos[0].nombre.trim() + " </td>\<td class=\"td_ingresos text-center\">\ " + ingresosPlanta + " </td>";
                console.log(contenidoGeneral);
            }
        });
        $.ajax({
            type: "post",
            url: "consultar_flujoEgresos.htm",
            data: {
                id: idPlanta
            },
            success: function (respuesta) {
                console.log("Egresos: " + respuesta);
                egresos = $.parseJSON(respuesta);
                console.log(egresos);
                for (var j in egresos) {
                     console.log("FechaInicial: " + fechaInicial + " FechaFinal: " + fechaFinal + " idPlanta: " + idPlanta);
                    var fechaEgreso = moment(egresos[j].fecha).format('YYYY-MM-DD');
                    console.log("FechaCompraPlanta: " + fechaEgreso);                    
                    if (moment(fechaEgreso).isBetween(moment(fechaInicial), moment(fechaFinal), null, '[]')) {
                        console.log(j + ": " + " " + egresos[j].egresos);
                        egresosPlanta = egresosPlanta + parseInt(egresos[j].egresos);
                    }
                }
                console.log("egresosPlanta: "+egresosPlanta);
                contenidoGeneral = contenidoGeneral + "<td class=\"td_egresos text-center\">\ " + egresosPlanta + " </td>";
                console.log(contenidoGeneral);
                var diferencia = ingresosPlanta - egresosPlanta;
                contenidoGeneral = contenidoGeneral + "<td class=\"td_diferencia text-center\">\ " + diferencia + " </td>\</tr>;";
                console.log(contenidoGeneral);
                $("#tabla").append(contenidoGeneral);
            }
        });
    });

}//Función Global

);//Evento Global


