<%-- 
    Document   : otro
    Created on : 7/03/2017, 09:29:38 PM
    Author     : Pochechito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${requestScope.nombre}</h1>
        <h1>${requestScope.descripcion}</h1>
        <h1>${requestScope.costo}</h1>
    </body>
</html>
