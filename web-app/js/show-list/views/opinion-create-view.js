var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.OpinionCreateView = Backbone.View.extend({
    events : {
        'click .create-review': 'saveReview',
        'click .close-button' : 'close'
    },

    initialize : function() {
        _.bindAll(this);
    },

    saveReview : function(){
        this.model.set({"notes": this.$el.find(".gear-review").val()});
        this.model.save();
        this.close();
    },

    setModel : function(model){
        this.model = model;
        this.$el.find(".gear-review").val(this.model.get("notes"));
        this.$el.find("h1").html("Review " + this.model.get("gear").brand + " " + this.model.get("gear").itemType);
        this.model.bind('review', this.show);
    },

    close : function (){
        this.$el.hide();
    },

    show : function (){
        this.$el.show();
    }
});/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 9/16/13
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
