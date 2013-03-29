package com.mastergear

class Gear {

    Date dateCreated
    Date lastUpdated

    Brand brand;
    GearItemType item;
    String title;

    double weight; // in oz

    List<Provider> providers

    static constraints = {
        weight nullable:true
    }

    static mapping = {
        notes length: 500
    }

}
