
/**
 * User: denise
 * Date: 3/31/13
 * Time: 5:32 PM
 */
modules = {
    initlistCollection {
        dependsOn 'lib'
        dependsOn 'initlistModel'

        resource url: 'js/initialize-list/collections/possible-trail-collection.js'
    }

    initlistModel {
        dependsOn 'lib'

        resource url: 'js/initialize-list/models/trail-model.js'
    }

    initlistView {
        dependsOn 'initlistModel'
        dependsOn 'lib'

        resource url: 'js/initialize-list/views/select-trail-button.js'
        resource url: 'js/initialize-list/views/possible-trails-list.js'
        resource url: 'js/initialize-list/views/trail.js'
        resource url: 'js/initialize-list/views/create-trail-view.js'
        resource url: 'js/initialize-list/views/no-matches-view.js'
        resource url: 'js/initialize-list/views/trail-query-view.js'
        resource url: 'js/initialize-list/views/select-trail-dialog.js'
    }
    initlist {
        dependsOn 'initlistView'
        dependsOn 'initlistModel'
        dependsOn 'initlistCollection'
        dependsOn 'stylesheets'
        dependsOn 'lib'

        resource url: '/js/initialize-list/router.js'
    }

    stylesheets {
        resource url: '/css/forms.css', attrs:[rel: "stylesheet", type:'css']
        resource url: '/css/initialize.css', attrs:[rel: "stylesheet", type:'css']
    }



}