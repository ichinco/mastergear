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

    public static void register() {
        JSON.registerObjectMarshaller(GearList) {
            return [id: it.id,
                    season: it.season,
                    trail:it.trail,
                    hikeType: it.hikeType,
                    user: it.user,
                    listDescription:it.listDescription,
                    imageUrl:it.imageUrl,
                    dateCreated: it.dateCreated.getTime(),
                    lastUpdated: it.lastUpdated.getTime()]
        }
    }
}
