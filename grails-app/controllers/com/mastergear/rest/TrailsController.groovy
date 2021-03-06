package com.mastergear.rest

import com.mastergear.Trail

class TrailsController {

    def geocodingService

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

    def show(String query) {
        def trails = [];
        if (query) {
            trails = geocodingService.getTrail(query);
        } else {
            trails.addAll(Trail.where {
                gearLists.size() > 0
            }.list());
        }

        render (contentType:'text/json'){
            trailInstanceList: trails
        }
    }
}
