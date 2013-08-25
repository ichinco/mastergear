var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.GearList = Backbone.Model.extend({

    initialize : function(){
        _.bindAll(this);
        this.url = "/gearList";
    }

});