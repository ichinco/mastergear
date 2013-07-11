package com.mastergear

import grails.converters.JSON

class Trail {

    Date dateCreated
    Date lastUpdated

    String name;
    String location;
    double latitude;
    double longitude;
    double maxElevation; // in feet

    static constraints = {
    }

    public static void register() {
        JSON.registerObjectMarshaller(Trail) {
            return [id:it.id, name:it.name, location: it.location,
            latitude: it.latitude,
            longitude: it.longitude,
            maxElevation: it.maxElevation,
            dateCreated: it.dateCreated.getTime(),
            lastUpdated: it.lastUpdated.getTime()]
        }
    }

}
