var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.SelectTrailButton = Backbone.View.extend({
    events: {
        'click': 'onClick'
    },

    onClick: function(e) {
        e.preventDefault();
        this.model.trigger("select-trail-open");
    }
});