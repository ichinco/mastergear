var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.TrailQuery = Backbone.View.extend({
    events : {
        'submit .search-form' : 'queryTrails'
    },

    initialize : function() {
        _.bindAll(this);
    },

    queryTrails : function(evt) {
        evt.preventDefault();
        this.model.setQuery(this.$el.find(".category-desc").val());
        return false;
    },

    close: function(evt) {
        this.$el.hide();
    },

    open: function(evnt){
        this.$el.show();
    }
});