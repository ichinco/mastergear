var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearList = Backbone.Collection.extend({

    selectedGear : null,

    setSelected : function(selectedGear) {
        this.selectedGear = selectedGear;
        this.trigger('select-gear');
    },

    getSelected : function(){
        return this.selectedGear;
    },

    initialize : function() {
        this.model = Mastergear.Models.Gear;
        this.url = "/mastergear/gear/list"
    }

});