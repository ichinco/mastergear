class UrlMappings {

	static mappings = {
        "/gear/$id?"(parseRequest:true){
              controller = "gear"
              action = [GET: "show", PUT: "save", DELETE: "delete", POST: "save"]
        }

        "/gearlist/"(parseRequest:true){
              controller = "gearLists"
              action = [GET: "show"]
        }

        "/trail/$id"(parseRequest:true){
              controller = "trail"
              action = [GET: "show", PUT: "save", DELETE: "delete", POST: "save"]
        }

        "/trail/"(parseRequest:true){
              controller = "trails"
              action = [GET: "show", POST: "save"]
        }

        "/gearListGear/$id?"(parseRequest:true){
              controller = "gearListGear"
              action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/gearListGearOpinion/$id?"(parseRequest:true){
              controller = "gearListGearOpinion"
              action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/gear/list"(parseRequest:true){
              controller = "gear"
              action = "list"
        }

        "/gear/search"(parseRequest:true){
              controller = "gear"
              action = "search"
        }

        "/trail/list"(parseRequest:true){
              controller = "trail"
              action = "list"
        }

        "/gearListGear/list"(parseRequest:true){
              controller = "gearListGear"
              action = "list"
        }

        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/$controller/$action"{

        }

		"/"( controller:"gearList",  action: "index")
		"500"(view:'/error')
	}
}
