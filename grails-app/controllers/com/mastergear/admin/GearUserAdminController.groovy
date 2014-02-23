package com.mastergear.admin

import com.mastergear.GearUser
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class GearUserAdminController {
    static scaffold = GearUser
}
