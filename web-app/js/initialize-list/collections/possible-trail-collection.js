var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.PossibleTrails = Backbone.Collection.extend({

    selectedTrail : null,
    userQuery : null,

    initialize : function(){
        this.model = Mastergear.Models.Trail;
        this.url = "/mastergear/trail/";
    },

    setSelected : function(trail){
        this.selectedTrail = trail;
        this.trigger('trail-selected');
    },

    getSelected : function() {
        return this.selectedTrail;
    },

    setQuery : function(query) {
        this.userQuery = query;
        this.fetch();
    },

    fetch: function(options){
        options = options || {};
        if (this.userQuery != null) {
            options.data = options.data || {};
            options.data.query = this.userQuery;
        }
        return Backbone.Collection.prototype.fetch.call(this, options);
    }
});
