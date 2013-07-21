package com.mastergear

import grails.converters.JSON

class Gear {

    static searchable = {
        except = ['dateCreated', 'lastUpdated']
        item component:true
    }

    Date dateCreated
    Date lastUpdated

    Brand brand;
    GearItemType item;
    String title;
    String manufacturerId;

    double weight; // in oz

    static hasMany = [providers : Provider]

    static constraints = {
        weight nullable:true
        manufacturerId nullable:true
    }

    public static void register(grailsApplication) {
        JSON.registerObjectMarshaller(Gear) {
            def g = grailsApplication.mainContext.getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib');
            return [id: it.id,
                    brand: it.brand.name,
                    itemType: it.item.name,
                    title: it.title,
                    weight: it.weight,
                    providers: it.providers,
                    dateCreated: it.dateCreated.getTime(),
                    lastUpdated: it.lastUpdated.getTime()]
        }
    }
}
