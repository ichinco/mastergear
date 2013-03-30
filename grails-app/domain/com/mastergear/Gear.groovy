package com.mastergear

class Gear {

    Date dateCreated
    Date lastUpdated

    Brand brand;
    GearItemType item;
    String title;

    double weight; // in oz

    static hasMany = [providers : Provider]

    static constraints = {
        weight nullable:true
    }

    static mapping = {
        notes length: 500
    }

}
