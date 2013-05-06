package com.mastergear

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
        render view: "list", model:[
            trails : Trail.list()
        ]
    }
}
