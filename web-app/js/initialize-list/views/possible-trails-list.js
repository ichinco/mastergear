var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.TrailSelection = Backbone.View.extend({
    events: {
        'click .trail-object': 'selectTrail'
    },

    selectTrail : function(evt){
        var gearId = $(evt.target).data('trail-id'),
            gear = this.model.get(gearId);
        this.model.setSelected(gear);
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('all', this.render);
    },

    _getTemplate: _.once(function() {
        return _.template($("#trail_template").html());
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