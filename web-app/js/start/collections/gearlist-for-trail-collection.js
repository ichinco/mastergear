var Mastergear = Mastergear || {};
Mastergear.Collection = Mastergear.Collection || {};

Mastergear.Collection.GearListForTrail = Backbone.Collection.extend({
    selectedTrail : null,
    possibleTrailCollection : null,

    initialize : function(){
        this.model = Mastergear.Models.GearList;
        this.url = "gearlist"
    },

    setPossibleTrailCollection : function(possibleTrailCollection) {
        this.possibleTrailCollection = possibleTrailCollection;
        this.possibleTrailCollection.bind('trail-selected', this.setSelected, this)
    },

    setSelected : function(evt){
        this.selectedTrail = this.possibleTrailCollection.getSelected();
        this.fetch();
        this.trigger("trail-selected");
    },

    fetch: function(options) {
        options || (options = {});
        var data = (options.data || {});
        options.data = {trailId: this.selectedTrail};

        return Backbone.Collection.prototype.fetch.call(this, options);
    }

});
