package com.mastergear.web

import com.mastergear.Gear
import com.mastergear.GearList
import com.mastergear.GearListGear
import com.mastergear.GearUser
import com.mastergear.UserProfile
import com.mastergear.UserTrail

class UserController {

    def index() {}

    def show() {
        int userId = Integer.parseInt(params.userId);
        GearUser user = GearUser.get(userId);
        if (!user || user.isAnonymous()) {
            render view: "notfound";
            return;
        }
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

    def list(){
        render view: "list", model:[
            users : GearUser.findAllByAnonymous(false)
        ]
    }
}
