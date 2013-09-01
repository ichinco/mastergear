var Mastergear = Mastergear || {};
Mastergear.Models = Mastergear.Models || {};

Mastergear.Models.Trail = Backbone.Model.extend({

    initialize : function(){
        _.bindAll(this);
        this.url = Mastergear.Urls.trail;
    }

});