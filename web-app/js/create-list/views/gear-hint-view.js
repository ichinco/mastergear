var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearHintView = Backbone.View.extend({
    events : {
        'click .category' : 'updateGear'
    },

    updateGear : function(evt) {
        var categoryId = this.$el.find(".category-desc").val();
        this.model.setItemType(categoryId);
    },

    gearUpdating : function(evt) {
        this.$el.find(".loading").show();
    },

    gearUpdated : function(evt) {
        this.$el.find(".loading").hide();
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('create-gear-dialog-close', this.close);
        this.model.bind('suggestions-updated', this.gearUpdated);
        this.model.bind('suggestions-updating', this.gearUpdating);
    },

    close : function (){
        this.$el.hide();
    }
});