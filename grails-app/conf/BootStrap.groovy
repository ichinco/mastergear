import com.mastergear.*

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
