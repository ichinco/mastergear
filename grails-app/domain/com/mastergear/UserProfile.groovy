package com.mastergear

class UserProfile {

    Date dateCreated;
    Date lastUpdated;

    GearUser user;
    String about;
    String gearPhilosophy;
    String twitterId;
    Trail favoriteTrail;

    static constraints = {
    }

    static mapping = {
        about length: 1000;
        gearPhilosophy length: 1000;
    }
}
