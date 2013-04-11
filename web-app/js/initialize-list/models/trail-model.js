var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.Trail = Backbone.Model.extend({

    possibleTrails : null,

    initialize : function(){
        _.bindAll(this);
        this.url = "trail";
    },

    setPossibleTrails : function(possibleTrails) {
        this.possibleTrails = possibleTrails;
    }

});