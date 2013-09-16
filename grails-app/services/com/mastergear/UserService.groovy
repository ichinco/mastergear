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

    def createUser(String username, String password, String email){
        GearUser user = new GearUser();
        user.username = username;
        user.accountExpired = false;
        user.accountLocked = false;
        user.anonymous = false;
        user.enabled = true;
        user.passwordExpired = false;
        user.password = password;
        user.save(flush:true);

        UserProfile profile = new UserProfile();
        profile.about = ""
        profile.email = email;
        profile.twitterId = "";
        profile.gearPhilosophy = "";
        profile.user = user;
        profile.save(flush: true);
    }
}
