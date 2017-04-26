<%@page import="cd_modelos_dao.EmpleadosDAO"%>
<%@page import="cd_modelos_dao.ClientesDAO"%>
<%@page import="cl_modelos_pojos.Empleados"%>
<%@page import="cl_modelos_pojos.Clientes"%>
<%@page import="cl_modelos_pojos.VentasPlanta"%>
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
        <script src="resources/js/ventas.js" type="text/javascript"></script>
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
                                <td>Cliente</td>
                                <td>Empleado</td>
                                <td>Fecha</td>
                                <td>Factura</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<VentasPlanta> lista = (List<VentasPlanta>) request.getAttribute("ventas");
                                try {

                                    for (VentasPlanta i : lista) {
                                        Clientes aux = i.getClientes();
                                        Empleados aux2 = i.getEmpleados();
                            %>
                            <tr>
                                <td> <%=i.getId()%> </td>
                                <td> <%=i.getClientes().getCedula()%>  </td>
                                <td> <%=i.getEmpleados().getCedula()%> </td>
                                <td> <%=i.getFecha()%> </td>
                                <td> <%=i.getNroFactura()%> </td>
                                <td>
                                    <button class="btn btn-danger"  onclick="eliminarVenta('<%=i.getId()%>')"      id="eliminar_<%=i.getId()%>">X</button>

                                    <button class="btn btn-default" onclick="editarVenta('<%=i.getId()%>')" id="editar_<%=i.getId()%>">V</button>
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
                        <center><button class=" btn btn-info" onclick="agregarVenta()">Agregar Venta</button></center> 
                    </div>
                </div>


                <div id = "panelEdicion"  class="col-xs-10 col-xs-offset-1" style="visibility: hidden;">

                    <div class="col-xs-12" style="border-left: 1px solid #eee;">
                        <br>

                        <form class = "col-xs-12" action="ventas_registrar.htm" method="post">


                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Cliente</label>
                                </div>
                                <div class="col-xs-9">

                                    <select class="form-control" name="nombreCliente" id="nombreCliente">


                                        <%
                                            ClientesDAO c = new ClientesDAO();
                                            List<Clientes> clientes = c.obtenerClientes();
                                            for (int i = 0; i < clientes.size(); i++) {
                                                out.print("<option>");
                                                out.print(clientes.get(i).getNombreCompleto() + " (" + clientes.get(i).getCedula() + ")");
                                                out.print("</option>");
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Empleado</label>
                                </div>
                                <div class="col-xs-9">

                                    <select class="form-control" name="nombreEmpleado" id="nombreEmpleado">
                                        <%
                                            EmpleadosDAO e = new EmpleadosDAO();
                                            List<Empleados> empleados = e.obtenerEmpleados();
                                            for (int i = 0; i < empleados.size(); i++) {
                                                out.print("<option>");
                                                out.print(empleados.get(i).getNombreCompleto() + " (" + empleados.get(i).getCedula() + ")");
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
                                    <label class="control-label">Plantas correspondientes a la Venta</label>
                                    <p>Ingrese las plantas que se vendieron con su respectiva cantidad, tamaño y descuento</p>
                                </div>
                                <div class="form-group frm col-xs-2" >
                                    <div class="btn btn-default" onclick="agregarNuevaLineaVenta()">Nuevo</div>
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
                                            <div  onclick="registrarVenta()" class="btn btn-info" >Registrar</div>
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
