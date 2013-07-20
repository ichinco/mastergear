package com.mastergear.web

import com.mastergear.GearList
import com.mastergear.GearListGear
import com.mastergear.GearType
import com.mastergear.GearUser
import com.mastergear.HikeType
import com.mastergear.Season
import com.mastergear.Trail
import com.mastergear.Weight

class GearListController {

    def gearListService;
    def userService;

    def index() {
        render(view: 'start')
    }

    def create() {
        int id = Integer.parseInt(params.id);
        GearList list = GearList.get(id);
        GearUser user = list.user

        if (user.username.equals(session.getId())) {
            render view: "create", model: [list : list, totalWeight: gearListService.getListWeight(list)]
        } else {
            render view: "cookies"
        }
    }

    def initialize() {
        render view: "initialize"
    }

    def trailList() {
        render view: "trailList"
    }

    def initializeSave() {
        String seasonString = params.season;
        String hikeType = params.hikeType;
        String trail = params.trail;
        String userId = params.user;

        GearList gearList = new GearList();
        gearList.listDescription = params.listDescription;
        gearList.title = params.title;

        GearUser user = null;
        if (userId && Integer.parseInt(userId) > 0){
            user = GearUser.get(Integer.parseInt(userId)); // get the actual user once there are users
        } else {
            user = GearUser.findByUsernameAndAnonymous(session.getId(), true);
            if (! user){
                user = userService.createAnonymousUser(session.getId());
            }
        }
        gearList.user = user;

        if (seasonString) {
            gearList.season = Season.valueOf(seasonString);
        }

        if (hikeType) {
            gearList.hikeType = HikeType.valueOf(hikeType);
        }

        if (trail){
            Trail t = Trail.findByLocation(trail);
            if (!t) {
                t = new Trail();
                t.latitude = Double.parseDouble(params.latitude);
                t.longitude = Double.parseDouble(params.longitude);
                t.name = params.trailName;
                t.location = params.trail;
                t.save(flush : true);
            }
            gearList.trail = t;
        }

        if (!gearList.save(flush : true)){
            flash.message = "gearlist save error";
        }

        redirect(action: "create", params: [id : gearList.id])
    }

    def show() {
        Integer listId = Integer.parseInt(params.id);

        GearList list = GearList.get(listId);
            def pack = GearListGear.findAllByListAndGearType(list, GearType.PACK);
        def sleep = GearListGear.findAllByListAndGearType(list, GearType.SLEEP);
        def cooking = GearListGear.findAllByListAndGearType(list, GearType.COOKING);
        def food = GearListGear.findAllByListAndGearType(list, GearType.FOOD);
        def water = GearListGear.findAllByListAndGearType(list, GearType.WATER);
        def clothes = GearListGear.findAllByListAndGearType(list, GearType.CLOTHES);
        def electronics = GearListGear.findAllByListAndGearType(list, GearType.ELECTRONICS);
        def emergency = GearListGear.findAllByListAndGearType(list, GearType.EMERGENCY);
        def other = GearListGear.findAllByListAndGearType(list, GearType.OTHER);

        Weight weight = gearListService.getListWeight(list);

        render(view: 'list',
                model: ["list" : list,
                        "pack" : pack,
                        "sleep" : sleep,
                        "cooking" : cooking,
                        "food" : food,
                        "water" : water,
                        "clothes" : clothes,
                        "electronics" : electronics,
                        "emergency" : emergency,
                        "other" : other,
                        "totalWeight" : weight])
    }
}
