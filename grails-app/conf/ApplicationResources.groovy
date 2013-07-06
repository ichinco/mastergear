modules = {
    application {
        resource url:'js/application.js'
    }

    lib {
        dependsOn 'jquery' //provided by plugin
        dependsOn 'backbone' //provided by plugin
    }
    leaflet {
        resource url: 'js/leaflet/leaflet.js'
        resource url: 'js/leaflet/leaflet.css'
    }
}