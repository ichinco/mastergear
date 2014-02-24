package com.mastergear

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

/**
 * Date: 2/23/14
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
class GearService {
    public create(params)
    {
        Gear gear = new Gear();

        GearItemType item;
        String title;

        String brandName = params.gear.brand;
        if (brandName) {
            Brand brand = Brand.findByName(brandName);
            if (!brand){
                brand = new Brand();
                brand.setName(brandName);
                brand.save(flush:true);
            }
            gear.brand = brand ;
        }

        String gearItemType = params.type;
        if (gearItemType) {
            GearItemType t = GearItemType.findByName(gearItemType);
            if (!t){
                t = new GearItemType();
                t.setName(gearItemType);
                t.save(flush:true);
            }

            gear.item = t;
        }

        gear.title = params.title;
        gear.weight = Double.parseDouble(params.weight);
        gear.save(flush:true);

        Provider p = new Provider();
        p.gender = GearGender.valueOf(params.gender);
        p.type = ProviderType.valueOf(params.providerType);
        p.imageId = params.imageId;
        p.providerId = params.providerId;
        p.gear = gear;
        p.save(flush:true);

        render (contentType:'text/json'){
            gearInstance: gear
        }
    }
}
