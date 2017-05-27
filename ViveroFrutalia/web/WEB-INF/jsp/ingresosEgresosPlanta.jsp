<%-- 
    Document   : ingresosEgresosPlanta
    Created on : Apr 22, 2017, 12:02:44 AM
    Author     : Lukas
--%>

<%@page import="cl_modelos_pojos.Plantas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Flujo De Caja</title>        
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/ingresosEgresos.js"></script>
    </head>

    <body>

        <header class="col-xs-12 col-xs" >
            <jsp:include page="fragmentos/headerAdmin.jsp" />
        </header>
        <aside id="aside" class="col-xs-2 col-xs">
            <jsp:include page="fragmentos/menuLateral.jsp" />
        </aside>

        <div class="col-xs-10">
            <br>
            <br>
            <div class = "col-xs-12" id="contenido">                
                <h1 id="titulo" class="col-xs-offset-3">Consulta de ingresos y egresos planta</h1>
                <br>
                <div id="datosConsulta" class="col-sm-offset-2 col-sm-10">
                    <div class="row">
                        <div class="form-group">                
                            <div class="row col-sm-10">
                                <div class="col-sm-3">
                                    <div class="text-center">
                                        <label class="control-label">Fecha Inicial</label>
                                        <div class="input-group date" id="divFechaInicial">
                                            <input type="text" id="fechaInicial" name="fechaInicial" class="form-control" placeholder="Ingrese la fecha inicial"/>
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-offset-2 col-sm-3">
                                    <div class="text-center">
                                        <label class="control-label">Fecha Final</label>
                                        <div class="input-group date" id="divFechaFinal">
                                            <input type="text" id="fechaFinal" name="fechaFinal" class="form-control" placeholder="Ingrese la fecha final"/>
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-offset-1 col-sm-3">
                                    <div class="text-center">
                                        <label class="control-label">Nombre De La Planta</label>
                                        <div class="input-group" id="divSelectPlantas">
                                            <select id="selectPlantas" name="selectPlantas" class="selectpicker from-control"></select>
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-grain"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <br>
                            <br>
                            <div id="botonConsultarFlujo" class="col-sm-offset-3">        
                                <button id="btnConsultar" name="btnConsultar" class="col-sm-5 btn btn-info center-block">Consultar Flujo</button>
                            </div>
                        </div>            
                    </div>
                </div>     
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "margin-bottom: 100px;background-color: #fff; padding: 20px;">
                    <table id="tabla" class="table table-hover" style = "background-color: white">
                        <thead>
                            <tr>                                
                                <th class="text-center">Planta</th>
                                <th class="text-center">Ingresos</th>
                                <th class="text-center">Egresos</th>
                                <th class="text-center">Diferencia</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
