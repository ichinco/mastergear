package com.mastergear

class Provider {

    Date dateCreated
    Date lastUpdated

    GearGender gender;
    ProviderType type;
    String imageId;
    String providerId;

    Gear gear;

    static constraints = {
    }
}