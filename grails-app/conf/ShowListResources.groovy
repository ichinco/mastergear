modules = {
    showListModel {
        dependsOn 'lib'

        resource url:'js/show-list/models/opinion-model.js'
        resource url:'js/show-list/collections/gear-list-gear-opinion-collection.js'
    }

    showListViews{
        dependsOn 'showListModel'
        dependsOn 'lib'

        resource url: 'js/show-list/views/opinion-create-button.js'
        resource url: 'js/show-list/views/opinion-create-view.js'
        resource url: 'js/show-list/views/opinion-show-button.js'
        resource url: 'js/show-list/views/opinion-show-view.js'
    }

    showListStylesheets {
        resource url: 'css/gearlistdisplay.css'
    }

    showList {
        dependsOn 'showListModel'
        dependsOn 'showListViews'
        dependsOn 'lib'
        dependsOn 'stylesheets'
        dependsOn 'showListStylesheets'

        resource url: 'js/show-list/router.js'
    }
}