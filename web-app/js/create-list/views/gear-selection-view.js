var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearSelection = Backbone.View.extend({
    initialize : function() {
        _.bindAll(this);
        this.model.bind('reset', this.render);
    },

    _getTemplate: _.once(function() {
        return _.template($("#gear_template").html());
    }),

    render: function(evt) {
        var template = this._getTemplate();
        var finalHtml = "";
        _.each(this.model.models, function (e){
            var attributes = e.attributes;
            finalHtml += (template(attributes));
        });
        this.$el.html(finalHtml);
        this.model.trigger("suggestions-updated");
        return this;
    },

    close : function (){
        this.$el.hide();
    }

});