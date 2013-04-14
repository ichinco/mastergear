package com.mastergear

class GearListService {

    public Weight getListWeight(GearList list){
        def gear = GearListGear.findAllByList(list);
        double totalWeight = gear.inject(0, {
            acc, val -> acc + val.gear.weight
        })

        return new Weight(totalWeight);
    }
}
