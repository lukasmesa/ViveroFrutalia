<%-- 
    Document   : serviciosDetalle
    Created on : 12/03/2017, 11:42:42 AM
    Author     : Pochechito
--%>

<%@page import="cl_modelos_pojos.Empleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="cl_modelos_pojos.Servicios"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/empleados.js" type="text/javascript"></script>


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
                    <div id = "panelEdicion"  class="col-xs-8 col-xs-offset-2">
                        <% Empleados s = (Empleados) request.getAttribute("empleado");%>

                        <div class="col-xs-12" style="border-left: 1px solid #eee;">
                            <br>
                            <br>
                            <form class = "col-xs-12" action="empleadosCRUD_actualizar.htm" method="post">
                                <div class="form-group frm col-xs-12">
                                    <div class="col-xs-3">
                                        <label class="control-label">Cedula</label>
                                    </div>
                                    <div class="col-xs-6">
                                        <input type="text" class="form-control" value="<%= s.getCedula()%>" name="cedula" id="id">
                                    </div>
                                </div>

                                <div class="form-group frm col-xs-12">
                                    <div class="col-xs-3">
                                        <label class="control-label">Nombre</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" value="<%= s.getNombre()%>" name="nombre" id="nombre" >
                                    </div>
                                </div>
                                <div class="form-group frm col-xs-12">
                                    <div class="col-xs-3">
                                        <label class="control-label">Apellido</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" value="<%= s.getApellido()%>" name="apellido" id="apellido" >
                                    </div>
                                </div>
                                <div class="form-group frm col-xs-12">
                                    <div class="col-xs-3">
                                        <label class="control-label">Telefono</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" value="<%= s.getTelefono()%>" name="telefono" id="telefono" >
                                    </div>
                                </div>
                                <div class="form-group frm col-xs-12">
                                    <div class="col-xs-3">
                                        <label class="control-label">Correo</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" value="<%= s.getCorreo()%>" name="correo" id="correo" >
                                    </div>
                                </div>
                                <div class="form-group frm col-xs-12">
                                    <div class="col-xs-3">
                                        <label class="control-label">Hoja de vida</label>
                                    </div>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" value="<%= s.getHojaDeVida()%>" name="hoja_vida" id="hoja_vida" >
                                    </div>
                                </div>
                                
                            

                                <div class="form-group frm col-xs-12">
                                    <center>
                                        <div class="col-xs-8 col-xs-offset-2">
                                            <input type="submit" class="btn btn-info" value="Actualizar">
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
