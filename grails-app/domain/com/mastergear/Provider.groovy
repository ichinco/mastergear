package com.mastergear

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
}
