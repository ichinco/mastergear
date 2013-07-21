var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.AddGearDialog = Backbone.View.extend({

    events: {
        'click .close-pop'  : 'close',
        'change .gearType' : 'setGearType'
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('new-gear-dialog-open', this.show);
        this.model.bind('new-gear-dialog-close', this.close);
    },

    setGearType : function(evt){
        var gearType = this.$el.find(".gearType").val();
        this.model.setCurrentGearType(gearType);
    },

    show: function() {
        this.$el.show();
    },

    close : function (){
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