
/**
 * User: denise
 * Date: 3/31/13
 * Time: 5:32 PM
 */
modules = {
    createlistCollection {
        dependsOn 'lib'
        dependsOn 'createlistModel'

        resource url: 'js/create-list/collections/gear-collection.js'
        resource url: 'js/create-list/collections/gear-type-collection.js'
    }

    createlistModel {
        dependsOn 'lib'

        resource url: 'js/create-list/models/gear-model.js'
        resource url: 'js/create-list/models/gear-list-gear-model.js'
        resource url: 'js/create-list/models/create-gear-model.js'
    }

    createlistView {
        dependsOn 'createlistModel'
        dependsOn 'lib'

        resource url: 'js/create-list/views/new-gear-view.js'
        resource url: 'js/create-list/views/gear-selection-view.js'
        resource url: 'js/create-list/views/new-gear-create-view.js'
        resource url: 'js/create-list/views/no-matches-view.js'
        resource url: 'js/create-list/views/gear-hint-view.js'
        resource url: 'js/create-list/views/gear-type-view.js'
        resource url: 'js/create-list/views/create-review-view.js'
        resource url: 'js/create-list/views/selected-gear-view.js'
        resource url: 'js/create-list/views/add-gear-left-panel.js'
    }
    createlist {
        dependsOn 'createlistView'
        dependsOn 'createlistModel'
        dependsOn 'createlistCollection'
        dependsOn 'stylesheets'
        dependsOn 'createstylesheets'
        dependsOn 'lib'

        resource url: '/js/create-list/router.js'
    }

    createstylesheets {
        resource url: '/css/gearlist-create.css', attrs:[rel: "stylesheet", type:'css']
        resource url: '/css/gearlistdisplay.css', attrs:[rel: "stylesheet", type:'css']
    }
}