package com.mastergear

class UserTrail {

    Date dateCreated;
    Date lastUpdated;

    GearUser user;
    Trail trail;
    Date hikeDate;
    String notes;


    static constraints = {
    }

    static mapping = {
        notes length:500
    }
}
