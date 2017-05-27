<%-- 
    Document   : serviciosDetalle
    Created on : 12/03/2017, 11:42:42 AM
    Author     : Pochechito
--%>

<%@page import="cl_modelos_pojos.Etapas"%>
<%@page import="cd_modelos_dao.EtapasDAO"%>
<%@page import="cd_modelos_dao.PlantasDAO"%>
<%@page import="cl_modelos_pojos.Proveedores"%>
<%@page import="cd_modelos_dao.ProveedoresDAO"%>
<%@page import="org.hibernate.Session"%>
<%@page import="cd_modelos_dao.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="cl_modelos_pojos.PlantasCompra"%>
<%@page import="cl_modelos_pojos.Plantas"%>
<%@page import="cl_modelos_pojos.ComprasPlanta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/compras.js" type="text/javascript"></script>
        <script src="resources/js/plantas.js" type="text/javascript"></script>
        <script src="resources/js/etapas.js" type="text/javascript"></script>


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

                <div class = "col-xs-12" id="contendio">
                    <br>
                    <br>
                    
                    <div id = "panelEdicion"  class="col-xs-8 col-xs-offset-2">
                        <% ComprasPlanta s = (ComprasPlanta) request.getAttribute("compra");%>

                        <div class="col-xs-12" style="border-left: 1px solid #eee;">
                            <br>
                            <br>
                            <div class="form-group frm col-xs-12"hidden="" >
                                <input class="control-label" id="idGeneral" value="<%= s.getId()%>" />
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Proveedor</label>
                                </div>
                                <div class="col-xs-9">
                                    <select class="form-control" id="nombreProveedor">
                                        <%
                                            ProveedoresDAO c = new ProveedoresDAO();
                                            List<Proveedores> Proveedors = c.obtenerProveedores();

                                            for (int i = 0; i < Proveedors.size(); i++) {
                                                if (Proveedors.get(i).getCedula() == s.getProveedores().getCedula()) {
                                                    out.print("<option selected>");
                                                } else {
                                                    out.print("<option>");
                                                }
                                                out.print(Proveedors.get(i).getNombreCompleto() + " (" + Proveedors.get(i).getCedula() + ")");
                                                out.print("</option>");
                                            }
                                        %>
                                    </select>

                                </div>
                            </div>
                            

                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Fecha</label>
                                </div>
                                <div class="col-xs-9">
                                    <input type="text" class="form-control" value="<%= s.getFecha()%>" id="fecha" >
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Nro. Factura</label>
                                </div>
                                <div class="col-xs-9">
                                    <input type="text" class="form-control" value="<%= s.getNroFactura()%>" id="factura" >
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-12">
                                    <label class="control-label">Plantas que se encuentran registradas</label>
                                </div>
                                <div class="col-xs-12">
                                    <table  id="tablaPlantas" class="table table-hover" style = "background-color: white">
                                        <thead>
                                            <tr>
                                                <td>Id</td>
                                                <td>Linea de Compra</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%

                                                try {
                                                    for (PlantasCompra planta : s.getPlantasCompras()) {

                                            %>
                                            <tr id="panelExistente_<%=planta.getId()%>" class="viejo">
                                                <td> 

                                                    <input  readonly="" type="text" class="form-control" value="<%=planta.getId()%>" id="id_<%=planta.getId()%>" >
                                                </td>
                                                <td >
                                                    <div class="col-xs-12 frm form-group">
                                                        <div class="col-xs-3">
                                                            <label class="control-label">Planta</label>
                                                        </div>
                                                        <div class="col-xs-9">
                                                            <select class="form-control" id="plantaExistente_<%=planta.getId()%>">
                                                                <%
                                                                    PlantasDAO plantasD = new PlantasDAO();
                                                                    List<Plantas> plantas = plantasD.obtenerPlantas();

                                                                    for (int i = 0; i < plantas.size(); i++) {
                                                                        if (plantas.get(i).getId() == planta.getEtapasPlanta().getPlantas().getId()) {
                                                                            out.print("<option selected>");
                                                                        } else {
                                                                            out.print("<option>");
                                                                        }
                                                                        out.print(plantas.get(i).getNombre() + " (" + plantas.get(i).getId() + ")");
                                                                        out.print("</option>");
                                                                    }
                                                                %>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 frm form-group">
                                                        <div class="col-xs-3">
                                                            <label class="control-label">Etapa</label>
                                                        </div>
                                                        <div class="col-xs-9">
                                                            <select class="form-control" id="etapaExistente_<%=planta.getId()%>">
                                                                <%
                                                                    EtapasDAO etapasD = new EtapasDAO();
                                                                    List<Etapas> etapas = etapasD.obtenerEtapas();

                                                                    for (int i = 0; i < etapas.size(); i++) {
                                                                        if (etapas.get(i).getId() == planta.getEtapasPlanta().getEtapas().getId()) {
                                                                            out.print("<option selected>");
                                                                        } else {
                                                                            out.print("<option>");
                                                                        }
                                                                        out.print(etapas.get(i).getNombre() + " (" + etapas.get(i).getId() + ")");
                                                                        out.print("</option>");
                                                                    }
                                                                %>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-12 frm form-group">
                                                        <div class="col-xs-3">
                                                            <label class="control-label">Cantidad</label>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <input type="text" class="form-control" value="<%=planta.getCantidad()%>" id="cantidadExistente_<%=planta.getId()%>" >
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <label class="control-label">Descuento</label>
                                                        </div>
                                                        <div class="col-xs-3">
                                                            <input type="text" class="form-control" value="<%=planta.getDescuento()%>"  id="descuentoExistente_<%=planta.getId()%>" >
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <%
                                                    }
                                                } catch (Exception em) {
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <center>
                                    <div class="col-xs-3 col-xs-offset-2">
                                        <button onclick="actualizarCompra()"class="btn btn-info" >Actualizar</button>
                                    </div>
                                    <div class="col-xs-3 col-xs-offset-2">
                                        <button  class="btn btn-warning" onclick="agregarLineaCompraAdicionada()">Nueva Linea</button>
                                    </div>
                                </center>
                            </div>
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
