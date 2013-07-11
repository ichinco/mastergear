package com.mastergear.rest

import com.mastergear.Trail

class TrailsController {

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

    def show(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render (contentType:'text/json'){
            trailInstanceList: Trail.list(params)
        }
    }
}
