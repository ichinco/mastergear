package com.mastergear.admin

import com.mastergear.Gear
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class GearAdminController {
    static scaffold = Gear
}
