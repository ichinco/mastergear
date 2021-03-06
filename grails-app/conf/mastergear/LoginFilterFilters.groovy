package mastergear

import com.mastergear.GearUser

class LoginFilterFilters {

    def springSecurityService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                request.isLoggedIn = springSecurityService.isLoggedIn();
                if (request.isLoggedIn) {
                    request.username = ((GearUser) springSecurityService.currentUser).username;
                    request.userId = ((GearUser) springSecurityService.currentUser).id
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
