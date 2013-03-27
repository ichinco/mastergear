package com.mastergear

class GearListController {

    def index() {}

    def showList() {
        Integer listId = params.id

        GearList list = GearList.get(listId);
        int totalWeight = list.inject(0, {
            acc, val -> acc + val
        })

        render(view: "list.gsp",
                model: ["list" : list,
                        "totalWeight" : totalWeight])
    }
}
