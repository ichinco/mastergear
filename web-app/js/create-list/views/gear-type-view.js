var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearType = Backbone.View.extend({
    reviewView : null,

    events: {
        'click .gear-delete': 'deleteGear',
        'click .review-gear' : 'reviewGear'
    },

    initialize : function(attr) {
        _.bindAll(this);
        this.model.bind('all', this.render);
        this.reviewView = attr.reviewView;
    },

    reviewGear : function(evt) {
        var gearId = $(evt.target).data('gear-id'),
            gear = this.model.get(gearId);
        this.reviewView.setModel(gear);
        gear.trigger('review');
    },

    deleteGear : function(evt){
        var gearId = $(evt.target).data('gear-id'),
            gear = this.model.get(gearId);
        this.model.removeGear(gear);
    },

    _getTemplate: _.once(function() {
        return _.template($("#gear_type_template").html());
    }),

    render: function() {
        var template = this._getTemplate();

        var finalHtml = "";
        var gearListGear = this.model.models,
            i = gearListGear.length;

        _.each(this.model.models, function (e){
            if (e.attributes.id){
                var attributes = e.attributes;
                finalHtml += (template(attributes));
            }
        });
        this.$el.html(finalHtml);

        return this;
    }
});