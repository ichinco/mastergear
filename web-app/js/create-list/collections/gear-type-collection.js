var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearType = Backbone.Collection.extend({

    model : Mastergear.Models.GearListGear,
    gearType : null,
    listId : null,
    url : Mastergear.Urls.gearListGear,

    initialize : function(attr){
        this.gearType = attr.gearType;
        this.listId = attr.listId;
    },

    addGearList : function(gear, weight){
        var gearListGear = new Mastergear.Models.GearListGear();
        var attr = {};
        attr.gear = gear.attributes;
        attr.gearType = {name : this.gearType};
        attr.list = {id : this.listId};
        attr.weight = weight;
        gearListGear.set(attr);
        gearListGear.save({}, {async : false});

        this.add(gearListGear);
        this.trigger('new-gear-dialog-close');
    },

    removeGear : function(gear){
        gear.destroy({wait: true,
                      data : {listId : this.listId, gearType : this.gearType},
                      processData : true});
    },

    fetch: function(options) {
        options || (options = {});

        options.data = {listId: this.listId, gearType: this.gearType};

        return Backbone.Collection.prototype.fetch.call(this, options);
    }

});