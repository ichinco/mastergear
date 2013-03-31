package com.mastergear

class TrailController {

    def index() { }

    def show(){
        int trailId = Integer.parseInt(params.trailId)
        Trail trail = Trail.get(trailId);

        render view: "show", model:[
                trail : trail
        ]
    }
}
