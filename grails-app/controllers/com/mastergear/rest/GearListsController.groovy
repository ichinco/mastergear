package com.mastergear.rest

import com.mastergear.GearList
import com.mastergear.Trail

class GearListsController {

    def show(int trailId) {
        Trail trail = Trail.get(trailId);
        List<GearList> lists = GearList.findAllByTrail(trail);

        render (contentType:'text/json'){
            gearLists: lists
        }
    }
}
