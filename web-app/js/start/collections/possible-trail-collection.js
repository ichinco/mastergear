var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.PossibleTrails = Backbone.Collection.extend({

    selectedTrail : null,

    initialize : function(){
        this.model = Mastergear.Models.Trail;
        this.url = "/mastergear/trail/"
    },

    setSelected : function(trail){
        this.selectedTrail = trail;
        this.trigger('trail-selected');
    },

    getSelected : function() {
        return this.selectedTrail;
    }
});
