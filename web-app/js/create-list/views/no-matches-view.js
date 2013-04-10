var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.NoMatchesView = Backbone.View.extend({
    events: {
        'click': 'onClick'
    },

    onClick: function() {
        this.model.trigger("create-gear-dialog-close");
    }
});