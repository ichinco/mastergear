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

    static constraints = {
        category nullable:true
        imageUrl nullable:true
        providerSku nullable:true
        linkUrl nullable:true
        impressionUrl nullable:true
    }
}
