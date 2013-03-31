var Mastergear = Mastergear || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    main: function() {

        var packModel = new Mastergear.Models.GearType();

        var newGearDialog = new Mastergear.Views.AddGearDialog({
            el : '#add-gear',
            model : packModel
        });

        var packView = new Mastergear.Views.AddGearButton({
            el : '.pack .add-gear-button',
            model : packModel
        });
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