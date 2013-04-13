var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.CreateTrail = Backbone.View.extend({

    events : {
        'click .create' : 'createTrail'
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('create-trail-dialog-open', this.show);
    },

    show : function(){
        this.$el.show();
    },

    createTrail : function (){
        var gear = new Mastergear.Models.Trail({
            name : this.$el.find(".trail-name").val(),
            id : -1
        });
        this.model.changeModelTo(gear);
        this.model.trigger('new-gear-dialog-close');
    }
});