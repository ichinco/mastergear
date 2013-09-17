var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.OpinionCreateButton = Backbone.View.extend({
    events : {
        'click': 'openDialog'
    },

    initialize : function() {
        _.bindAll(this);
    },

    openDialog : function(e) {

        var id = $(e.currentTarget).data("gear-id");
        var opinionType = $(e.currentTarget).data("opinion-type");
        this.model.setGearListGearId(id);
        this.model.setOpinionType(opinionType);
        this.model.trigger("show-view");
    }
});
