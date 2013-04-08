var Mastergear = Mastergear || {};
Mastergear.Obj = Mastergear.Obj || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    main: function() {

        var possiblePackModel = new Mastergear.Collection.GearList();
        var packModel = new Mastergear.Collection.GearType();
        packModel.setSelectionModel(possiblePackModel);

        var newGearDialog = new Mastergear.Views.AddGearDialog({
            el : '.pack .add-gear',
            model : packModel
        });

        var packView = new Mastergear.Views.AddGearButton({
            el : '.pack .add-gear-button',
            model : packModel
        });

        var selectedGearView = new Mastergear.Views.GearSelection({
            el : '.pack .added-gear',
            model : packModel
        });

        var gearSuggestionView = new Mastergear.Views.GearSelection({
            el : '.pack .add-gear .gearSuggestion',
            model : possiblePackModel
        });

        var gearSuggestionInputView = new Mastergear.Views.GearSelectionInput({
            el : '.pack .add-gear .gearSearch',
            model : possiblePackModel
        });

        possiblePackModel.fetch({remove : true, add : true, change : true});
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