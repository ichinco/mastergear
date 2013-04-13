class UrlMappings {

	static mappings = {
        "/gear/$id?"(parseRequest:true){
              controller = "gear"
              action = [GET: "show", PUT: "save", DELETE: "delete", POST: "save"]
        }

        "/trail/$id?"(parseRequest:true){
              controller = "trail"
              action = [GET: "show", PUT: "save", DELETE: "delete", POST: "save"]
        }

        "/gear/list"(parseRequest:true){
              controller = "gear"
              action = "list"
        }

        "/trail/list"(parseRequest:true){
              controller = "trail"
              action = "list"
        }

        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

		"/"( controller:"gearList",  action: "index")
		"500"(view:'/error')
	}
}
