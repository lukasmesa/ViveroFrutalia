var validatorReg;
var validatorEdit;
var idPlanta;
var imagenPlanta;
var tipoPlanta;
var descripcionPlanta;
var nombrePlanta;

$(function () {

    /*validatorEdit = $("#formEdicion").validate({
        rules: {
            txtNombreEdit: "required",
            txtTipoEdit: "required",
            txtDescripcionEdit: "required"
        },
        messages: {
            txtNombreReg: "Nombre no puede ser vacío",
            txtTipoReg: "Apellido no puede ser vacío",
            txtDescripcionReg: "La Descripción es obligatoria"
        }
    });*/

    validatorReg = $("#formRegistro").validate({
        rules: {
            txtNombreReg: "required",
            txtTipoReg: "required",
            txtDescripcionReg: "required",
            fileupload: "required"

        },
        messages: {
            txtNombreReg: "Nombre no puede ser vacío",
            txtTipoReg: "Apellido no puede ser vacío",
            txtDescripcionReg: "La Descripción es obligatoria",
            fileupload: "Debe elegir una imagen"
        }
    });

    console.log(validatorReg);
    //console.log(validatorEdit);
//Función limpiar datos del registro con el botón de cancelar
    $("#btnCancelarRegistro").click(function () {
        limpiarCamposRegistro();
    });
//Función limpiar datos del panel de edicion con el botón de cancelar
    $("#btnCancelarEdicion").click(function () {
        limpiarCamposEdicion();
    });
//Función limpiar datos cambio de imagen con el botón de cancelar
    $("#btnCancelarFoto").click(function () {
        limpiarCamposImagen()();
    });
//Función limpiar datos del registro con el símbolo de cancelar 
    $("#btnSimboloCancelar").click(function () {
        limpiarCamposRegistro();
    });
//Función limpiar datos del registro con el símbolo de cancelar 
    $("#cerrarModalEdicion").click(function () {
        limpiarCamposEdicion();
    });
//Función limpiar datos del registro con el símbolo de cancelar 
    $("#cerrarModalFoto").click(function () {
        limpiarCamposImagen()();
    });

    cargarTabla();
    $('#modalEdicion').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        idPlanta = button.attr("id");
        var td_nombre = button.closest("tr").find(".td_nombre").text();
        var td_tipo = button.closest("tr").find(".td_tipo").text();
        var td_descripcion = button.closest("tr").find(".td_descripcion").text();
        imagenPlanta = button.closest("tr").find(".td_imagen").text();
        console.log(idPlanta);
        console.log(td_nombre);
        console.log(td_tipo);
        console.log(td_descripcion);
        var modal = $(this);
        modal.find("#txtNombreEdit").val(td_nombre);
        modal.find("#txtTipoEdit").val(td_tipo);
        modal.find("#txtDescripcionEdit").val(td_descripcion);
    });
    $("#formRegistro").on("submit", function (e) {
        e.preventDefault();
        if ($("#formRegistro").valid()) {
            var nombre = $("#txtNombreReg").val().trim();
            var tipo = $("#txtTipoReg").val().trim();
            var descripcion = $("#txtDescripcionReg").val().trim();
            var imagen = $("#fileuploadReg").val();
            imagen = imagen.substring(12);
            console.log("Nombre: " + nombre + "\nTipo: " + tipo + "\nDescripcion: " + descripcion + "\nImagen: " + imagen);
            $.ajax({
                type: "post",
                url: "registrar_planta.htm",
                data: {
                    nombre: nombre,
                    tipo: tipo,
                    descripcion: descripcion,
                    imagen: imagen
                },
                success: function (respuesta) {
                    console.log(respuesta);
                    $("#formRegistro").trigger("reset");
                    $('#modalRegistro').modal('toggle');
                    $("#tabla tbody").empty();
                    cargarTabla();
                }
            });
        }
    });

    $("#fromEdicion").on("submit", function (e) {
        e.preventDefault();
        console.log(validatorEdit);
        console.log($("#fromEdicion").valid());
        if ($("#fromEdicion").valid()) {
            var id = idPlanta.substring(10);
            console.log(idPlanta + " - id: " + id);
            var nombre = $("#txtNombreEdit").val().trim();
            var tipo = $("#txtTipoEdit").val().trim();
            var descripcion = $("#txtDescripcionEdit").val().trim();
            var imagen = imagenPlanta;
            console.log(imagenPlanta + " - imagen: " + imagenPlanta);
            console.log("Nombre: " + nombre + "\nTipo: " + tipo + "\nDescripcion: " + descripcion + "\nImagen: " + imagen);
            $.ajax({
                type: "post",
                url: "editar_planta.htm",
                data: {
                    id: id,
                    nombre: nombre,
                    tipo: tipo,
                    descripcion: descripcion,
                    imagen: imagen
                },
                success: function (respuesta) {
                    console.log(respuesta);
                    $("#formEdicion").trigger("reset");
                    $('#modalEdicion').modal('toggle');
                    $("#tabla tbody").empty();
                    cargarTabla();
                    idPlanta = " ";
                    imagenPlanta = " ";
                }
            });
        }
    });

    $('#modalFoto').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        idPlanta = button.attr("id");
        nombrePlanta = button.closest("tr").find(".td_nombre").text();
        tipoPlanta = button.closest("tr").find(".td_tipo").text();
        descripcionPlanta = button.closest("tr").find(".td_descripcion").text();
        console.log(idPlanta);
        console.log(nombrePlanta);
        console.log(tipoPlanta);
        console.log(descripcionPlanta);
    });

    $("#actualizarImagen").on("click", function () {
        var id = idPlanta.substring(13);
        console.log(idPlanta + " - id: " + id);
        var nombre = nombrePlanta.trim();
        var tipo = tipoPlanta.trim();
        var descripcion = descripcionPlanta.trim();
        var imagen = $("#fileuploadCambioImagen").val();     
        imagen = imagen.substring(12);
        console.log("Nombre: " + nombre + "\nTipo: " + tipo + "\nDescripcion: " + descripcion + "\nImagen: " + imagen);
        $.ajax({
            type: "post",
            url: "editar_planta.htm",
            data: {
                id: id,
                nombre: nombre,
                tipo: tipo,
                descripcion: descripcion,
                imagen: imagen
            },
            success: function (respuesta) {
                console.log(respuesta);
                $("#modalFoto").modal('hide');
                $("#tabla tbody").empty();
                cargarTabla();
                idPlanta = " ";
                nombrePlanta = " ";
                tipoPlanta = " ";
                descripcionPlanta = " ";
            }
        });
    });



    $("#tabla").on("click", ".btnEliminar", function () {
        var id = $(this).attr("id");
        id = id.substring(12);
        console.log(id);
        $.ajax({
            type: "post",
            url: "eliminar_planta.htm",
            data: {
                id: id
            },
            success: function (respuesta) {
                console.log(respuesta);
                $("#tabla tbody").empty();
                cargarTabla();
            }
        });
    });

});
function cargarTabla() {
    $.get("plantas_consultarTodosJS.htm", {}, function (respuesta) {
        console.log("Cargo");
        console.log(respuesta);
        var datos = JSON.parse(respuesta);
        console.log("Datos: " + datos);
        for (var i in datos) {
            console.log(i + ": " + " " + datos[i].id);
            console.log(i + ": " + " " + datos[i].nombre);
            console.log(i + ": " + " " + datos[i].descripcion);
            console.log(i + ": " + " " + datos[i].tipo);
            console.log(i + ": " + " " + datos[i].imagen);
            var contenidoGeneral = "<tr>\
             <td class=\"td_nombre text-center\">\ " + datos[i].nombre + " </td>\
             <td class=\"td_tipo text-center\">\ " + datos[i].tipo + " </td>\
             <td class=\"td_descripcion text-center\">\ " + datos[i].descripcion + " </td>\
             <td class=\"td_imagen text-center\">\ " + datos[i].imagen + " </td>\
             <td class=\"text-center\">\ <button id=\"" + "btnEditar_" + datos[i].id + "\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#modalEdicion\"><span class=\"glyphicon glyphicon-pencil\"> </span> </button>\ <button id=\"" + "editarImagen_" + datos[i].id + "\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#modalFoto\"><span class=\"glyphicon glyphicon-camera\"> </span> </button>\</td>\
             <td class=\"text-center\">\ <button id=\"" + "btnEliminar_" + datos[i].id + "\" class=\"btnEliminar btn btn-danger\"><span class=\"glyphicon glyphicon-trash\"> </span> </button>\ </td>\
             </tr>;";
            $("#tabla").append(contenidoGeneral);
        }
    }
    );
}

