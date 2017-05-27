<%@page import="java.util.List"%>
<%@page import="cl_modelos_pojos.Servicios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/servicios.js" type="text/javascript"></script>


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
                <div id = "panelVista" class="col-xs-8 col-xs-offset-2" style = "">
                    <br>
                    <table class="table table-hover" style = "background-color: white">
                        <thead>
                            <tr>
                                <td>Nombre</td>
                                <td>Descripcion</td>
                                <td>Operaciones</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Servicios> lista = (List<Servicios>) request.getAttribute("servicios");
                                for (Servicios i : lista) {
                            %>
                            <tr>
                                <td> <%=i.getNombre()%> </td>
                                <td> <%=i.getDescripcion()%> </td>
                                <td>
                                    <button class="btn btn-danger"  onclick="eliminarServicio('<%=i.getId()%>')"      id="eliminar_<%=i.getId()%>">X</button>

                                    <button class="btn btn-default" onclick="editarServicio('<%=i.getId()%>')" id="editar_<%=i.getId()%>">V</button>
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
                        <center><button class=" btn btn-info" onclick="agregarServicio()">Agregar Servicio</button></center> 
                    </div>
                </div>


                <div id = "panelEdicion"  class="col-xs-8 col-xs-offset-2" style="visibility: hidden;">

                    <div class="col-xs-12" style="border-left: 1px solid #eee;">
                        <br>
                        <br>
                        <form class = "col-xs-12" action="serviciosCRUD_registrar.htm" method="post">


                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-12">
                                    <label class="control-label">Nombre del servicio</label>
                                </div>
                                <div class="col-xs-12">
                                    <input type="text" class="form-control"  name="nombre" id="nombre" placeholder="Servicio">
                                </div>
                            </div>
                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-12">
                                    <label class="control-label">Descripción</label>
                                </div>
                                <div class="col-xs-12">
                                    <textarea class="form-control" name="descripcion" id="descripcion" placeholder="Descripción"></textarea>
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
