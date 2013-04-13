var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.NoMatchesView = Backbone.View.extend({
    events: {
        'click': 'onClick'
    },

    onClick: function() {
        this.$el.hide();
        this.model.getPossibleTrails().trigger('create-trail-dialog-open');
        this.model.trigger('create-trail-dialog-open');
    }
});
