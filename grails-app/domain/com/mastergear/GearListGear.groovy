package com.mastergear

class GearListGear {

    Date dateCreated
    Date lastUpdated

    Gear gear
    GearList list

    int quantity
    String notes;
    GearType gearType;

    static constraints = {
    }

    static mapping = {
        notes size:500
    }
}
