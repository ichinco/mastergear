var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.GearListGear = Backbone.Model.extend({

    initialize : function(){
        _.bindAll(this);
        this.urlRoot = "/mastergear/gearListGear";
    }

});