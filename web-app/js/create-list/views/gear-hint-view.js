var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearHintView = Backbone.View.extend({
    events : {
        'submit .search-form' : 'updateGear'
    },

    updateGear : function(evt) {
        var categoryId = this.$el.find(".category-desc").val();
        this.model.setItemType(categoryId);
        return false;
    },

    gearUpdating : function(evt) {
        this.$el.find(".loading").show();
    },

    gearUpdated : function(evt) {
        this.$el.find(".loading").hide();
    },

    initialize : function(attr) {
        _.bindAll(this);
        this.model.bind('suggestions-updated', this.gearUpdated);
        this.model.bind('suggestions-updating', this.gearUpdating);
        attr.createGearModel.bind('new-gear-dialog-open', this.clear);
    },

    clear : function (){
        this.$el.find(".category-desc").val("");
    }
});