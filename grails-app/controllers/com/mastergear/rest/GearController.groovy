package com.mastergear.rest

import com.mastergear.Brand
import com.mastergear.Gear
import com.mastergear.GearGender
import com.mastergear.GearItemType
import com.mastergear.Provider
import com.mastergear.ProviderType
import org.springframework.dao.DataIntegrityViolationException

class GearController {

    def jestElasticSearchService;

    static allowedMethods = [save: ["PUT","POST"], update: "PUT", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        String gearItemTypeId = params.itemType;
        def gear;
        if (gearItemTypeId){
            GearItemType type = GearItemType.get(gearItemTypeId);
            gear = Gear.findAllByItem(type);
        } else {
            gear = Gear.list(params);
        }

        render (contentType:'text/json'){
            gearInstanceList: gear
        }
    }

    def search(String term) {
        String query = """{
                    "explain" : true,
                    "from" : 0, "size" : 100,
                    "query" : {
                          "multi_match" : {
                            "use_dis_max" : false,
                            "query" : "${term}",
                            "fields" : [ "brand^2", "title^2",
                            "category","subCategory^3","productGroup^3","keywords^3"]
                          }
                    }}"""
        def result = jestElasticSearchService.getGear(query);

        render (contentType:'text/json'){
            gearInstanceList: result
        }
    }

    def create() {
        Gear gear = new Gear();
        String brand = params.brand;
        if (brand) {
            Brand b = Brand.findByName(brand);
            if (!b){
                b = new Brand();
                b.setName(brand);
                b.save(flush:true);
            }

            gear.brand = b;
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
        p.type = ProviderType.valueOf(params.type);
        p.imageId = params.imageId;
        p.providerId = params.providerId;
        p.gear = gear;
        p.save(flush:true);

        render (contentType:'text/json'){
            gearInstance: gear
        }
    }

    def save() {
        Gear gear = new Gear();
        String brand = params.brand;
        if (brand) {
            Brand b = Brand.findByName(brand);
            if (!b){
                b = new Brand();
                b.setName(brand);
                b.save(flush:true);
            }

            gear.brand = b;
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

    def show(Long id) {
        def gearInstance = Gear.get(id)
        if (!gearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gear.label', default: 'Gear'), id])
            redirect(action: "list")
            return
        }

        [gearInstance: gearInstance]
    }

    def edit(Long id) {
        def gearInstance = Gear.get(id)
        if (!gearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gear.label', default: 'Gear'), id])
            redirect(action: "list")
            return
        }

        [gearInstance: gearInstance]
    }

    def update(Long id, Long version) {
        def gearInstance = Gear.get(id)
        if (!gearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gear.label', default: 'Gear'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (gearInstance.version > version) {
                gearInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'gear.label', default: 'Gear')] as Object[],
                        "Another user has updated this Gear while you were editing")
                render(view: "edit", model: [gearInstance: gearInstance])
                return
            }
        }

        gearInstance.properties = params

        if (!gearInstance.save(flush: true)) {
            render(view: "edit", model: [gearInstance: gearInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'gear.label', default: 'Gear'), gearInstance.id])
        redirect(action: "show", id: gearInstance.id)
    }

    def delete(Long id) {
        def gearInstance = Gear.get(id)
        if (!gearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gear.label', default: 'Gear'), id])
            redirect(action: "list")
            return
        }

        try {
            gearInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'gear.label', default: 'Gear'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'gear.label', default: 'Gear'), id])
            redirect(action: "show", id: id)
        }
    }
}
