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
        this.url = Mastergear.Urls.search;
    },

    find : function( providerId )
    {
        var models = this.models,
            i = models.length;

        while( --i >= 0 )
        {
            var currentModel = models[i],
                providers = currentModel.get('providers');

            if( providers.length > 0 &&
                providers[0].providerId == providerId )
               return models[i];
        }
        return null;
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