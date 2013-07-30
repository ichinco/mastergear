package com.mastergear.admin

import com.mastergear.Trail
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class TrailAdminController {
    static scaffold = Trail
}
