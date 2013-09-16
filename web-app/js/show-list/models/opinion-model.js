var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.OpinionModel = Backbone.Model.extend({

    initialize : function(){
        _.bindAll(this);
        this.urlRoot = Mastergear.Urls.gearListGearOpinion;
    }

});