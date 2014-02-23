package com.mastergear

import com.mastergear.GearType
import grails.converters.JSON

class GearListGear {

    Date dateCreated
    Date lastUpdated

    Gear gear
    GearList list

    int quantity
    String notes;
    GearType gearType;
    Double weight; //overrides the gear weight

    static constraints = {
        weight nullable:true
    }

    static mapping = {
        notes size:500
    }

    public static void register(grailsApplication) {
        JSON.registerObjectMarshaller(GearListGear) {
            def g = grailsApplication.mainContext.getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib');
            return [id: it.id,
                    gear: it.gear,
                    list: it.list,
                    weight: it.weight && it.weight > 0 ? it.weight : it.gear.weight,
                    quantity: it.quantity,
                    notes: it.notes,
                    type: g.message(code:"geartype.${it.gearType.toString().toLowerCase()}"),
                    dateCreated: it.dateCreated.getTime(),
                    lastUpdated: it.lastUpdated.getTime()]
        }
    }

}
