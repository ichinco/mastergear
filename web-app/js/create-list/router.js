var Mastergear = Mastergear || {};
Mastergear.Obj = Mastergear.Obj || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    buildAddView : function(cssClass) {
        var possiblePackModel = new Mastergear.Collection.GearList();
        var packModel = new Mastergear.Collection.GearType();
        packModel.setSelectionModel(possiblePackModel);

        var newGearDialog = new Mastergear.Views.AddGearDialog({
            el : '.' + cssClass + ' .add-gear',
            model : packModel
        });

        var packView = new Mastergear.Views.AddGearButton({
            el : '.' + cssClass + ' .add-gear-button',
            model : packModel
        });

        var selectedGearView = new Mastergear.Views.GearSelection({
            el : '.' + cssClass + ' .added-gear',
            model : packModel
        });

        var gearSuggestionView = new Mastergear.Views.GearSelection({
            el : '.' + cssClass + ' .add-gear .gearSuggestion',
            model : possiblePackModel
        });

        var gearSuggestionInputView = new Mastergear.Views.GearSelectionInput({
            el : '.' + cssClass + ' .add-gear .gearSearch',
            model : possiblePackModel
        });

        possiblePackModel.fetch({remove : true, add : true, change : true})
    },

    main: function() {
        this.buildAddView('pack');
        this.buildAddView('sleep');
        this.buildAddView('cooking');
        this.buildAddView('food');
        this.buildAddView('water');
        this.buildAddView('clothes');
        this.buildAddView('electronics');
        this.buildAddView('emergency');
        this.buildAddView('other');
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