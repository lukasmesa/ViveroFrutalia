<%-- 
    Document   : panelEdicion
    Created on : 9/03/2017, 12:32:14 PM
    Author     : Pochechito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id = "panelEdicion"  class="col-xs-8 col-xs-offset-2"style="width: 0px; height: 0px; visibility: hidden">
    <div class="col-xs-12" style="border-left: 1px solid #eee;">
        <div class="col-xs-1 col-xs-offset-11">
            <button class="btn btn-danger" onclick="redirigir()">X</button>
        </div>
        <br>
        <br>
        <form class = "col-xs-12" action="serviciosCRUD_registrar.htm" method="post">
            <div class="form-group frm col-xs-12">
                <div class="col-xs-3">
                    <label class="control-label">Nombre del servicio</label>
                </div>

                <div class="col-xs-9">
                    <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Servicio">
                </div>
            </div>
            <div class="form-group frm col-xs-12">
                <div class="col-xs-3">
                    <label class="control-label">Descripción</label>
                </div>
                <div class="col-xs-9">
                    <textarea class="form-control" name="descripcion" id="descripcion" placeholder="Descripción"></textarea>
                </div>
            </div>
            <div class="form-group frm col-xs-12">
                <div class="col-xs-3">
                    <label class="control-label col-xs-3">Costo</label>
                </div>
                <div class="col-xs-9">
                    <input type="text" class="form-control" name="costo" id="costo">
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
