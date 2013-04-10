var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.CreateGear = Backbone.View.extend({
    initialize : function() {
        _.bindAll(this);
        this.model.bind('create-gear-dialog-close', this.show);
    },

    show: function() {
        this.$el.show();
    }
});