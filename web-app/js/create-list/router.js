var Mastergear = Mastergear || {};
Mastergear.Obj = Mastergear.Obj || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    buildAddView : function(cssClass, reviewView) {
        var possiblePackModel = new Mastergear.Collection.GearList();
        var packModel = new Mastergear.Collection.GearType({
            listId : Mastergear.listId,
            gearType : cssClass
        });
        packModel.fetch({remove : true, add : true, change : true});
        packModel.setSelectionModel(possiblePackModel);

        var newGearDialog = new Mastergear.Views.AddGearDialog({
            el : '.' + cssClass + ' .add-gear',
            model : packModel
        });

        var packView = new Mastergear.Views.AddGearButton({
            el : '.' + cssClass + ' .add-gear-button',
            model : packModel
        });

        var noMatchesView = new Mastergear.Views.NoMatchesView({
            el : '.' + cssClass + ' .no-match',
            model : packModel
        });

        var createGearView = new Mastergear.Views.CreateGear({
            el : '.' + cssClass + ' .gear-create',
            model : packModel
        });

        var selectedGearView = new Mastergear.Views.GearType({
            el : '.' + cssClass + ' .added-gear',
            model : packModel,
            reviewView : reviewView
        });

        var gearHintView = new Mastergear.Views.GearHintView({
            el : '.' + cssClass + ' .get-suggestions',
            model : packModel
        });

        var gearSuggestionView = new Mastergear.Views.GearSelection({
            el : '.' + cssClass + ' .add-gear .gear-suggestion',
            model : possiblePackModel
        });

        var gearSuggestionInputView = new Mastergear.Views.GearSelectionInput({
            el : '.' + cssClass + ' .add-gear .gear-search',
            model : possiblePackModel
        });

        possiblePackModel.fetch({remove : true, add : true, change : true})
    },

    main: function() {
        var createReviewView = new Mastergear.Views.CreateReview({
            el : '#review-gear'
        });

        this.buildAddView('pack',createReviewView);
        this.buildAddView('sleep',createReviewView);
        this.buildAddView('cooking',createReviewView);
        this.buildAddView('food',createReviewView);
        this.buildAddView('water',createReviewView);
        this.buildAddView('clothes',createReviewView);
        this.buildAddView('electronics',createReviewView);
        this.buildAddView('emergency',createReviewView);
        this.buildAddView('other',createReviewView);
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