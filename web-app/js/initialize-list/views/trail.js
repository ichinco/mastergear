var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.Trail = Backbone.View.extend({

    initialize : function() {
        _.bindAll(this);
        this.model.bind('all', this.render);
        this.model.bind('')
    },

    _getTemplate: _.once(function() {
        return _.template($("#trail_form_template").html());
    }),

    render: function() {
        var template = this._getTemplate();
        var finalHtml = "";
        var attributes = this.model.attributes;
        finalHtml += (template(attributes));
        this.$el.html(finalHtml);
        return this;
    },

    close : function (){
        this.$el.hide();
    }

});