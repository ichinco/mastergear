package com.mastergear.web

import com.mastergear.Gear
import com.mastergear.GearList
import com.mastergear.GearListGear
import com.mastergear.Trail

class TrailShowController {

    def index() { }

    def show(){
        int trailId = Integer.parseInt(params.id)
        Trail trail = Trail.get(trailId);
        List<GearList> lists = GearList.findAllByTrail(trail);
        Set<Gear> gear = lists.collectMany {
            GearList it ->
                GearListGear.findAllByList(it).collect({
                    it2 ->
                        it2.gear
                })
        }

        render view: "show", model:[
                trail : trail,
                lists : lists,
                gear : gear
        ]
    }

    def list(){
    }
}
