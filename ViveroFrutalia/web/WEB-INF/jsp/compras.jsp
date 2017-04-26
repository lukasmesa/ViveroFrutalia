<%@page import="cd_modelos_dao.ProveedoresDAO"%>
<%@page import="cd_modelos_dao.EmpleadosDAO"%>
<%@page import="cd_modelos_dao.ProveedoresDAO"%>
<%@page import="cl_modelos_pojos.Proveedores"%>
<%@page import="cl_modelos_pojos.ComprasPlanta"%>
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
        <script src="resources/js/compras.js" type="text/javascript"></script>
        <script src="resources/js/plantas.js" type="text/javascript"></script>
        <script src="resources/js/etapas.js" type="text/javascript"></script>


    </head>

    <body onload="limpiar()">

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
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "margin-bottom: 100px;background-color: #fff; padding: 20px;">
                    <br>
                    <table class="table table-hover" style = "background-color: white">
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Proveedor</td>
                                <td>Fecha</td>
                                <td>Factura</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<ComprasPlanta> lista = (List<ComprasPlanta>) request.getAttribute("compras");
                                try {

                                    for (ComprasPlanta i : lista) {

                            %>
                            <tr>
                                <td> <%=i.getId()%> </td>
                                <td> <%=i.getProveedores().getCedula()%>  </td>
                                <td> <%=i.getFecha()%> </td>
                                <td> <%=i.getNroFactura()%> </td>
                                <td>
                                    <button class="btn btn-danger"  onclick="eliminarCompra('<%=i.getId()%>')"      id="eliminar_<%=i.getId()%>">X</button>

                                    <button class="btn btn-default" onclick="editarCompra('<%=i.getId()%>')" id="editar_<%=i.getId()%>">V</button>
                                </td>
                            </tr>
                            <%
                                }
                            } catch (Exception e) {%>
                        <p> <%=e%>
                        </p>
                        <%  }
                        %>

                        </tbody>
                    </table>
                    <p>



                    </p>
                    <div class = "col-xs-12">
                        <center><button class=" btn btn-info" onclick="agregarCompra()">Agregar Compra</button></center> 
                    </div>
                </div>


                <div id = "panelEdicion"  class="col-xs-10 col-xs-offset-1" style="visibility: hidden;">

                    <div class="col-xs-12" style="border-left: 1px solid #eee;">
                        <br>

                        <form class = "col-xs-12" action="compras_registrar.htm" method="post">


                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Proveedor</label>
                                </div>
                                <div class="col-xs-9">

                                    <select class="form-control" name="nombreProveedor" id="nombreProveedor">


                                        <%
                                            ProveedoresDAO c = new ProveedoresDAO();
                                            List<Proveedores> proveedors = c.obtenerProveedores();
                                            for (int i = 0; i < proveedors.size(); i++) {
                                                out.print("<option>");
                                                out.print(proveedors.get(i).getNombre()+ " (" + proveedors.get(i).getCedula() + ")");
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
                                    <input type="text" class="form-control" value="2015-12-4" name="fecha" id="fecha" placeholder="2015-12-4">
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Nro. Factura</label>
                                </div>
                                <div class="col-xs-9">
                                    <input type="text" class="form-control" name="factura" id="factura">
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12" >
                                <div class="form-group frm col-xs-10" >
                                    <label class="control-label">Plantas correspondientes a la Compra</label>
                                    <p>Ingrese las plantas que se vendieron con su respectiva cantidad, tamaño y descuento</p>
                                </div>
                                <div class="form-group frm col-xs-2" >
                                    <div class="btn btn-default" onclick="agregarNuevaLineaCompra()">Nuevo</div>
                                </div>
                                <div class="form-group frm col-xs-12" >
                                    <table id="tablaPlantas" class="table table-hover" style = "background-color: white">

                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="form-group frm col-xs-12">
                                    <center>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <div  onclick="registrarCompra()" class="btn btn-info" >Registrar</div>
                                        </div>
                                    </center>
                                </div>
                        </form>
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
