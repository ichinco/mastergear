package com.mastergear.rest

import com.mastergear.Brand
import com.mastergear.Gear
import com.mastergear.GearGender
import com.mastergear.GearItemType
import com.mastergear.GearList
import com.mastergear.GearListGear
import com.mastergear.GearType
import com.mastergear.Provider
import com.mastergear.ProviderType
import org.springframework.dao.DataIntegrityViolationException

class GearListGearController {

    static allowedMethods = [save: ["PUT","POST"], update: ["PUT","POST"], delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        int listId = Integer.parseInt(params.listId);
        GearList list = GearList.get(listId);
        GearType type = GearType.valueOf(params.gearType.toUpperCase());
        List<GearListGear> gearListGear = GearListGear.findAllByListAndGearType(list, type);

        render (contentType:'text/json'){
            gearListGearInstance: gearListGear
        }
    }

    def create() {
        [gearListGearInstance: new GearListGear(params)]
    }

    def save() {
        def gearListGearInstance = new GearListGear()
        String listId = params.list.id;

        if (listId){
            GearList list = GearList.get(Integer.parseInt(listId));
            gearListGearInstance.list = list;
        }

        if (!gearListGearInstance.list ||
                (grailsApplication.config.grails.addlist.checksession &&
                        !gearListGearInstance.list.user.username.equals(session.getId()))){
            render (contentType:'text/json'){
                gearListGearInstance: gearListGearInstance
            }
            return;
        }

        if (params.weight){
            gearListGearInstance.weight = Double.parseDouble(params.weight);
        }
        gearListGearInstance.quantity = 1;
        gearListGearInstance.notes = params.notes ? params.notes : "";

        def providerId = params.gear.providerId
        Provider provider = Provider.findByProviderId(providerId)
        if(provider)
        {
            gearListGearInstance.gear = provider.gear
        }
        else
        {
            def gear = new Gear()
            String brandName = params.gear.brand;
            if (brandName) {
                Brand brand = Brand.findByName(brandName);
                if (!brand){
                    brand = new Brand();
                    brand.setName(brandName);
                    brand.save(flush: true);
                }
                gear.setBrand(brand);
            }

            String gearItemType = (params.itemType)? params.itemType : "Outdoors Gear";
            if (gearItemType) {
                GearItemType item = GearItemType.findByName(gearItemType);
                if (!item){
                    item = new GearItemType();
                    item.setName(gearItemType);
                    item.save(flush:true);
                }
                gear.setItem(item);
            }
            gear.setTitle(params.gear.title);

            //gear.weight = Double.parseDouble(params.gear.weight)
            if(!gear.save(flush:true))
            {
                render(view: "create", model: [gear: gear])
                return
            }

            gearListGearInstance.gear = gear

            def newProvider = new Provider()
            newProvider.setCategory(params.gear.category)
            newProvider.setGender(GearGender.UNISEX)
            newProvider.setImageUrl(params.imageUrl)
            newProvider.setProductGroup(params.gear.productGroup)
            newProvider.setSubCategory(params.gear.subCategory)
            newProvider.setProviderId(params.gear.providerId)

            // TODO: make the enum select type based on string
            newProvider.setType(ProviderType.AMAZON)
            newProvider.gear = gear;
            newProvider.save(flush:true);
        }

        gearListGearInstance.gearType = GearType.valueOf(params.gearType.name.toUpperCase())

        /*
        def typeString = params.gearType.name;
        gearListGearInstance.gearType = GearType.valueOf(typeString.toUpperCase());

        String gearId = params.gear.id;
        if (gearId) {
            Gear gear = Gear.get(Integer.parseInt(gearId));
            gearListGearInstance.gear = gear;
        }
        */
        if (!gearListGearInstance.save(flush: true)) {
            render(view: "create", model: [gearListGearInstance: gearListGearInstance])
            return
        }

        render (contentType:'text/json'){
            gearListGearInstance: gearListGearInstance
        }
    }

    def show(Long id) {
        def gearListGearInstance = GearListGear.get(id)
        if (!gearListGearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
            redirect(action: "list")
            return
        }

        [gearListGearInstance: gearListGearInstance]
    }

    def edit(Long id) {
        def gearListGearInstance = GearListGear.get(id)
        if (!gearListGearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
            redirect(action: "list")
            return
        }

        [gearListGearInstance: gearListGearInstance]
    }

    def update(Long id) {
        def gearListGearInstance = GearListGear.get(id)

        gearListGearInstance.properties = params

        if (!gearListGearInstance.save(flush: true)) {
            render (contentType:'text/json'){
                gearListGearInstance: gearListGearInstance
            }
        }

        render (contentType:'text/json'){
            gearListGearInstance: gearListGearInstance
        }
    }

    def delete(Long id) {
        def gearListGearInstance = GearListGear.get(id);
        if (!gearListGearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
            return
        }

        try {
            gearListGearInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
        }

        render (contentType:"text/json") {
            success : true
        }
    }
}
