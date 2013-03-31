package com.mastergear

class UserController {

    def index() {}

    def show() {
        int userId = Integer.parseInt(params.userId);
        GearUser user = GearUser.get(userId);
        def trails = UserTrail.findAllByUser(user);
        def profile = UserProfile.findByUser(user);

        render view: "show",
                model: [user : user,
                        profile : profile,
                        trails: trails];
    }
}
