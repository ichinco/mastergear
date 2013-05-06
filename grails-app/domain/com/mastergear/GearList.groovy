package com.mastergear

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
}
