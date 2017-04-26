<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vivero Frutalia</title>
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
    </head>
    <body>
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
                <div class = "col-xs-12 row">
                    <div class = "col-xs-8">
                        <p class="lead text-success" align="justify">

                            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                            Mauris vitae malesuada lorem, eget blandit justo.
                            Nam bibendum posuere augue, porttitor fermentum lorem feugiat eget.
                            Mauris auctor felis quis justo cursus, vitae porta felis varius. Nam sodales pulvinar dolor, non sagittis tortor fringilla in. Phasellus risus elit, scelerisque eget pellentesque eget, rutrum at nunc. Praesent vitae maximus ipsum. Suspendisse luctus, dui eu sollicitudin consectetur, nunc enim tincidunt ligula, vel vehicula ipsum massa ut turpis. Sed tristique faucibus felis, a blandit eros luctus eu. Ut sodales viverra augue vel lobortis.
                        </p>
                    </div>
                    <div class = "col-xs-4">
                        <img class="img-rounded img-thumbnail" src="resources/img/index.jpg" width="300">
                    </div>
                </div>

                <div class = "col-xs-12 row">
                    <div class = "col-xs-4">
                        <div class="panel panel-default">

                            <div class="panel-body">
                                Plantas Decorativas
                            </div>
                            <div class="panel-body">
                                Plantas Maderables
                            </div>
                            <div class="panel-body">
                                Arboles Frutales
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-8">
                        Aenean neque elit, imperdiet quis aliquam vel, faucibus ac odio.
                        Duis sollicitudin blandit leo ut hendrerit. Duis eros neque, fringilla sit amet fermentum sed, euismod id nunc. Donec venenatis sollicitudin lectus, nec condimentum urna tempus id. Maecenas ac bibendum lectus, at finibus leo. Donec placerat vehicula laoreet. Nunc finibus lectus nulla, ac tempor sem molestie vitae. Etiam ultrices hendrerit turpis, at facilisis ipsum pellentesque quis. Morbi lacinia libero at molestie placerat. Etiam iaculis pellentesque diam, non pellentesque tortor pharetra ut. Fusce orci leo, gravida commodo lacus eget, imperdiet porta mauris. Nunc rutrum et lorem non tristique. 
                    </div>
                </div>

            </div>


            <div>
                <jsp:include page="fragmentos/footer.jsp" />
            </div>
        </div>
    </div>
</body>
</html>