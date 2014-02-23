package com.mastergear

import com.mastergear.GearGender
import grails.converters.JSON

class Provider {

    Date dateCreated
    Date lastUpdated

    GearGender gender;
    ProviderType type;
    String imageId;
    String providerId;

    Gear gear;

    String category;
    String imageUrl;
    String providerSku;
    String linkUrl;
    String impressionUrl;

    String longDescription;
    String shortDescription;
    String subCategory;
    String productGroup;
    String keywords;

    static constraints = {
        category nullable:true
        imageUrl nullable:true
        providerSku nullable:true
        linkUrl nullable:true
        impressionUrl nullable:true
        longDescription nullable:true
        shortDescription nullable:true
        subCategory nullable:true
        productGroup nullable:true
        keywords nullable: true
    }

    static mapping = {
       longDescription type: 'text'
       shortDescription type: 'text'
       subCategory size:500
       productGroup size:500
       keywords type:'text'
    }

    public static void register(grailsApplication) {
        JSON.registerObjectMarshaller(Provider) {
            def g = grailsApplication.mainContext.getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib');
            return [id: it.id,
                    gender: g.message(code: "geargender.${it.gender.toString().toLowerCase()}"),
                    type: g.message(code: "providertype.${it.type.toString().toLowerCase()}"),
                    category: it.category,
                    longDescription: it.longDescription,
                    shortDescription: it.shortDescription,
                    subCategory: it.subCategory,
                    keywords: it.keywords,
                    productGroup: it.productGroup,
                    providerId: it.providerId,
                    imageUrl : g.message(code:"providertype.html.${it.type.toString().toLowerCase()}", args:[it.providerId, it.imageId, it.imageUrl]),
                    iconUrl : g.message(code:"providertype.html.icon.${it.type.toString().toLowerCase()}", args:[it.providerId, it.imageId]),
                    dateCreated: it.dateCreated?.getTime(),
                    lastUpdated: it.lastUpdated?.getTime()]
        }
    }
}
