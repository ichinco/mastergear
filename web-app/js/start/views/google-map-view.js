/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 7/6/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GoogleMap = Backbone.View.extend({

    map : null,
    defaultLatitude : 40.212441,
    defaultLongitude : -98.180695,
    defaultZoom : 4,
    mapType : google.maps.MapTypeId.TERRAIN,

    initialize : function(){
        _.bindAll(this);

        google.maps.event.addDomListener(window, 'load', this.initializeMap());

        this.model.bind('reset', this.setMarkers);
    },

    initializeMap : function() {
        var mapOptions = {
          center: new google.maps.LatLng(this.defaultLatitude, this.defaultLongitude),
          zoom: this.defaultZoom,
          mapTypeId: this.mapType
        };
        this.map = new google.maps.Map(document.getElementById("map"), mapOptions);
        this.model.fetch();
    },

    onMarkerClick: function(id, model, loc) {
        return function(evt) {
            model.setSelected(id);
//            this.map.panTo(loc);
        };
    },

    setMarkers: function(evt){
        var map = this.map;
        var handler = this.onMarkerClick;
        var model = this.model;
        _.each(this.model.models, function (e){
            var loc = new google.maps.LatLng(e.attributes.latitude, e.attributes.longitude);
            var marker = new google.maps.Marker({
                position: loc,
                map: map,
                icon: "images/marker.png",
                title: e.name
              });
            google.maps.event.addListener(marker, 'click', handler(e.attributes.id, model, loc));

            var infowindow = new google.maps.InfoWindow({
                content: "<div>" + e.attributes.name + "</div>",
                pixelOffset:new google.maps.Size(0, 0),
                hideCloseButton:true,
                arrowSize:15,
                arrowPosition: 50
            });

            google.maps.event.addListener(marker, 'mouseover', function(evt) {
                infowindow.open(map, marker);
            });

            // assuming you also want to hide the infowindow when user mouses-out
            google.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });
        });
    }

});