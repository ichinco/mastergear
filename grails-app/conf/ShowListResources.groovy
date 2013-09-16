modules = {
    showListModel {
        dependsOn 'lib'

        resource url:'js/show-list/models/opinion-model.js'
    }

    showListViews{
        dependsOn 'showListModel'
        dependsOn 'lib'

        resource url: 'js/show-list/views/opinion-create-button.js'
        resource url: 'js/show-list/views/opinion-create-view.js'
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
    }
}