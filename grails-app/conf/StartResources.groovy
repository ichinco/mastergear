modules = {
    start {
        dependsOn 'flat'
        dependsOn 'leaflet'
        dependsOn 'lib'
        dependsOn 'startcollections'
        dependsOn 'startmodels'
        dependsOn 'startviews'

        resource url:'css/map.css'
        resource url:'js/start/router.js'
    }
    startcollections {
        dependsOn 'lib'

        resource 'js/start/collections/possible-trail-collection.js'
    }

    startmodels {
        dependsOn 'lib'

        resource 'js/start/models/trail-model.js'
    }

    startviews {
        dependsOn 'lib'

        resource 'js/start/views/map-view.js'
        resource 'js/start/views/intro-dialog.js'
    }
    flat {
        resource url:'css/flat.css'
    }
}