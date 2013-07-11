/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 7/6/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.Map = Backbone.View.extend({

    map : null,
    defaultLatitude : 40.212441,
    defaultLongitude : -98.180695,
    defaultZoom : 4,

    initialize : function(){
        L.Icon.Default.imagePath = 'js/leaflet/images/';
        _.bindAll(this);
        this.map = L.map('map').setView([this.defaultLatitude, this.defaultLongitude], this.defaultZoom);

        L.tileLayer('http://{s}.tile.stamen.com/terrain/{z}/{x}/{y}.png', {
            attribution: [
                    'Map tiles by <a href="http://stamen.com">Stamen Design</a>, ',
                    'under <a href="http://creativecommons.org/licenses/by/3.0">CC BY 3.0</a>. ',
                    'Data by <a href="http://openstreetmap.org">OpenStreetMap</a>, ',
                    'under <a href="http://creativecommons.org/licenses/by-sa/3.0">CC BY SA</a>.'
                ].join(""),
            minZoom:4,
            maxZoom: 18
        }).addTo(this.map);

        this.model.bind('reset', this.setMarkers);
    },

    onMarkerClick: function(id, model) {
        return function(evt) {
            model.setSelected(id);
        };
    },

    setMarkers: function(evt){
        var map = this.map;
        var handler = this.onMarkerClick;
        var model = this.model;
        _.each(this.model.models, function (e){
            var marker = L.marker([e.attributes.latitude, e.attributes.longitude]).addTo(map);
            marker.on('click', handler(e.attributes.id, model));
        });
    }

});