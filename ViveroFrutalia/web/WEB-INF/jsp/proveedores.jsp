<%@page import="cl_modelos_pojos.Proveedores"%>
<%@page import="java.util.List"%>
<%@page import="cl_modelos_pojos.Servicios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedores</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/proveedores.js" type="text/javascript"></script>


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
                <br>
                <br>
                <br>
                <br>
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = " margin-bottom: 100px;background-color: #fff; padding: 20px;">
                    <br>
                    <table class="table table-hover" style = "background-color: white">
                        <thead>
                            <tr>
                                <td>Cedula</td>
                                <td>Nombre</td>
                                <td>Apellido</td>
                                <td>Telefono</td>
                                <td>Correo</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Proveedores> lista = (List<Proveedores>) request.getAttribute("proveedores");
                                for (Proveedores i : lista) {
                            %>
                            <tr>
                                <td> <%=i.getCedula()%> </td>
                                <td> <%=i.getNombre()%> </td>
                                <td> <%=i.getApellido()%> </td>
                                <td> <%=i.getTelefono()%> </td>
                                <td> <%=i.getCorreo()%> </td>
                                <td>
                                    <button class="btn btn-danger"  onclick="eliminarProveedor('<%=i.getCedula()%>')"      id="eliminar_<%=i.getCedula()%>">X</button>

                                    <button class="btn btn-default" onclick="editarProveedor('<%=i.getCedula()%>')" id="editar_<%=i.getCedula()%>">V</button>
                                </td>
                            </tr>
                            <%
                                }
                            %>

                        </tbody>
                    </table>
                    <p>



                    </p>
                    <div class = "col-xs-12">
                        <center><button class=" btn btn-info" onclick="agregarProveedor()">Agregar proveedor</button></center> 
                    </div>
                </div>
              


                <div id = "panelEdicion"  class="col-xs-8 col-xs-offset-2" style="visibility: hidden;">

                    <div class="col-xs-12" style="border-left: 1px solid #eee;">
                        <br>
                        <br>
                        <form class = "col-xs-12" action="proveedoresCRUD_registrar.htm" method="post">


                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Nombre del proveedore</label>
                                </div>
                                <div class="col-xs-9">
                                    <input type="text" class="form-control"  name="nombre" id="nombre">
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Apellido</label>
                                </div>
                                <div class="col-xs-9">
                                    <textarea class="form-control" name="apellido" id="apellido" placeholder="Apellido"></textarea>
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Cedula</label>
                                </div>
                                <div class="col-xs-9">
                                    <textarea class="form-control" name="cedula" id="cedula"></textarea>
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Telefono</label>
                                </div>
                                <div class="col-xs-9">
                                    <textarea class="form-control" name="telefono" id="telefono"></textarea>
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label col-xs-3">Correo</label>
                                </div>
                                <div class="col-xs-9">
                                    <input type="text" class="form-control" name="correo" id="correo">
                                </div>
                            </div>

                            <div class="form-group frm col-xs-12">
                                <center>
                                    <div class="col-xs-8 col-xs-offset-2">
                                        <input type="submit" class="btn btn-info" value="Registrar">
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
