package com.mastergear

import org.springframework.dao.DataIntegrityViolationException

class TrailController {
    
    static allowedMethods = [save: "PUT", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render (contentType:'text/json'){
            trailInstanceList: Trail.list(params)
        }
    }

    def create() {
        [trailInstance: new Trail(params)]
    }

    def save() {
        def trailInstance = new Trail(params)
        if (!trailInstance.save(flush: true)) {
            render(view: "create", model: [trailInstance: trailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'trail.label', default: 'Trail'), trailInstance.id])
        render (contentType:'text/json'){
            trailInstance: trailInstance
        }
    }

    def show(Long id) {
        def trailInstance = Trail.get(id)
        if (!trailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trail.label', default: 'Trail'), id])
            redirect(action: "list")
            return
        }

        [trailInstance: trailInstance]
    }

    def edit(Long id) {
        def trailInstance = Trail.get(id)
        if (!trailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trail.label', default: 'Trail'), id])
            redirect(action: "list")
            return
        }

        [trailInstance: trailInstance]
    }

    def update(Long id, Long version) {
        def trailInstance = Trail.get(id)
        if (!trailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trail.label', default: 'Trail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (trailInstance.version > version) {
                trailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'trail.label', default: 'Trail')] as Object[],
                        "Another user has updated this Trail while you were editing")
                render(view: "edit", model: [trailInstance: trailInstance])
                return
            }
        }

        trailInstance.properties = params

        if (!trailInstance.save(flush: true)) {
            render(view: "edit", model: [trailInstance: trailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'trail.label', default: 'Trail'), trailInstance.id])
        redirect(action: "show", id: trailInstance.id)
    }

    def delete(Long id) {
        def trailInstance = Trail.get(id)
        if (!trailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trail.label', default: 'Trail'), id])
            redirect(action: "list")
            return
        }

        try {
            trailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'trail.label', default: 'Trail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'trail.label', default: 'Trail'), id])
            redirect(action: "show", id: id)
        }
    }    

    def show(){
        int trailId = Integer.parseInt(params.id)
        Trail trail = Trail.get(trailId);
        List<GearList> lists = GearList.findAllByTrail(trail);
        Set<Gear> gear = lists.collectMany {
            GearList it ->
                GearListGear.findAllByList(it).collect({
                    it2 ->
                        it2.gear
                })
        }

        render view: "show", model:[
                trail : trail,
                lists : lists,
                gear : gear
        ]
    }

    def list(){
        render view: "list", model:[
            trails : Trail.list()
        ]
    }
}
