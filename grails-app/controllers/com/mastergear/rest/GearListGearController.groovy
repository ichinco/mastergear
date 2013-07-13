package com.mastergear.rest

import com.mastergear.Gear
import com.mastergear.GearList
import com.mastergear.GearListGear
import com.mastergear.GearType
import grails.converters.deep.JSON
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

        JSON.use('deep');
        render gearListGear as JSON
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

        if (!gearListGearInstance.list || !gearListGearInstance.list.user.username.equals(session.getId())){
            render (contentType:'text/json'){
                gearListGearInstance: gearListGearInstance
            }
            return;
        }

        gearListGearInstance.quantity = 1;
        gearListGearInstance.notes = params.notes ? params.notes : "";

        def typeString = params.gearType.name;
        gearListGearInstance.gearType = GearType.valueOf(typeString.toUpperCase());

        String gearId = params.gear.id;
        if (gearId) {
            Gear gear = Gear.get(Integer.parseInt(gearId));
            gearListGearInstance.gear = gear;
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
