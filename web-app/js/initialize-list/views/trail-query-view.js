var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.TrailQuery = Backbone.View.extend({
    events : {
        'submit .search-form' : 'queryTrails'
    },

    initialize : function() {
        _.bindAll(this);
        this.hideLoader();
        this.model.bind("trails-updated", this.hideLoader);
        this.model.bind("trails-updating", this.showLoader);
    },

    hideLoader : function() {
        this.$el.find(".loading").hide();
    },

    showLoader : function() {
        this.$el.find(".loading").show();
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