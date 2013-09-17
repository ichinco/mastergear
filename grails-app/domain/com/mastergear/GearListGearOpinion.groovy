package com.mastergear

class GearListGearOpinion {

    Date lastUpdated
    Date dateCreated

    OpinionType opinionType;
    String textOpinion
    Gear alternative;
    GearListGear gearListGear;
    GearUser user;

    static mapping = {
       textOpinion type: 'text'
    }

    static constraints = {
        textOpinion nullable:true
        alternative nullable: true
        gearListGear unique: 'user'
    }
}
