var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.CreateGear = Backbone.Model.extend({

    gearTypeMap : {},
    currentGearType : null,
    selectedGear : null,

    addGearTypeModel : function(type, model) {
        this.gearTypeMap[type] = model;
    },

    addGearToModel : function() {
        this.gearTypeMap[this.currentGearType].addGearList(this.selectedGear);
    },

    setCurrentGearType : function(type) {
        this.currentGearType = type.toLowerCase();
    },

    setSelected : function(gear) {
        this.selectedGear = gear;
        this.trigger("gear-selected");
    },

    getSelected : function() {
        return this.selectedGear;
    }

});