var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.AddGearDialog = Backbone.View.extend({

    events: {
        'click .create-competition': 'close'
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('new-gear-dialog-open', this.show);
    },

    show: function() {
        this.$el.show();
    },

    close : function (){
        console.log(this.model);
        this.model.create({
            name : this.$el.children('.name').first().val(),
            description : this.$el.children('.description').first().val()
        });
        this.$el.hide();
    }
});

Mastergear.Views.AddGearButton = Backbone.View.extend({
    events: {
        'click': 'onClick'
    },

    onClick: function() {
        this.model.trigger("new-gear-dialog-open");
    }
});