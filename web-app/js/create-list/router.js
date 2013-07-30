var Mastergear = Mastergear || {};
Mastergear.Obj = Mastergear.Obj || {};
Mastergear.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    buildAddView : function(cssClass, reviewView, createGearModel) {

        var packModel = new Mastergear.Collection.GearType({
            listId : Mastergear.listId,
            gearType : cssClass
        });
        packModel.fetch({remove : true, add : true, change : true});

        createGearModel.addGearTypeModel(cssClass, packModel);

        var noMatchesView = new Mastergear.Views.NoMatchesView({
            el : '.' + cssClass + ' .no-match',
            model : packModel
        });

        var selectedGearView = new Mastergear.Views.GearType({
            el : '.' + cssClass + ' .added-gear',
            model : packModel,
            reviewView : reviewView
        });


    },

    main: function() {
        var createGearModel = new Mastergear.Models.CreateGear();
        createGearModel.setCurrentGearType("pack");
        var possiblePackModel = new Mastergear.Collection.GearList();

        var createReviewView = new Mastergear.Views.CreateReview({
            el : '#review-gear'
        });

        var newGearDialog = new Mastergear.Views.AddGearDialog({
            el : '.add-gear',
            model : createGearModel,
            possibleGearModel : possiblePackModel
        });

        var packView = new Mastergear.Views.AddGearButton({
            el : '.add-gear-button',
            model : createGearModel
        });

        var gearHintView = new Mastergear.Views.GearHintView({
            el : '.get-suggestions',
            model : possiblePackModel,
            createGearModel : createGearModel
        });

        var gearSuggestionView = new Mastergear.Views.GearSelection({
            el : '.add-gear .gear-suggestion',
            model : possiblePackModel
        });

        var selectedGearView = new Mastergear.Views.SelectedGearView({
            el : '.add-gear .selected-gear',
            possibleGearModel : createGearModel
        });

        var leftPanel = new Mastergear.Views.LeftPanel({
            el : '.content',
            model : createGearModel
        });

        this.buildAddView('pack',createReviewView, createGearModel);

        this.buildAddView('sleep',createReviewView, createGearModel);
        this.buildAddView('cooking',createReviewView, createGearModel);
        this.buildAddView('food',createReviewView, createGearModel);
        this.buildAddView('water',createReviewView, createGearModel);
        this.buildAddView('clothes',createReviewView, createGearModel);
        this.buildAddView('electronics',createReviewView, createGearModel);
        this.buildAddView('emergency',createReviewView, createGearModel);
        this.buildAddView('other',createReviewView, createGearModel);

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