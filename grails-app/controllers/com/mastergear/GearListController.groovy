package com.mastergear

class GearListController {

    def gearListService;

    def index() {
        render(view: 'start')
    }

    def create() {
        int id = Integer.parseInt(params.id);
        GearList list = GearList.get(id);

        render view: "create", model: [list : list, totalWeight: gearListService.getListWeight(list)]
    }

    def initialize() {
        render view: "initialize"
    }

    def initializeSave() {
        String seasonString = params.season;
        String hikeType = params.hikeType;
        String trailId = params.trail;
        String userId = params.user;

        GearList gearList = new GearList();
        gearList.listDescription = params.listDescription;

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
                        "totalWeight" : new Weight(totalWeight)])
    }
}
