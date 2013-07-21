var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.AddGearDialog = Backbone.View.extend({

    events: {
        'click .close-pop'  : 'close',
        'change .gearType' : 'setGearType',
        'click .gear-object': 'selectGear',
        'click .add-gear-button' : 'addGearAndClose'
    },

    possibleGearModel : null,

    initialize : function(attr) {
        _.bindAll(this);
        this.model.bind('new-gear-dialog-open', this.show);
        this.model.bind('new-gear-dialog-close', this.close);
        this.possibleGearModel = attr.possibleGearModel;
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
    },

    selectGear : function(evt){
        var gearId = $(evt.target).parents(".item-container").data('gear-id'),
            gear = this.possibleGearModel.get(gearId);
        this.model.setSelected(gear);
    },

    addGearAndClose : function(evt) {
        this.model.addGearToModel();
        this.close();
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