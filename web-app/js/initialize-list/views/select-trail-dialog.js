var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.SelectTrailDialog = Backbone.View.extend({

    initialize : function() {
        _.bindAll(this);
        this.model.bind('select-trail-open', this.show);
        this.model.bind('select-trail-close', this.close);
    },

    show: function() {
        this.$el.show();
    },

    close : function (){
        this.$el.hide();
    }
});