/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 7/6/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
var Mastergear = Mastergear || {};
Mastergear.Views = Mastergear.Views || {};

Mastergear.Views.IntroDialog = Backbone.View.extend({
    events : {
        'click .close-button' : 'close'
    },

    initialize : function(){
        _.bindAll(this);
    },

    close : function(evt) {
        this.$el.hide();
    }
});