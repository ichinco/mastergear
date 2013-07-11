import com.mastergear.GearList
import com.mastergear.GearUser
import com.mastergear.Trail

class BootStrap {

    def grailsApplication;

    def init = { servletContext ->
        Trail.register();
        GearUser.register();
        GearList.register(grailsApplication);
    }
    def destroy = {
    }
}
