var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearList = Backbone.Collection.extend({

    selectedGear : null,
    itemType : null, // default to camping

    setItemType : function(itemType) {
        this.itemType = itemType;
        this.fetch();
    },

    setSelected : function(selectedGear) {
        this.selectedGear = selectedGear;
        this.trigger('select-gear');
    },

    getSelected : function(){
        return this.selectedGear;
    },

    initialize : function() {
        this.model = Mastergear.Models.Gear;
        this.url = "/mastergear/gear/search"
    },

    fetch: function(options){
        options = options || {};
        if (this.itemType != null) {
            options.data = options.data || {};
            options.data.term = this.itemType;
        }
        return Backbone.Collection.prototype.fetch.call(this, options);
    }

});