package com.mastergear

class GearList {

    Date dateCreated
    Date lastUpdated

    User user
    Season season
    Trail trail
    HikeType hikeType
    String listDescription
    List<GearList> gears


    static constraints = {
    }

    static mapping = {
        listDescription size: 500
    }

    public getGearByType(GearType gearType) {
        return gears.findAll({
            it ->
            it.gearType.equals(gearType)
        })
    }
}
