var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearHintView = Backbone.View.extend({
    initialize : function() {
        _.bindAll(this);
        this.model.bind('create-gear-dialog-close', this.close);
    },

    close : function (){
        this.$el.hide();
    }
});