function cargarArchivo() {

    'use strict';
    var fi = $(".fileupload"); //file input 
    var process_url = "../Includes/File-Upload/Php/Upload.php"; //PHP script
    var progressBar = $('<div/>').addClass('progress').append($('<div/>').addClass('progress-bar')); //progress bar
    var uploadButton = $('<button/>').addClass('button btn-blue upload').text('Upload'); //upload button

    uploadButton.on('click', function () {
        var $this = $(this), data = $this.data();
        data.submit().always(function () {
            $this.parent().find('.progress').show();
            $this.parent().find('.remove').remove();
            $this.remove();
        });
    });
    //initialize blueimp fileupload plugin
    fi.fileupload({
        url: process_url,
        dataType: 'json',
        autoUpload: false,
        //acceptFileTypes: /(\.|\/)(gif|jpe?g|png|mp4|mp3)$/i,
        //maxFileSize: 1048576, //1MB
        // Enable image resizing, except for Android and Opera,
        // which actually support image resizing, but fail to
        // send Blob objects via XHR requests:
        disableImageResize: /Android(?!.*Chrome)|Opera/
                .test(window.navigator.userAgent),
        previewMaxWidth: 50,
        previewMaxHeight: 50,
        previewCrop: true,
        dropZone: $('#dropzone')
    });
    console.log(fi);
    fi.on('fileuploadadd', function (e, data) {
        data.context = $('<div/>').addClass('file-wrapper').appendTo('#files');
        $.each(data.files, function (index, file) {
            var node = $('<div/>').addClass('file-row');
            var removeBtn = $('<button/>').addClass('button btn-red remove').text('Remove');
            removeBtn.on('click', function (e, data) {
                console.log(e);
                console.log(data);
                $(this).parent().parent().remove();
            });
            console.log(e);
            var file_txt = $('<div/>').addClass('file-row-text').append('<span>' + file.name + ' (' + format_size(file.size) + ')' + '</span>');
            file_txt.append(removeBtn);
            file_txt.prependTo(node).append(uploadButton.clone(true).data(data));
            progressBar.clone().appendTo(file_txt);
            if (!index) {
                console.log(e);
                node.prepend(file.preview);
            }
            console.log(e);
            node.appendTo(data.context);
        });
    });
    fi.on('fileuploadprocessalways', function (e, data) {
        var index = data.index,
                file = data.files[index],
                node = $(data.context.children()[index]);
        if (file.preview) {
            console.log(e);
            node.prepend(file.preview);
        }
        if (file.error) {
            console.log(e);
            node.append($('<span class="text-danger"/>').text(file.error));
            console.log(file.error);
        }
        if (index + 1 === data.files.length) {
            console.log(e);
            data.context.find('button.upload').prop('disabled', !!data.files.error);
        }
    });
    fi.on('fileuploadprogress', function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        if (data.context) {
            data.context.each(function () {
                $(this).find('.progress').attr('aria-valuenow', progress).children().first().css('width', progress + '%').text(progress + '%');
                console.log(e);
            });
        }
    });
    fi.on('fileuploaddone', function (e, data) {
        $.each(data.result.files, function (index, file) {
            if (file.url) {
                console.log(file);
                console.log(file.url);
                if (file.url !== "") {
                    var datos;
                    datos = {"oper": "cargarArchivo", "correo": idUser, "archivo": file.url};
                    console.log(data);
                    $.ajax({
                        type: "post",
                        url: "../Controlador/ControladorHome.php",
                        data: datos,
                        success: function (respuesta) {
                            console.log(respuesta);
                            //$("#formNuevoArticulo").trigger("reset");
                            //$('#modalArticulo').modal('toggle');
                        }
                    });
                }

                console.log(e);
                var link = $('<a>').attr('target', '_blank').prop('href', file.url);
                $(data.context.children()[index]).addClass('file-uploaded');
                $(data.context.children()[index]).find('canvas').wrap(link);
                $(data.context.children()[index]).find('.file-remove').hide();
                var done = $('<span class="text-success"/>').text('Uploaded!');
                $(data.context.children()[index]).append(done);
            } else if (file.error) {
                var error = $('<span class="text-danger"/>').text(file.error);
                $(data.context.children()[index]).append(error);
                console.log(file.error);
                console.log(e);
            }
        });
    });
    fi.on('fileuploadfail', function (e, data) {
        $('#error_output').html(data.jqXHR.responseText);
        console.log(data.jqXHR.responseText);
        console.log(e);
    });
    function format_size(bytes) {
        if (typeof bytes !== 'number') {
            return '';
        }
        if (bytes >= 1000000000) {
            return (bytes / 1000000000).toFixed(2) + ' GB';
        }
        if (bytes >= 1000000) {
            return (bytes / 1000000).toFixed(2) + ' MB';
        }
        return (bytes / 1000).toFixed(2) + ' KB';
    }
}

function limpiarCamposRegistro() {

    validatorReg.resetForm();
    $("#txtNombreReg").val("");
    $("#txtTipoReg").val("");
    $("#txtDescripcionReg").val("");
    $("#fileupload").val("");
}

function limpiarCamposEdicion() {

    validatorEdit.resetForm();
    $("#txtNombreEdit").val("");
    $("#txtTipoEdit").val("");
    $("#txtDescripcionEdit").val("");
}

function limpiarCamposImagen() {

    $("#fileuploadCambioImagen").val("");
}