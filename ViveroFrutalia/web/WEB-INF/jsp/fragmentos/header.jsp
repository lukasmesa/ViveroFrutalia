<%-- 
    Document   : header
    Created on : 9/03/2017, 11:34:42 AM
    Author     : Pochechito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-xs-12">    
    <nav class="navbar navbar-default">
        <div class="container col-lg-offset-1 col-xs-10">
            <div class="navbar-header">
                <a href="index.htm" class="navbar-brand">Vivero Frutalia</a>
            </div>
            <div  class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-left">                                                        
                    <li id="liCatalogo">
                        <a href="reportesDePlantas.htm?tipo=0&pm=&px=">Cat&aacute;logo 
                            <span ></span>
                        </a>
                    </li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a href = "enviarMensajes.htm">Enviar mensaje </a></li> 
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li><a></a></li>
                    <li id="liQuienesSomos">
                        <a href="nosotros.htm">Quienes somos 
                            <span ></span>
                        </a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" id="dropIniciar" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            Iniciar Sesi&oacute;n
                            <span class="glyphicon glyphicon-log-in"></span></a>
                        <ul class="dropdown-menu dropdown-menu-right" id="dropdownMenu">
                            <div id="dropdown-login">
                                <form id="formIniciarSesion">
                                    <li>
                                        <div class="col-xs-offset-1 form-group">
                                            <label for="txtCorreo">Correo</label>
                                            <input type="email" class="form-control" name="txtCorreo" id="txtCorreo" placeholder="Correo">
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col-xs-offset-1 form-group">
                                            <label for="txtPass">Contraseña</label>
                                            <input type="password" class="form-control" name="txtPass" id="txtPass" placeholder="Contraseña">
                                        </div>
                                    </li>
                                    <li class="center-block">
                                        <div class="col-xs-offset-1 form-group">
                                            <button type="submit" class="btn btn-success btn-block" id="btnEntrar">
                                                <span class="glyphicon glyphicon-off"></span> Iniciar Sesi&oacute;n</button>
                                        </div>
                                    </li>
                                    <li></li>
                                    <li></li>
                                </form>
                                <div class="clearfix"></div>
                            </div>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
</div>
