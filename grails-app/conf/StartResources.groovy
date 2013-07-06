modules = {
    start {
        dependsOn 'flat'
        dependsOn 'leaflet'
        dependsOn 'lib'

        resource url:'css/map.css'
        resource url:'js/start/map.js'
    }
    flat {
        resource url:'css/flat.css'
    }
}