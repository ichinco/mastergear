package com.mastergear.admin

import com.mastergear.GearList
import com.mastergear.GearListGear
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class GearListAdminController {
    static scaffold = GearList

    def delete() {
        def gearList = GearList.get(params.id);
        def gear = GearListGear.findAllByList(gearList);
        gear.each({
            it.delete(flush:true);
        })

        gearList.delete();
        if (gearList.hasErrors()) {
            flash.message="could not be deleted"
            forward action:"show", id:gearList.id
        } else {
            forward action:"list"
        }
    }
}
