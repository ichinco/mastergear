var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.SelectTrailDialog = Backbone.View.extend({

    events : {
        'click .close-button' : 'close'
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('select-trail-open', this.show);
        this.model.bind('trail-selected', this.close);
    },

    show: function() {
        this.$el.show();
    },

    close : function (){
        this.$el.hide();
    }
});