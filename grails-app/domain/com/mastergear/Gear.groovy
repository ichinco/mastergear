package com.mastergear

class Gear {

    Date dateCreated
    Date lastUpdated

    String imageUrl;
    String url;
    String name;
    String notes;
    double weight; // in oz
    double quantity;

    GearType gearType;

    static constraints = {
    }

    static mapping = {
        url size: 500;
        notes size:500
    }
}
