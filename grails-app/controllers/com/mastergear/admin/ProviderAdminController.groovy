package com.mastergear.admin

import com.mastergear.Provider
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ProviderAdminController {
    static scaffold = Provider
}
