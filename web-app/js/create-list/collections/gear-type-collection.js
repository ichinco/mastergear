var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearType = Backbone.Collection.extend({

    suggestionModel : null,
    model : Mastergear.Models.GearListGear,
    gearType : null,
    listId : null,
    url : "/mastergear/gearListGear/list",

    initialize : function(attr){
        this.gearType = attr.gearType;
        this.listId = attr.listId;
    },

    setSelectionModel : function(selectionModel) {
        this.suggestionModel = selectionModel;
        this.suggestionModel.bind('select-gear', this.gearSelected, this);
    },

    gearSelected : function(){
        this.addGearList(this.suggestionModel.getSelected());
    },

    addGearList : function(gear){
        var gearListGear = new Mastergear.Models.GearListGear();
        var attr = gear.attributes;
        console.log(gear.attributes);
        attr.gearType = this.gearType;
        attr.listId = this.listId;
        gearListGear.set(attr);
        gearListGear.save();
        this.add(gearListGear);
        this.trigger('new-gear-dialog-close');
    },

    fetch: function(options) {
        options || (options = {});
        var data = (options.data || {});
        options.data = {listId: this.listId, gearType: this.gearType};

        return Backbone.Collection.prototype.fetch.call(this, options);
    }

});