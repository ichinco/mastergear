package com.mastergear

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

}
