<%@page import="cl_modelos_pojos.PlantasCompra"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte De Compras</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/reportesDeCompras.js" type="text/javascript"></script>

    </head>

    <body>

    <header class="col-xs-12 col-xs" >
    </header>
    <div class="col-xs-12 col-xs">
        <aside id="aside" class="col-xs-2 col-xs">
            <jsp:include page="fragmentos/menuLateral.jsp" />
        </aside>
        <div class="col-xs-10">
            <br>
            <br>
            <div class = "col-xs-12" id="contendio">
                <br>
                <br>
                
                <br>
                <br>
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "background-color: #fff; padding: 20px;">
                    <button type="button" class="btn btn-success" onclick="irAReportesCompra()">Atrás</button>
                    <br>
                    <table class="table table-hover" style = "background-color: white">
                        <thead>
                            <tr>
                                <td>id</td>
                                <td>id Compra planta</td>
                                <td>id planta</td>
                                <td>id etapa</td>
                                <td>Planta</td>
                                <td>Cantidad</td>
                                <td>Descuento</td>
                                <td>Precio compra</td>
                                <td>Precio venta</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int totalCompra = 0;
                                int totalDescuento = 0;
                                List<PlantasCompra> lista = (List<PlantasCompra>) request.getAttribute("reportesDeComprasPlanta");
                                for (PlantasCompra i : lista) {
                            %>
                            <tr>
                                <td> <%=i.getId()%> </td>
                                <td> <%=i.getComprasPlanta().getId()%> </td>
                                <td> <%=i.getEtapasPlanta().getPlantas().getId()%> </td>
                                <td> <%=i.getEtapasPlanta().getEtapas().getId()%> </td>
                                <td> <%=i.getEtapasPlanta().getPlantas().getNombre()%> </td>
                                <td> <%=i.getCantidad()%> </td>
                                <td> <%=i.getDescuento()%> </td>
                                <td> <%=i.getEtapasPlanta().getPrecioCompra()%> </td>
                                <td> <%=i.getEtapasPlanta().getPrecioVenta()%> </td>
                            </tr>
                            <%
                                totalCompra += (i.getCantidad() * i.getEtapasPlanta().getPrecioCompra());
                                totalDescuento += i.getDescuento();
                                }
                            %>
                        </tbody>
                    </table>
                    <center><h4>Compra: <%=totalCompra%> ----- Total descuento <%=totalDescuento%></h4></center>
                    <center><h4>Total Compra: <%=(totalCompra - totalDescuento)%></h4></center>    
                </div>

            </div>
        </div>

    </div>


    <div>
        <jsp:include page="fragmentos/footer.jsp" />
    </div>
</body>
</html>
