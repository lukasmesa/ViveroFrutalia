<%@page import="Modelos.Venta"%>
<%@page import="Modelos.VentasProveedores"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte De Ventas</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/reportesDeVentas.js" type="text/javascript"></script>
        <script src="resources/js/indexAdmin.js"></script>

    </head>

    <body>

    <header class="col-xs-12 col-xs" >
        <jsp:include page="fragmentos/headerAdmin.jsp" />
    </header>
    <div class="col-xs-12 col-xs">
        <aside id="aside" class="col-xs-2 col-xs">
            <jsp:include page="fragmentos/menuLateral.jsp" />
        </aside>
        <div class="col-xs-10">
            <br>
            <br>
            <div class = "col-xs-12" id="contendio">
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "background-color: #fff; padding: 30px;">
                    <h4>Filtros:</h4>
                    <label style="padding: 20px">
                        Tipo de compra:
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="checkboxDetalle1" checked="" onclick="filtrarDetalleYProveedor()"> Suministros
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="checkboxDetalle2" checked="" onclick="filtrarDetalleYProveedor()"> Plantas
                    </label>

                    <div class = "col-xs-12">
                        <div class = "col-xs-6">
                            <div class = "col-xs-4">
                                <label>Fecha inicio:</label>
                            </div>
                            <div class = "col-xs-8">
                                <input class="form-control" type="date" id="fechaInicioRC">
                            </div>
                        </div>
                        <div class = "col-xs-6">
                            <div class = "col-xs-4">
                                <label>Fecha fin:</label>
                            </div>
                            <div class = "col-xs-8">
                                <input class="form-control"type="date" id="fechaFinRC">
                            </div>
                        </div>
                        <div style="margin-top: 20px;" class = "col-xs-6">

                            <button type="button" class="btn btn-success" onclick="habilitarFecha()">Buscar</button>

                            <button type="button" class="btn btn-info" onclick="refrescarFechasRC()">Refresh</button>    
                        </div>
                    </div>

                    <br>
                    <br>
                    <br>
                    <br>
                    <br>

                    <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "background-color: #fff; padding: 20px">
                        <br>
                        <table class="table table-hover" style = "background-color: white">
                            <thead>
                                <tr>
                                    <td>Nro factura</td>
                                    <td>Detalle</td>
                                    <td>Fecha</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    VentasProveedores obj = (VentasProveedores) request.getAttribute("reportesDeVentas");

                                    List<Venta> lista = obj.getVentas();
                                    for (Venta i : lista) {
                                %>
                                <tr onclick="mostrarDetallesDeVenta('<%=i.getId()%>', '<%=i.getDetalle()%>')" style="cursor:pointer">
                                    <td> <%=i.getNroFactura()%> </td>
                                    <td> <%=i.getDetalle()%> </td>
                                    <td> <%=i.getFecha().toString()%> </td>
                                </tr>
                                <%
                                    }
                                %>

                            </tbody>
                        </table>
                    </div>

                </div>
            </div>

        </div>
    </div>

    <div>
        <jsp:include page="fragmentos/footer.jsp" />
    </div>
</body>
</html>
