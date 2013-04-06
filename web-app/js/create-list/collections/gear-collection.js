var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearList = Backbone.Collection.extend({

    initialize : function() {
        this.model = Mastergear.Models.Gear;
        this.url = "/mastergear/gear/list"
    }

});