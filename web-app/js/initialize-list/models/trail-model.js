var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.Trail = Backbone.Model.extend({

    // reference to the trails collection
    possibleTrails : null,

    initialize : function(){
        _.bindAll(this);
        this.url = "/trail/";
    },

    setPossibleTrails : function(possibleTrails) {
        this.possibleTrails = possibleTrails;
        this.possibleTrails.bind('trail-selected',this.changeModel);
    },

    getPossibleTrails : function() {
        return this.possibleTrails;
    },

    changeModel : function(){
        this.set(this.possibleTrails.getSelected().attributes);
        this.trigger('select-trail-close');
    },

    changeModelTo : function(newModel) {
        this.set(newModel.attributes);
        this.trigger('select-trail-close');
        this.save();
    }

});