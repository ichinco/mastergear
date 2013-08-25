var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearList = Backbone.Collection.extend({

    itemType : null,

    setItemType : function(itemType) {
        this.itemType = itemType;
        this.fetch();
    },

    initialize : function() {
        this.model = Mastergear.Models.Gear;
        this.url = "../gear/search"
    },

    fetch: function(options){
        this.trigger('suggestions-updating');
        options = options || {};
        if (this.itemType != null) {
            options.data = options.data || {};
            options.data.term = this.itemType;
        }
        Backbone.Collection.prototype.fetch.call(this, options);
    }

});