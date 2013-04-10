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
            id : -1
        });
        this.model.add(gear);
        this.model.trigger('new-gear-dialog-close');
    }
});