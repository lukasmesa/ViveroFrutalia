<%@page import="cl_modelos_pojos.Mensajes"%>
<%@page import="cd_modelos_dao.MensajesDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revisar Mensajes</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/mensaje.js" type="text/javascript"></script>


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
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "width: 800px;height: 400px;margin-bottom: 100px;background-color: #fff; padding: 20px; overflow-y: scroll">
                    
                    <table class="table table-hover" style = "background-color: white">
                        <thead>
                        <center>MENSAJES</center>
                        <br>
                            <tr>
                                <td>Nombre</td>
                                <td>Correo</td>
                                <td>Fecha</td>
                                <td>Mensaje</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Mensajes> lista = new MensajesDAO().obtenerMensajes();
                                for (Mensajes i : lista) {
                            %>
                            <tr>
                                <td> <%=i.getNombreCompleto()%> </td>
                                <td> <%=i.getCorreo()%> </td>
                                <td> <%=i.getFecha()%> </td>
                                <td> <p style="width: 200px;"><%=i.getMensaje()%></p> </td>
                            </tr>
                            <%
                                }
                            %>

                        </tbody>
                    </table>
                    <p>

            </div>
        </div>

    </div>


    <div>
        <jsp:include page="fragmentos/footer.jsp" />
    </div>
</body>
</html>
