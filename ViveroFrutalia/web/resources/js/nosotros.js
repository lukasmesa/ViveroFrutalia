/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("#modalInfoContacto").on("shown.bs.modal", function () {
        init();
    });


});

function init() {

    var_location = new google.maps.LatLng(5.028933, -75.476577);//new google.maps.LatLng(-34.397,150.644);

    var myOptions = {
        zoom: 16,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: var_location
    };



    map = new google.maps.Map(document.getElementById("map"), myOptions);


    /*var address = 'Japan';
     var map = new google.maps.Map(document.getElementById('map'), { 
     zoom: 16
     });*/
    var geocoder = new google.maps.Geocoder();
    
    var marker = new google.maps.Marker({
                map: map,
                position: var_location
            });

    /*document.getElementById("buscarLugar").addEventListener('click', function () {
        geocodeAddress(geocoder, map);

        }

    );*/

}


function geocodeAddress(geocoder, resultsMap) {
    console.log("geocodeAddress");
    var address = document.getElementById("lugar").value;
    geocoder.geocode({"address": address}, function (results, status) {
        if (status === google.maps.GeocoderStatus.OK) {

            console.log(results);

            var descripcion;


            //var apiMaps = $.parseJSON(results);
            //console.log(apiMaps);

            $.each(results, function (i, item) {
                console.log(item.formatted_address);

                descripcion = item.formatted_address;
                ubicacion = descripcion.split(",");

                console.log(ubicacion[0]);

                console.log(item.geometry);
                console.log(item.geometry.bounds);
                console.log(item.geometry.location);
                console.log(item.place_id);

            });

            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: resultsMap,
                position: results[0].geometry.location
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });

}


