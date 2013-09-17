var Mastergear = Mastergear || {};
Mastergear.Obj = Mastergear.Obj || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    main: function() {
        var opinionModel = new Mastergear.Models.OpinionModel();

        var opinionCreateView = new Mastergear.Views.OpinionCreateView({
            el : '#take-opinion',
            model : opinionModel
        });

        var leaveCreateView = new Mastergear.Views.OpinionCreateView({
            el : '#leave-opinion',
            model : opinionModel
        });

        var switchCreateView = new Mastergear.Views.OpinionCreateView({
            el : '#switch-opinion',
            model : opinionModel
        });

        var opinionCreateButton = new Mastergear.Views.OpinionCreateButton({
            el : 'button.opinion',
            model : opinionModel
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