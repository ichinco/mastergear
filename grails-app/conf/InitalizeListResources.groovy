
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
        resource url: 'js/initialize-list/views/select-trail-dialog.js'
        resource url: 'js/initialize-list/views/possible-trails-list.js'
        resource url: 'js/initialize-list/views/trail.js'
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
        resource url: '/css/mastergear.css', attrs:[rel: "stylesheet/less", type:'css']
    }

    lib {
        dependsOn 'jquery' //provided by plugin
        dependsOn 'backbone' //provided by plugin
    }

}