var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.CreateGear = Backbone.Model.extend({

    gearTypeMap : {},
    currentGearType : null,

    addGearTypeModel : function(type, model) {
        this.gearTypeMap[type] = model;
    },

    addGearToModel : function(gear) {
        this.gearTypeMap[currentGearType].addGearList(gear);
    },

    setCurrentGearType : function(type) {
        this.currentGearType = type.toLowerCase();
    }

});