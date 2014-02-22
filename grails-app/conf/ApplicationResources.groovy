modules = {
    application {
        resource url:'js/application.js'
    }

    lib {
        dependsOn 'jquery' //provided by plugin
        dependsOn 'backbone' //provided by plugin
        dependsOn 'bootstrap-css'
        dependsOn 'bootstrap-js'
    }
    leaflet {
        resource url: 'js/leaflet/leaflet.js'
        resource url: 'js/leaflet/leaflet.css'
    }
    moment {
        resource url: 'js/moment.min.js'
    }

    jqueryMouseWheel{
        dependsOn 'jquery'
        resource url: 'js/jquery.mousewheel.min.js'
    }

    malihuScrollbar {
        dependsOn 'jqueryMouseWheel'
        resource url: 'js/scroll/jquery.mCustomScrollbar.min.js'
        resource url: 'js/scroll/jquery.mCustomScrollbar.css'
    }
}