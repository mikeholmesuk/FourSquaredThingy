<html>
<head>
    <title>Thingy! | By Mike Holmes</title>

    <#-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,300|Roboto+Condensed:400,300' rel='stylesheet' type='text/css'>
    <#-- Bootstrap styles -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <#-- jQuery -->
    <script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
    <#-- Bootstrap scripts-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <#-- More iconfonts -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

    <#-- Thingy styles and scripts -->
    <link rel="stylesheet" type="text/css" href="css/thingy.css">
    <script src="js/thingy.js" type="application/javascript"></script>

    <#-- Maps -->
    <link rel="stylesheet" href="http://openlayers.org/en/v3.15.1/css/ol.css" type="text/css">
    <style>
        .map {
            height: 400px;
            width: 100%;
        }
    </style>
    <script src="http://openlayers.org/en/v3.15.1/build/ol.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <h1><i class="fa fa-foursquare" aria-hidden="true"></i> Four Squared Thingy</h1>
    </div>
    <div class="row">
        <div class="col-md-12">
            <p class="lead">This is a very (very) basic application demoing integration with the <i class="fa fa-foursquare" aria-hidden="true"></i>
                Four Square API.</p>
        </div>
        <div class="col-sm-12 col-md-12">
            <div class="input-group input-group-lg">
                <span class="input-group-btn">
                   <button class="btn btn-default btn-danger" type="button" id="clear_button">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                    </button>
                </span>
                <input type="text" class="form-control" placeholder="Search area here..." id="search_field">
                <span class="input-group-btn">
                    <button class="btn btn-default btn-primary" type="button" id="search_button">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> Do the thing!</button>
                </span>
            </div>
        </div>
        <hr />
    </div>
    <div class="row">
        <div id="map" class="map"></div>
    </div>
</div>
<script type="text/javascript">
    console.log('Running the maps: ');

    var map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.MapQuest({layer: 'hyb'})
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([37.41, 8.82]),
            zoom: 4
        })
    });
</script>
</body>
</html>