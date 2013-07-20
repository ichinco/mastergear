var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.SelectTrailButton = Backbone.View.extend({
    events: {
        'click': 'onClick'
    },

    initialize : function(){
        _.bindAll(this);
        this.model.bind('trail-selected', this.show);
    },

    onClick: function(e) {
        e.preventDefault();
        this.model.trigger("select-trail-open");
    },

    show : function(e) {
        this.$el.show();
    }
});