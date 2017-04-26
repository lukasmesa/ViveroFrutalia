<%@page import="cl_modelos_pojos.SuministrosVenta"%>
<%@page import="cl_modelos_pojos.SuministrosCompra"%>
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
        <script src="resources/js/reportesDeVentas.js" type="text/javascript"></script>

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
                <br>
                <br>

                <br>
                <br>
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "background-color: #fff; padding: 20px;">
                    <button type="button" class="btn btn-success" onclick="irAReportesVenta()">Atrás</button>
                    <br>
                    <table class="table table-hover" style = "background-color: white">
                        <thead>
                            <tr>
                                <td>id</td>
                                <td>suministro</td>
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
                                try {
                                    
                                    List<SuministrosVenta> lista = (List<SuministrosVenta>) request.getAttribute("reportesDeVentasSuministro");
                                    for (SuministrosVenta i : lista) {
                            %>
                            <tr>
                                <td> <%=i.getId()%> </td>
                                <td> <%=i.getSuministros().getId()%> </td>
                                <td> <%=i.getCantidad()%> </td>
                                <td> <%=i.getDescuento()%> </td>
                                <td> <%=i.getSuministros().getPrecioCompra()%> </td>
                                <td> <%=i.getSuministros().getPrecioVenta()%> </td>
                            </tr>
                            <%
                                        totalCompra += (i.getCantidad() * i.getSuministros().getPrecioCompra());
                                        totalDescuento += i.getDescuento();
                                    }
                                } catch (Exception e) {
                                    out.print(e);
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
