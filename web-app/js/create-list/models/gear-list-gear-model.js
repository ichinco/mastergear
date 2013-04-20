var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.GearListGear = Backbone.Model.extend({

    initialize : function(){
        _.bindAll(this);
        this.urlRoot = "/mastergear/gearListGear";
    },

    toJSON : function(){
        if (this.get("id") > 0){
            return {
                id : this.get("id"),
                notes : this.get("notes")
            };
        } else {
            return this.attributes;
        }
    }

});