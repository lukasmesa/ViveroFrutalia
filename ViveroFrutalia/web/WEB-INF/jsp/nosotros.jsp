
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quienes Somos</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBi3lI-8H_rBz2IQf5bRsna93WqIT3rYK0&"></script>
        <script src="resources/js/nosotros.js"></script>
    </head>
    <body>
    <header id="header" class="col-xs-12 col-xs">
        <jsp:include page="fragmentos/header.jsp" />
    </header>
    <aside id="aside" class="col-xs-2 col-xs">
    </aside>
    <div class="modal fade" id="modalInfoContacto" tabindex="-1" role="dialog" aria-labelledby="modalInfoContacto">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" id="btnSimboloCancelar" class="close glyphicon glyphicon-remove-sign" data-dismiss="modal"></button>
                    <h4 class="modal-title text-center">Informaci&oacute;n De Contacto</h4>
                </div>
                <div class="modal-body" style="padding-bottom:0; margin-bottom:0">						

                    <div class="form-group">
                        <div class="modal-header">						
                            <h4 class="modal-title text-center">Vivero Frutalia</h4>
                        </div>
                    </div>

                    <div class="form-group" style="width: 727px; height: 300px;">
                        <div class="row col-sm-1"></div>
                        <div class="row col-sm-11">
                            <div class="col-sm-offset-1">
                                <div class="center-block">
                                    <div id="map" class="center-block" style="width: 727px; height: 300px;"></div>
                                </div></div>
                        </div>								
                    </div>
                    <div class="form-group">
                        <div class="text-center">
                            <label class="control-label col-xs-3">Direcci&oacute;n</label> 
                            <output type="text" name="txtDireccion" class="text-center col-xs-9" id="txtDireccion">Sector Chupaderos</output>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="text-center">
                            <label class="control-label col-xs-3">Tel&eacute;fono</label> 
                            <output type="text" name="txtTelefono" class="form-inline text-center col-xs-9" id="txtTelefono">8745466</output>
                        </div>
                    </div>
                </div>               

                <div class="modal-footer">
                    <center><button type="button" id="btnCerrarInfoContacto" class="btn btn-danger" data-dismiss="modal">Cerrar</button></center>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xs-10 col-xs" id="container-fluid">
        <h1 id="titulo" class="col-xs-12 text-center">Marco Institucional</h1>
        <br>
        <div class="col-xs-4">
            <h3 id="tituloMision">Misi&oacute;n</h3>
            <p id="textoMision">Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                Mauris vitae malesuada lorem, eget blandit justo.
                Nam bibendum posuere augue, porttitor fermentum lorem feugiat eget.
                Mauris auctor felis quis justo cursus, vitae porta felis varius. Nam sodales pulvinar dolor, non sagittis tortor fringilla in. Phasellus risus elit, scelerisque eget pellentesque eget, rutrum at nunc. Praesent vitae maximus ipsum. Suspendisse luctus, dui eu sollicitudin consectetur, nunc enim tincidunt ligula, vel vehicula ipsum massa ut turpis. Sed tristique faucibus felis, a blandit eros luctus eu. Ut sodales viverra augue vel lobortis.</p>
        </div>
        <div class="col-xs-offset-2 col-xs-4">
            <br>
            <br>
            <h3 id="tituloVision">Visi&oacute;n</h3>
            <p id="textoVision">Aenean neque elit, imperdiet quis aliquam vel, faucibus ac odio.
                Duis sollicitudin blandit leo ut hendrerit. Duis eros neque, fringilla sit amet fermentum sed, euismod id nunc. Donec venenatis sollicitudin lectus, nec condimentum urna tempus id. Maecenas ac bibendum lectus, at finibus leo. Donec placerat vehicula laoreet. Nunc finibus lectus nulla, ac tempor sem molestie vitae. Etiam ultrices hendrerit turpis, at facilisis ipsum pellentesque quis. Morbi lacinia libero at molestie placerat. Etiam iaculis pellentesque diam, non pellentesque tortor pharetra ut. Fusce orci leo, gravida commodo lacus eget, imperdiet porta mauris. Nunc rutrum et lorem non tristique.</p>
        </div>
        <br>
        <br>
        <div id="botonInformacionContacto" class="col-sm-offset-3">        
            <center><button type="button" id="infoContacto" name="infoContacto" class="col-sm-5 btn btn-info center-block" data-toggle="modal" data-target="#modalInfoContacto" >Informaci&oacute;n De Conctacto</button></center>
        </div>
    </div>
    <br>
    <br>
    <br>
    <div>
        <jsp:include page="fragmentos/footer.jsp" />
    </div>
</body>
</html>
