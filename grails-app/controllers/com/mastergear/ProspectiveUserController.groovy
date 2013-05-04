package com.mastergear

import org.springframework.dao.DataIntegrityViolationException

class ProspectiveUserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def create() {
        String category = params.category;

        render view:"create", model: [
                category : category
        ]
    }

    def save() {
        def prospectiveUserInstance = new ProspectiveUser(params)
        prospectiveUserInstance.save(flush : true);
        redirect(action: "index", controller: "gearList")
    }

}
