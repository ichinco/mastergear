var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearHintView = Backbone.View.extend({
    events : {
        'change .category' : 'updateGear'
    },

    updateGear : function(evt) {
        var categoryId = this.$el.find(".category").val();
        this.model.setItemType(categoryId);
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('create-gear-dialog-close', this.close);
    },

    close : function (){
        this.$el.hide();
    }
});