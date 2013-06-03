var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearHintView = Backbone.View.extend({
    events : {
        'click .category' : 'updateGear'
    },

    updateGear : function(evt) {
        var categoryId = this.$el.find(".category-desc").val();
        console.log("categoryId");
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