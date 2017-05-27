<%-- 
    Document   : menuLateral
    Created on : 9/03/2017, 12:12:08 PM
    Author     : Pochechito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="col-xs">
    <ul class="col-xs">            
        <a href = "serviciosCRUD_consultarTodos.htm"><li class="col-xs-12"><div>Servicios</div></li></a>
        <li class="col-xs-12"><br></li>
        <a href = "clientesCRUD_consultarTodos.htm"><li class="col-xs-12"><div>Clientes</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "revisarMensajes.htm"><li class="col-xs-12"><div>Revisar mensajes</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "proveedoresCRUD_consultarTodos.htm"><li class="col-xs-12"><div>Proveedores</div></li></a>
        <li class="col-xs-12"><br></li>
        <a href = "empleadosCRUD_consultarTodos.htm"><li class="col-xs-12"><div>Empleados</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "ventas_plantas_consultarTodos.htm"><li class="col-xs-12"><div>Ventas de Plantas</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "compras_plantas_consultarTodos.htm"><li class="col-xs-12"><div>Compras de Plantas</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "reportesDeCompras.htm?tipo=0&prov=0&fi=&ff="><li class="col-xs-12" ><div onclick="refrescarTodosRC()">Reportes de compras</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "reportesDeVentas.htm?tipo=0&fi=&ff="><li class="col-xs-12" ><div>Reportes de Ventas</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "administrar_plantas.htm"><li class="col-xs-12"><div>Administrar Plantas</div></li> </a>
        <li class="col-xs-12"><br></li>
        <a href = "ingresosEgresosPlanta.htm"><li class="col-xs-12"><div>Revisar Flujo De Caja</div></li> </a>
    </ul>

</nav>