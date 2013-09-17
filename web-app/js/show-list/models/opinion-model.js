var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.OpinionModel = Backbone.Model.extend({

    type : null,
    gearListGearId : null,
    textOpinion : null,

    initialize : function(){
        _.bindAll(this);
        this.urlRoot = Mastergear.Urls.gearListGearOpinion;
    },

    clear : function() {
        this.attributes = {};
    },

    setOpinionType : function(type) {
        this.type = type;
        this.set({"opinionType": this.type.toUpperCase()});
    },

    getOpinionType : function() {
        return this.type;
    },

    setGearListGearId : function(id) {
        this.gearListGearId = id;
        this.set({"gearListGearId": this.gearListGearId});
    },

    getGearListGearId : function() {
        return this.gearListGearId;
    },

    setTextOpinion : function(text) {
        this.textOpinion = text;
        this.set({"textOpinion": this.textOpinion});
    }
});