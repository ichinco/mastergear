var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.PossibleTrails = Backbone.Collection.extend({

    selectedTrail : null,

    initialize : function(){
        this.model = Mastergear.Models.Trail;
        this.url = "/mastergear/trail/list"
    },

    setSelected : function(trail){
        this.selectedTrail = trail;
    },

    getSelected : function() {
        return this.selectedTrail;
    }
});
