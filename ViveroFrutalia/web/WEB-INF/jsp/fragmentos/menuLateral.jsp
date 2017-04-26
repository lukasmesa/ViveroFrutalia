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
        <a href = "clientesCRUD_consultarTodos.htm"><li class="col-xs-12"><div>Clientes</div></li> </a>
        <a href = "proveedoresCRUD_consultarTodos.htm"><li class="col-xs-12"><div>Proveedores</div></li></a>
        <a href = "empleadosCRUD_consultarTodos.htm"><li class="col-xs-12"><div>Empleados</div></li> </a>
        <a href = "ventas_plantas_consultarTodos.htm"><li class="col-xs-12"><div>Ventas de Plantas</div></li> </a>
        <a href = "compras_plantas_consultarTodos.htm"><li class="col-xs-12"><div>Compras de Plantas</div></li> </a>
        <a href = "reportesDeCompras.htm?tipo=0&prov=0&fi=&ff="><li class="col-xs-12" ><div onclick="refrescarTodosRC()">Reportes de compras</div></li> </a>
        <a href = "reportesDeVentas.htm?tipo=0&fi=&ff="><li class="col-xs-12" ><div>Reportes de Ventas</div></li> </a>
        <a href = "administrar_plantas.htm"><li class="col-xs-12"><div>Administrar Plantas</div></li> </a>
        <a href = "ingresosEgresosPlanta.htm"><li class="col-xs-12"><div>Revisar Flujo De Caja</div></li> </a> 
    </ul>

</nav>