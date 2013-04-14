package com.mastergear

import org.springframework.dao.DataIntegrityViolationException

class GearListGearController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [gearListGearInstanceList: GearListGear.list(params), gearListGearInstanceTotal: GearListGear.count()]
    }

    def create() {
        [gearListGearInstance: new GearListGear(params)]
    }

    def save() {
        def gearListGearInstance = new GearListGear(params)
        if (!gearListGearInstance.save(flush: true)) {
            render(view: "create", model: [gearListGearInstance: gearListGearInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'gearListGear.label', default: 'GearListGear'), gearListGearInstance.id])
        redirect(action: "show", id: gearListGearInstance.id)
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
