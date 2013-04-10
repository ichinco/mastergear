var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearSelection = Backbone.View.extend({
    events: {
        'click .gear-object': 'selectGear'
    },

    selectGear : function(evt){
        var gearId = $(evt.target).data('gear-id'),
            gear = this.model.get(gearId);
        this.model.setSelected(gear);
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('all', this.render);
    },

    _getTemplate: _.once(function() {
        return _.template($("#gear_template").html());
    }),

    render: function() {
        var template = this._getTemplate();
        var finalHtml = "";
        _.each(this.model.models, function (e){
            var attributes = e.attributes;
            finalHtml += (template(attributes));
        });
        this.$el.html(finalHtml);
        return this;
    },

    close : function (){
        this.$el.hide();
    }

});

Mastergear.Views.GearSelectionInput = Backbone.View.extend({

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