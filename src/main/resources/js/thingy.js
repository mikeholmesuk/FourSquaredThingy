$(document).ready(function() {
    console.log('ready');

    // Search by place name (blindly, without cleaning input)
    $('#search_button').click(function(e) {
        getSearchResults($('#search_field').val());
    })

    // Basic function to clear down the search field
    $('#clear_button').click(function(e) {
        $('#search_field').val('');
    })
});

function getSearchResults() {
    console.log('Getting search results');

    $('#search_results').empty();

    var searchTerm = $('#search_field').val();

    $.ajax('./api/thing/near/' + searchTerm, {
        success: function(data) {
            // Error checking maybe?
            $('#search_results').append("<div id='map'></div><div id='thingy_results'></div>");

            generateCentredmap(data.geo_location.longitude, data.geo_location.latitude);

            renderThingies(data.thingies);
        },
        error: function(err) {
            console.error('err: ', err);
        }
    })
}

function generateCentredmap(longitude, latitude) {

    var map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.MapQuest({layer: 'osm'})
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([longitude, latitude]),
            zoom: 15
        })
    });
}

function renderThingies(thingies) {
    console.log('Rendering ' + thingies.length + ' results');

    var resultsRow = $('#thingy_results').append("<div class='row'></div>");

    thingies.forEach(function(thingy) {
        $('#thingy_results').append(
            "<div class='col-sm-12 col-md-6'>" +
                "<div class='panel panel-default'>" +
                    "<div class='panel-heading'>" +
                        "<div class='panel-title'>" + thingy.name + "</div>" +
                    "</div>" +
                    "<div class='panel-body'>" +
                        "<p>Address: " + thingy.address + "</p>" +
                        "<p>Post-Code: " + thingy.post_code + "</p>" +
                        "<p>Geo Loction: " + thingy.geo_location.longitude + ": " + thingy.geo_location.latitude + "</p>" +
                    "</div>" +
            "</div>");
    })
}