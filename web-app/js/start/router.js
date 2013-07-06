var Mastergear = Mastergear || {};
Mastergear.Obj = Mastergear.Obj || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    main: function() {
        var possibleTrailModel = new Mastergear.Collection.PossibleTrails();

        var map = new Mastergear.Views.Map({
            el : '#map',
            model : possibleTrailModel
        });

        var dialog = new Mastergear.Views.IntroDialog({
            el : '.intro'
        });

        possibleTrailModel.fetch({remove : true, add : true, change : true})
    }
});

$(document).ready(function() {
    // change template settings so that we can use
    // it and it doesn't get torn apart by grails.
    _.templateSettings = {
        interpolate : /\{\{(.+?)\}\}/g,
        evaluate : /\{!(.+?)!\}/g
    };

    var app = new Mastergear.Router();
    app.init();
});
