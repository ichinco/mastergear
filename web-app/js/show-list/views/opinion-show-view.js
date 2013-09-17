var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.OpinionShowView = Backbone.View.extend({
    events: {
        'click .close-button': 'close'
    },

    initialize : function(attr) {
        _.bindAll(this);
        this.model.bind('all', this.render);
        this.model.bind('show-opinions', this.show);
    },

    show : function() {
        this.$el.show();
    },

    close : function() {
        this.$el.hide();
    },

    _getTemplate: _.once(function() {
        return _.template($("#review_template").html());
    }),

    render: function() {
        var template = this._getTemplate();
        var finalHtml = "";
        _.each(this.model.models, function (e){
            if (e.attributes.id){
                var attributes = e.attributes;
                finalHtml += (template(attributes));
            }
        });
        this.$el.find(".reviews").html(finalHtml);
        return this;
    }
});