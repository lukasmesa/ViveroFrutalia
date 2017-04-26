<%-- 
    Document   : adminPlantas
    Created on : Apr 21, 2017, 4:21:55 PM
    Author     : Lukas
--%>

<%@page import="cl_modelos_pojos.Plantas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Catálogo De Plantas</title>        
        <jsp:include page="fragmentos/links.jsp" />
        <jsp:include page="fragmentos/scripts.jsp" />
        <script src="resources/js/plantas.js"></script>
    </head>

    <body>

        <header class="col-xs-12 col-xs" >
            <jsp:include page="fragmentos/header.jsp" />
        </header>
        <aside class="col-xs-2 col-xs">
            <jsp:include page="fragmentos/menuLateral.jsp" />
        </aside>
        <div class="modal fade" id="modalRegistro" tabindex="-1" role="dialog" aria-labelledby="modalRegistro">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <form class="form-horizontal" id="formRegistro">                    
                        <div class="modal-header">
                            <button type="button" id="btnSimboloCancelar" class="close glyphicon glyphicon-remove-sign" data-dismiss="modal"></button>
                            <h4 class="modal-title text-center">Registro De Una Nueva Planta</h4>
                        </div>
                        <div class="modal-body" style="padding-bottom:0; margin-bottom:0">                                                  
                            <div class="form-group">                                
                                <div class="col-sm-offset-1 row col-sm-10">                                
                                    <div class="text-center">
                                        <label class="control-label">Nombre</label> 
                                        <input type="text" name="txtNombreReg" class="form-control text-center" id="txtNombreReg" placeholder="Nombre de la planta">
                                    </div>
                                </div>                                
                            </div>
                            <div class="form-group">                                
                                <div class="col-sm-offset-1 row col-sm-10">                                
                                    <div class="text-center">
                                        <label class="control-label">Tipo</label> 
                                        <input type="text" name="txtTipoReg" class="form-control text-center" id="txtTipoReg" placeholder="1-Ornamental, 2-Frutal, 3-Nativa">
                                    </div>
                                </div>                                
                            </div>                                                        
                            <div class="form-group">                                
                                <div class="col-sm-offset-1 row col-sm-10">                                
                                    <div class="text-center">
                                        <label class="control-label">Descripci&oacute;n</label>
                                        <textarea name="txtDescripcionReg" class="form-control text-center" id="txtDescripcionReg" placeholder="Agregue una breve descripción"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">                                
                                <div class="col-sm-offset-1 row col-sm-10">                                
                                    <div class="text-center">
                                        <label class="control-label">Imagen</label>
                                        <input type="file" name="fileuploadReg" class="fileupload form-control text-center" id="fileuploadReg" name="files[]"  multiple>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                            </div>                            
                        </div>
                        <div class="modal-footer" style="margin-top:0">
                            <button type="button" id="btnCancelarRegistro" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary" id="btnRegistro">Registrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="modal fade" id="modalEdicion" tabindex="-1" role="dialog" aria-labelledby="modalEdicion">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <form class="form-horizontal" id="fromEdicion">                    
                        <div class="modal-header">
                            <button type="button" id="cerrarModalEdicion" class="close glyphicon glyphicon-remove-sign" data-dismiss="modal"></button>
                            <h4 class="modal-title text-center">Panel De Edici&oacute;n</h4>
                        </div>
                        <div class="modal-body" style="padding-bottom:0; margin-bottom:0">                                                  
                            <div class="form-group">                                
                                <div class="col-sm-offset-1 row col-sm-10">                                
                                    <div class="text-center">
                                        <label class="control-label">Nombre</label> 
                                        <input type="text" name="txtNombreEdit" class="form-control text-center" id="txtNombreEdit" placeholder="Nombre de la planta">
                                    </div>
                                </div>                                
                            </div>
                            <div class="form-group">                                
                                <div class="col-sm-offset-1 row col-sm-10">                                
                                    <div class="text-center">
                                        <label class="control-label">Tipo</label> 
                                        <input type="text" name="txtTipoEdit" class="form-control text-center" id="txtTipoEdit" placeholder="1-Ornamental, 2-Frutal, 3-Nativa">
                                    </div>
                                </div>                                
                            </div>                                                        
                            <div class="form-group">                                
                                <div class="col-sm-offset-1 row col-sm-10">                                
                                    <div class="text-center">
                                        <label class="control-label">Descripci&oacute;n</label>
                                        <textarea name="txtDescripcionEdit" class="form-control text-center" id="txtDescripcionEdit" placeholder="Agregue una breve descripción"></textarea>
                                    </div>
                                </div>
                            </div>                            
                            <div class="form-group">
                            </div>                            
                        </div>
                        <div class="modal-footer" style="margin-top:0">
                            <button type="button" id="btnCancelarEdicion" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary" id="btnEdicion">Actualizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="modal fade" id="modalFoto">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" id="cerrarModalFoto" class="close glyphicon glyphicon-remove-sign" data-dismiss="modal"></button>
                        <h4 class="modal-title text-center">Cambiar Imagen</h4>
                    </div>                    
                    <div class="modal-body" style="padding-bottom:0; margin-bottom:0">						
                        <div class="form-group">
                            <div id="error_output"></div>
                        </div>
                        <div class="form-group">
                            <!-- file drop zone -->
                            <div id="dropzone">
                                <i>Drop files here</i>
                                <!-- upload button -->
                                <span class="button btn-blue input-file">
                                    Browse Files <input class="fileupload" id="fileuploadCambioImagen" type="file" name="files[]"  multiple>
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="upload-wrapper">
                                <div id="files" class="files"></div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer" id="modal-footer" style="margin-top:0">                    
                        <button type="button" class="btn btn-primary" id="actualizarImagen" data-dismiss="modal">Actualizar</button>					
                    </div>					
                </div>
            </div>		
        </div>




        <div class="col-xs-10">
            <br>
            <br>
            <div class = "col-xs-12" id="contenido">                
                <div id = "panelVista" class="col-xs-10 col-xs-offset-1" style = "margin-bottom: 100px;background-color: #fff; padding: 20px;">
                    <br>
                    <table id="tabla" class="table table-hover" style = "background-color: white">
                        <thead>
                            <tr>                                
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Tipo</th>
                                <th class="text-center">Descripci&oacute;n</th>
                                <th class="text-center">Imagen</th>
                                <th class="text-center">Editar</th>
                                <th class="text-center">Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <br>
                    <div class = "col-xs-12">
                        <center><button type="button" class="btn btn-info" data-toggle="modal" data-target="#modalRegistro" id="agregarPlanta">Agregar Planta</button></center> 
                    </div>
                </div>




            </div>
        </div>



    </body>
</html>
