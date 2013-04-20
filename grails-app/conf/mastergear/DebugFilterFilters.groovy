package mastergear

class DebugFilterFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                request
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
