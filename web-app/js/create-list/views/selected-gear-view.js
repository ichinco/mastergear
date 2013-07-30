var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.SelectedGearView = Backbone.View.extend({
    possibleGearModel : null,

    initialize : function(attributes) {
        _.bindAll(this);
        this.close();
        this.possibleGearModel = attributes.possibleGearModel;
        this.possibleGearModel.bind('gear-selected', this.selectGear);
        this.possibleGearModel.bind('new-gear-dialog-open', this.clear);
    },

    _getTemplate: _.once(function() {
        return _.template($("#selected_gear_template").html());
    }),

    clear : function() {
        this.model = null;
        this.close();
    },

    selectGear : function(){
        this.model = this.possibleGearModel.getSelected();
        this.render();
        this.open();
    },

    render: function(evt) {
        var template = this._getTemplate();
        var finalHtml = "";
        finalHtml += (template(this.model.attributes));
        this.$el.html(finalHtml);
        return this;
    },

    open: function() {
        this.$el.show();
    },
    close : function (){
        this.$el.hide();
    }
});
