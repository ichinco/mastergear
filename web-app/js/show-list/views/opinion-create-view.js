var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.OpinionCreateView = Backbone.View.extend({
    events : {
        'click .create-opinion' : 'sendOpinion',
        'click .close-button' : 'close'
    },

    opinionType : null,

    initialize : function() {
        _.bindAll(this);
        this.model.bind("show-view", this.show);
        this.opinionType = this.$el.data("opinion-type");
    },

    sendOpinion : function() {

    },

    close : function (){
        this.$el.hide();
    },

    show : function (){
        if (this.opinionType == this.model.getOpinionType()){
            this.$el.show();
        }
    }
});
