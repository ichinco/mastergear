package com.mastergear.rest

import com.mastergear.GearListGearOpinion
import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['IS_AUTHENTICATED_FULLY'])
class GearListGearOpinionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [gearListGearOpinionInstanceList: GearListGearOpinion.list(params), gearListGearOpinionInstanceTotal: GearListGearOpinion.count()]
    }

    def create() {
        [gearListGearOpinionInstance: new GearListGearOpinion(params)]
    }

    def save() {
        def gearListGearOpinionInstance = new GearListGearOpinion(params)
        if (!gearListGearOpinionInstance.save(flush: true)) {
            render(view: "create", model: [gearListGearOpinionInstance: gearListGearOpinionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), gearListGearOpinionInstance.id])
        redirect(action: "show", id: gearListGearOpinionInstance.id)
    }

    def show(Long id) {
        def gearListGearOpinionInstance = GearListGearOpinion.get(id)
        if (!gearListGearOpinionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), id])
            redirect(action: "list")
            return
        }

        [gearListGearOpinionInstance: gearListGearOpinionInstance]
    }

    def edit(Long id) {
        def gearListGearOpinionInstance = GearListGearOpinion.get(id)
        if (!gearListGearOpinionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), id])
            redirect(action: "list")
            return
        }

        [gearListGearOpinionInstance: gearListGearOpinionInstance]
    }

    def update(Long id, Long version) {
        def gearListGearOpinionInstance = GearListGearOpinion.get(id)
        if (!gearListGearOpinionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (gearListGearOpinionInstance.version > version) {
                gearListGearOpinionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion')] as Object[],
                        "Another user has updated this GearListGearOpinion while you were editing")
                render(view: "edit", model: [gearListGearOpinionInstance: gearListGearOpinionInstance])
                return
            }
        }

        gearListGearOpinionInstance.properties = params

        if (!gearListGearOpinionInstance.save(flush: true)) {
            render(view: "edit", model: [gearListGearOpinionInstance: gearListGearOpinionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), gearListGearOpinionInstance.id])
        redirect(action: "show", id: gearListGearOpinionInstance.id)
    }

    def delete(Long id) {
        def gearListGearOpinionInstance = GearListGearOpinion.get(id)
        if (!gearListGearOpinionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), id])
            redirect(action: "list")
            return
        }

        try {
            gearListGearOpinionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'gearListGearOpinion.label', default: 'GearListGearOpinion'), id])
            redirect(action: "show", id: id)
        }
    }
}
