
/**
 * User: denise
 * Date: 3/31/13
 * Time: 5:32 PM
 */
modules = {
    createlistModel {
        dependsOn 'lib'

        resource url: 'js/create-list/models/gear-model.js'
        resource url: 'js/create-list/models/gear-type-model.js'
    }

    createlistView {
        dependsOn 'createlistModel'
        dependsOn 'lib'

        resource url: 'js/create-list/views/new-gear-view.js'
    }
    createlist {
        dependsOn 'createlistView'
        dependsOn 'createlistModel'
        dependsOn 'stylesheets'
        dependsOn 'lib'

        resource url: '/js/create-list/router.js'
    }

    stylesheets {
        resource url: '/css/mastergear.css', attrs:[rel: "stylesheet/less", type:'css']
    }

    lib {
        dependsOn 'jquery' //provided by plugin
        dependsOn 'backbone' //provided by plugin
    }

}