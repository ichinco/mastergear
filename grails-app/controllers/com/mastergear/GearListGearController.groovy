package com.mastergear

import org.springframework.dao.DataIntegrityViolationException

class GearListGearController {

    static allowedMethods = [save: ["PUT","POST"], update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        int listId = Integer.parseInt(params.listId);
        GearList list = GearList.get(listId);
        GearType type = GearType.valueOf(params.gearType.toUpperCase());
        List<GearListGear> gearListGear = GearListGear.findAllByListAndGearType(list, type);
        def gear = gearListGear.collect({
            it.gear
        })
        render (contentType:'text/json'){
            gear
        }
    }

    def create() {
        [gearListGearInstance: new GearListGear(params)]
    }

    def save() {
        def gearListGearInstance = new GearListGear()
        gearListGearInstance.quantity = 1;
        gearListGearInstance.notes = "";
        gearListGearInstance.gearType = GearType.valueOf(params.gear.gearType.toUpperCase());

        String gearId = params.gear.id;
        if (gearId) {
            Gear gear = Gear.get(Integer.parseInt(gearId));
            gearListGearInstance.gear = gear;
        }

        String listId = params.gear.listId;
        if (listId){
            GearList list = GearList.get(Integer.parseInt(listId));
            gearListGearInstance.list = list;
        }

        GearListGear gearListGear = GearListGear.findByGearAndListAndGearType(gearListGearInstance.gear,gearListGearInstance.list,gearListGearInstance.gearType);

        if (gearListGear){
            render (contentType:'text/json'){
                gearListGearInstance: gearListGear
            }
        }

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

    def update(Long id, Long version) {
        def gearListGearInstance = GearListGear.get(id)
        if (!gearListGearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (gearListGearInstance.version > version) {
                gearListGearInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'gearListGear.label', default: 'GearListGear')] as Object[],
                        "Another user has updated this GearListGear while you were editing")
                render(view: "edit", model: [gearListGearInstance: gearListGearInstance])
                return
            }
        }

        gearListGearInstance.properties = params

        if (!gearListGearInstance.save(flush: true)) {
            render(view: "edit", model: [gearListGearInstance: gearListGearInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), gearListGearInstance.id])
        redirect(action: "show", id: gearListGearInstance.id)
    }

    def delete(Long id) {
        def gearListGearInstance = GearListGear.get(id)
        if (!gearListGearInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
            redirect(action: "list")
            return
        }

        try {
            gearListGearInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), id])
            redirect(action: "show", id: id)
        }
    }
}
