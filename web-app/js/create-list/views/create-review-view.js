var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.CreateReview = Backbone.View.extend({
    events : {
        'click .create-review': 'saveReview',
        'click .close-pop' : 'close'
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
});