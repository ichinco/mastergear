var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearType = Backbone.Collection.extend({

    suggestionModel : null,

    initialize : function(){
        this.model = Mastergear.Models.Gear;
    },

    setSelectionModel : function(selectionModel) {
        this.suggestionModel = selectionModel;
        this.suggestionModel.bind('select-gear', this.gearSelected, this);
    },

    gearSelected : function(){
        this.add(this.suggestionModel.getSelected());
    }
});