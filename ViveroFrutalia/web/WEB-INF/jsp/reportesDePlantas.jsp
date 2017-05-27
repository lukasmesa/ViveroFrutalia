<%-- 
    Document   : consultarProductos
    Created on : May 21, 2017, 12:02:44 AM
    Author     : Angie
--%>
<%@page import="cl_modelos_pojos.Suministros"%>
<%@page import="Modelos.Reporte"%>
<%@page import="Modelos.PlantaReporte"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Catálogo De Productos</title>        
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/reportesDePlantas.js"></script>
    </head>

    <body>
        <header class="col-xs-12 col-xs" >
            <jsp:include page="fragmentos/header.jsp" />
        </header>
        <div class="col-xs-12 col-xs">
            <aside id="aside" class="col-xs-2 col-xs">
            </aside>
            <div class="col-xs-10">
                <br>
                <br>
                <div class = "col-xs-12" id="contendio">
                    <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "background-color: #fff; padding: 30px;">
                        <h4>Cat&aacute;logo de productos:</h4>
                        <label style="padding: 20px">
                            Productos:
                        </label>
                        <button type="button" class="btn btn-success" onclick="MostrarAmbos()">Todos</button>
                        <button type="button" class="btn btn-success" onclick="mostrarPlantas()">Plantas</button>
                        <button type="button" class="btn btn-success" onclick="mostrarSuministros()">Suministros</button>

                        <label class="col-xs-10" style="padding: 20px">
                            Filtro por precio:
                        </label>
                        <div>
                            <label style="padding: 20px" >
                                Precio Min:
                                <input type="number" id="fechaInicioRC">
                            </label>
                            <label style="padding: 20px" >
                                Precio Max:
                                <input type="number" id="fechaFinRC">
                            </label>
                            <button type="button" class="btn btn-success" onclick="">Buscar</button>
                            <button type="button" class="btn btn-info" onclick="">Refresh</button>    
                        </div>
                    </div>

                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <%
                        Reporte obj = (Reporte) request.getAttribute("reportesDePlantas");
                    %>
                    
                    <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "background-color: #fff; padding: 20px">
                        <br>
                        <table class="table table-hover" style = "background-color: white">
                            <thead>
                                <tr>
                                    <td>Tipo</td>
                                    <td>Nombre</td>
                                    <td>Detalle</td>
                                    <td>Imagen</td>
                                    <td>Precio</td>
                                </tr>
                            </thead>
                            <tbody>
                                <%                                List<Suministros> listaS = obj.getSuministros();
                                    List<PlantaReporte> listaP = obj.getPlantas();
                                    if (!listaP.isEmpty()) {
                                        for (PlantaReporte i : listaP) {
                                %>
                                <tr>
                                    <td>Planta</td>
                                    <td> <%=i.getNombre()%> </td>
                                    <td> <%=i.getDescripcion()+" Etapa: "+i.getEtapa()%>  </td>
                                    <td> <img src="resources/img/<%=i.getImagen()%>" onmouseover="this.width = 500;this.height = 400;" onmouseout="this.width = 100;this.height = 80;" width="100" height="80" alt="" /></td>
                                    <td align="right">$ <%=i.getPrecio()%>.00 </td>
                                </tr>
                                <%
                                        }
                                    }
                                    if (!listaS.isEmpty()) {
                                        for (Suministros s : listaS) {
                                %>
                                <tr>
                                    <td>Suministro</td>
                                    <td> <%=s.getNombre()%> </td>
                                    <td> <%=s.getDescripcion()%>  </td>
                                    <td> <img src="resources/img/7173.jpeg" onmouseover="this.width = 500;this.height = 400;" onmouseout="this.width = 100;this.height = 80;" width="100" height="80" alt="" /></td>
                                    <td align="right">$ <%=s.getPrecioVenta()%>.00 </td>
                                </tr>
                                <%
                                        }
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
