class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"( controller:"gearList",  action: "index")
		"500"(view:'/error')
	}
}
