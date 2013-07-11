package com.mastergear.web

import com.mastergear.ProspectiveUser

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
