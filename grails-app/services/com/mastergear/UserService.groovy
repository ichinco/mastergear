package com.mastergear

class UserService {

    def createAnonymousUser(String sessionId) {
        GearUser user = new GearUser();
        user.anonymous = true;
        user.username = sessionId;
        user.password = "none";
        user.accountLocked = true;
        user.enabled = false;
        user.save(flush:true);

        return user;
    }
}
