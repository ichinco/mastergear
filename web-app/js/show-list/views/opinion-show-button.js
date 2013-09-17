var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.OpinionShowButton = Backbone.View.extend({
    events : {
        'click': 'openDialog'
    },

    initialize : function() {
        _.bindAll(this);
    },

    openDialog : function(e) {

        var id = $(e.currentTarget).data("gear-id");
        this.model.setGearListGearId(id);
        this.model.fetch();
        this.model.trigger("show-opinions");
    }
});
