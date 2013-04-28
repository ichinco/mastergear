package com.mastergear

class UserController {

    def index() {}

    def show() {
        int userId = Integer.parseInt(params.userId);
        GearUser user = GearUser.get(userId);
        def trails = UserTrail.findAllByUser(user);
        def profile = UserProfile.findByUser(user);
        def lists = GearList.findAllByUser(user);
        Set<Gear> gear = lists.collectMany {
            GearList it ->
                GearListGear.findAllByList(it).collect({
                    it2 ->
                        it2.gear
                })
        }

        render view: "show",
                model: [user : user,
                        profile : profile,
                        trails: trails,
                        lists : lists,
                        gear : gear];
    }
}
