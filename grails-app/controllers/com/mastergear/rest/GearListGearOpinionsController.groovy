package com.mastergear.rest

import com.mastergear.GearListGear
import com.mastergear.GearListGearOpinion

class GearListGearOpinionsController {

    def show() {
        GearListGear gear = GearListGear.get(params.gearListGearId);
        def opinions = GearListGearOpinion.findAllByGearListGear(gear);

        render (contentType:"text/json") {
            opinions : opinions
        }
    }
}
