package com.mastergear

class GearListController {

    def index() {
        render(view: 'start')
    }

    def create() {
        render view: "create"
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
