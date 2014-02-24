var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.CreateGear = Backbone.Model.extend({

    ///
    /// gearTypeMap: map of (currentGearType, GearType (collection, file: gear-type-collection)
    ///
    gearTypeMap : {},

    currentGearType : null,

    selectedGear : null,

    weight: null,

    setWeight: function(weight) {
        this.weight = weight;
    },

    addGearTypeModel : function(type, model) {
        this.gearTypeMap[type] = model;
    },

    addGearToModel : function() {
        this.gearTypeMap[this.currentGearType].addGearList(this.selectedGear, this.weight);
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