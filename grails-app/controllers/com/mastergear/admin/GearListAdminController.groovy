package com.mastergear.admin

import com.mastergear.GearList
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class GearListAdminController {
    static scaffold = GearList
}
