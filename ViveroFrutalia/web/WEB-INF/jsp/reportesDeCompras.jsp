<%@page import="Modelos.Compra"%>
<%@page import="Modelos.ComprasProveedores"%>
<%@page import="cl_modelos_pojos.Proveedores"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/reportesDeCompras.js" type="text/javascript"></script>

    </head>

    <body>

    <header class="col-xs-12 col-xs" >
        <jsp:include page="fragmentos/header.jsp" />
    </header>
    <div class="col-xs-12 col-xs">
        <aside class="col-xs-2 col-xs">
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

                    <label style="padding: 20px">
                        Proveedores:
                    </label>

                    <select id="listaProveedores" class="form-control" style="width: 200px; display:inline" onchange="filtrarDetalleYProveedor()">
                        <option value="0">Todos</option>
                        <%
                            ComprasProveedores obj = (ComprasProveedores) request.getAttribute("reportesDeCompras");
                            for (Proveedores i : obj.getProveedores()) {
                        %>
                        <option value="<%=i.getCedula()%>"><%=i.getNombre()%> CC:<%=i.getCedula()%></option>
                        <%
                            }
                        %>    
                    </select>
                    
                    <label style="padding: 20px">
                        Fecha inicio:
                        <input type="date" id="fechaInicioRC">
                    </label>
                    <label style="padding: 20px">
                        Fecha fin:
                        <input type="date" id="fechaFinRC">
                    </label>
                    <button type="button" class="btn btn-success" onclick="habilitarFecha()">Buscar</button>
                    <button type="button" class="btn btn-info" onclick="refrescarFechasRC()">Refresh</button>    
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
                                <td>Cedula proveedor</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                //List<Compra> lista = (List<Compra>) request.getAttribute("reportesDeCompras");
                                List<Compra> lista = obj.getCompras();
                                for (Compra i : lista) {
                            %>
                            <tr onclick="mostrarDetallesDeCompra('<%=i.getId()%>', '<%=i.getDetalle()%>')" style="cursor:pointer">
                                <td> <%=i.getNroFactura()%> </td>
                                <td> <%=i.getDetalle()%> </td>
                                <td> <%=i.getFecha().toString()%> </td>
                                <td> <%=i.getCedProveedor()%> </td>
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


    <div>
        <jsp:include page="fragmentos/footer.jsp" />
    </div>
</body>
</html>
