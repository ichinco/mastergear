var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.CreateGearList = Backbone.View.extend({

    events : {
        'click button.create-gear-list' : 'createGearList'
    },

    initialize : function() {
        _.bindAll(this);
    },

    createGearList : function (){
        var gear = new Mastergear.Models.GearList({
            name : this.$el.find(".trail-name").val(),
            location : this.$el.find(".location").val(),
            longitude : this.$el.find(".longitude").val(),
            latitude : this.$el.find(".latitude").val(),
            maxElevation : this.$el.find(".maxElevation").val(),
            id : -1
        });
        this.model.changeModelTo(gear);
        this.model.trigger('new-gear-dialog-close');
    }
});