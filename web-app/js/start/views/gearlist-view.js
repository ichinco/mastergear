/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 7/6/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.GearList = Backbone.View.extend({
    events : {
        'click .close' : 'close'
    },

    initialize : function(){
        _.bindAll(this);
        this.model.bind("trail-selected", this.show);
        this.model.bind("reset", this.render);
    },

    show : function(evt) {
        this.$el.show();
    },

    close : function(evt) {
        this.$el.hide();
    },

    render: function() {
        var template = this._getTemplate();
        var finalHtml = "";
        _.each(this.model.models, function (e){
            console.log(e);
            if (e.attributes.id){
                var attributes = e.attributes;
                finalHtml += (template(attributes));
            }
        });
        this.$el.html(finalHtml);
        return this;
    },

    _getTemplate: _.once(function() {
        return _.template($("#gear_list_template").html());
    })
});