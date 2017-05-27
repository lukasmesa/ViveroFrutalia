<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviar Mensaje</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
    </head>

    <body>

    <header class="col-xs-12 col-xs" >
        <jsp:include page="fragmentos/header.jsp" />
    </header>
    <div class="col-xs-12 col-xs">
        <aside class="col-xs-2 col-xs">
        </aside>
        <div class="col-xs-10">
            <br>
            <br>
            <div class = "col-xs-12" id="contendio">
                <br>
                <br>
                <br>
                <br>
                </p>

                <div id = "panelEdicion"  class="col-xs-8 col-xs-offset-2">

                    <div class="col-xs-12" style="border-left: 1px solid #eee;">
                        <br>
                        <br>
                        <form class = "col-xs-12" action="registrarMensaje.htm" method="post">


                            <div class="form-group frm col-xs-12">
                                <div class="col-xs-3">
                                    <label class="control-label">Nombre completo</label>
                                </div>
                                <div class="col-xs-9">
                                    <input type="text" class="form-control"  name="nombre" id="nombreCompleto">
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
                                <div class="col-xs-3">
                                    <label class="control-label col-xs-3">Mensaje</label>
                                </div>
                                <div class="col-xs-9">
                                    <textarea class="form-control" name="mensaje" id="mensaje" placeholder="Escriba su mensaje aquí."></textarea>
                                </div>
                            </div>
                            

                            <div class="form-group frm col-xs-12">
                                <center>
                                    <div class="col-xs-8 col-xs-offset-2">
                                        <input type="submit" class="btn btn-info" value="Enviar mensaje">
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
