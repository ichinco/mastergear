var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearListGearOpinion = Backbone.Collection.extend({

    model : Mastergear.Models.OpinionModel,
    gearListGearId : null,
    url : Mastergear.Urls.gearListGearOpinion,

    initialize : function(attr){
    },

    setGearListGearId : function(id){
        this.gearListGearId = id;
    },

    fetch: function(options) {
        options || (options = {});
        var data = (options.data || {});
        options.data = {gearListGearId: this.gearListGearId};

        return Backbone.Collection.prototype.fetch.call(this, options);
    }

});