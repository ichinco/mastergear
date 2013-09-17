var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.OpinionModel = Backbone.Model.extend({

    type : null,
    gearListGearId : null,

    initialize : function(){
        _.bindAll(this);
        this.urlRoot = Mastergear.Urls.gearListGearOpinion;
    },

    setOpinionType : function(type) {
        this.type = type;
    },

    getOpinionType : function() {
        return this.type;
    },

    setGearListGearId : function(id) {
        this.gearListGearId = id;
    },

    getGearListGearId : function() {
        return this.gearListGearId;
    }
});