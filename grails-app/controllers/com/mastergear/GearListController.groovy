package com.mastergear

class GearListController {

    def index() {
        render(view: 'start')
    }

    def create() {
        render view: "create"
    }

    def initialize() {
        render view: "initialize"
    }

    def initializeSave() {
        String seasonString = params.season;
        String hikeType = params.hikeType;
        String trailId = params.trail;
        String userId = params.userId;

        GearList gearList = new GearList();
        gearList.listDescription = params.description;

        if (userId){
            GearUser user = GearUser.get(Integer.parseInt(userId)); // get the actual user once there are users
            gearList.user = user;
        }
        if (seasonString) {
            gearList.season = Season.valueOf(seasonString);
        }

        if (hikeType) {
            gearList.hikeType = HikeType.valueOf(hikeType);
        }

        if (trailId){
            int id = Integer.parseInt(trailId);
            Trail trail = Trail.get(id);
            gearList.trail = trail;
        }
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

        def gear = GearListGear.findAllByList(list);
        double totalWeight = gear.inject(0, {
            acc, val -> acc + val.gear.weight
        })

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
                        "totalWeight" : new Weight(totalWeight)])
    }
}
