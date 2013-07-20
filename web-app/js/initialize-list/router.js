var Mastergear = Mastergear || {};
Mastergear.Obj = Mastergear.Obj || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    main: function() {
        var possibleTrailModel = new Mastergear.Collection.PossibleTrails();
        var trailModel = new Mastergear.Models.Trail();
        trailModel.setPossibleTrails(possibleTrailModel);

        var selectTrailDialog = new Mastergear.Views.SelectTrailDialog({
            el : '.trail-selection',
            model : trailModel
        });

        var selectTrailButton = new Mastergear.Views.SelectTrailButton({
            el : 'button.select-trail',
            model : trailModel
        });

        var possibleTrailList = new Mastergear.Views.TrailSelection({
            el : '.trail-selection .trails',
            model : possibleTrailModel
        });

        var selectedTrail = new Mastergear.Views.Trail({
            el : '.selected-trail',
            model : trailModel
        });

        var noMatchTrail = new Mastergear.Views.NoMatchesView({
            el : '.no-trail',
            model : trailModel
        });

        var createTrail = new Mastergear.Views.CreateTrail({
            el : '.create-trail',
            model : trailModel
        });

        var getTrail = new Mastergear.Views.TrailQuery({
            el : '.get-suggestions',
            model : possibleTrailModel
        })
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