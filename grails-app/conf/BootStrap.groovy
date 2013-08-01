import com.mastergear.Gear
import com.mastergear.GearList
import com.mastergear.GearListGear
import com.mastergear.GearUser
import com.mastergear.Provider
import com.mastergear.Role
import com.mastergear.Trail
import com.mastergear.UserRole

class BootStrap {

    def grailsApplication;

    def init = { servletContext ->
        Trail.register();
        GearUser.register();
        GearList.register(grailsApplication);
        Provider.register(grailsApplication);
        Gear.register(grailsApplication);
        GearListGear.register(grailsApplication);
    }
    def destroy = {
    }
}
