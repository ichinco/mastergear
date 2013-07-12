package com.mastergear

import grails.converters.JSON

class GearList {

    Date dateCreated
    Date lastUpdated

    Season season
    Trail trail
    HikeType hikeType
    String listDescription
    String imageUrl;

    GearUser user

    static constraints = {
        imageUrl nullable: true
    }

    static mapping = {
        listDescription size: 500
        imageUrl size: 500
    }

    public static void register(grailsApplication) {
        JSON.registerObjectMarshaller(GearList) {
            def g = grailsApplication.mainContext.getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib');
            return [id: it.id,
                    season: g.message(code: "season.${it.season.toString().toLowerCase()}"),
                    trail:it.trail,
                    hikeType: g.message(code: "hiketype.${it.hikeType.toString().toLowerCase()}"),
                    user: it.user,
                    listDescription:it.listDescription,
                    imageUrl:it.imageUrl,
                    dateCreated: it.dateCreated.getTime(),
                    lastUpdated: it.lastUpdated.getTime(),
                    url: g.createLink(controller:"gearList", action:"show", id: it.getId())
            ]
        }
    }
}
