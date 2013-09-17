var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.LeftPanel = Backbone.View.extend({
    initialize : function() {
        _.bindAll(this);
        this.hideAll();
        this.model.bind('gear-selected', this.showAll);
        this.model.bind('new-gear-dialog-open', this.hideAll);
    },

    showAll : function (){
        this.$el.find(".weight").attr("placeholder", this.model.selectedGear.get("weight"));
        this.$el.find(".add-gear-button").show();
        this.$el.find(".gearType-field").show();
        this.$el.find(".weight-field").show();
    },

    hideAll : function() {
        this.$el.find(".add-gear-button").hide();
        this.$el.find(".gearType-field").hide();
        this.$el.find(".weight-field").hide();
    }
});