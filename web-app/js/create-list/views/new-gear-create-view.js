var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.CreateGear = Backbone.View.extend({
    events: {
        'click .create-gear': 'createGear'
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('create-gear-dialog-close', this.show);
    },

    show: function() {
        this.$el.show();
    },

    createGear : function(){
        var gear = new Mastergear.Models.Gear({
            title : this.$el.find(".style").val(),
            brand : this.$el.find(".brand").val(),
            type : this.$el.find(".item-type").val(),
            weight : this.$el.find(".weight").val(),
            gender : this.$el.find(".gender").val(),
            providerType : this.$el.find(".providerType").val(),
            imageId : this.$el.find(".imageId").val(),
            providerId : this.$el.find(".providerId").val(),
            id : -1
        });
        gear.save({}, {async : false});
        this.model.addGearList(gear);
    }
});