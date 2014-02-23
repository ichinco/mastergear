package com.mastergear

import grails.converters.JSON

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

    public static void register(grailsApplication) {
        JSON.registerObjectMarshaller(GearListGearOpinion) {
            def g = grailsApplication.mainContext.getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib');
            return [id: it.id,
                    gear: it.gearListGear,
                    user: it.user,
                    opinionText: it.textOpinion,
                    type: g.message(code:"opinionType.${it.opinionType.toString().toLowerCase()}"),
                    dateCreated: it.dateCreated.getTime(),
                    lastUpdated: it.lastUpdated.getTime()]
        }
    }
}
