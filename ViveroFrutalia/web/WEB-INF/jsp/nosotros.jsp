
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


            <div class="col-xs-6">
                <p>Misión</p>
            </div>
            <div class="col-xs-6">
                <p>Visión</p>

            </div>
        </div>
    </div>




    <div>
        <jsp:include page="fragmentos/footer.jsp" />
    </div>
</body>
</html>
