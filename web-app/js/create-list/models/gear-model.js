var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.Gear = Backbone.Model.extend({

    initialize : function(){
        _.bindAll(this);
        this.url = "/mastergear/gear";
    }

});