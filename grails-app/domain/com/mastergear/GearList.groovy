package com.mastergear

class GearList {

    Date dateCreated
    Date lastUpdated

    Season season
    Trail trail
    HikeType hikeType
    String listDescription

    static constraints = {
    }

    static mapping = {
        listDescription size: 500
    }
}
