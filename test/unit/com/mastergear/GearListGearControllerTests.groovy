package com.mastergear



import org.junit.*
import grails.test.mixin.*

@TestFor(GearListGearController)
@Mock(GearListGear)
class GearListGearControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/gearListGear/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.gearListGearInstanceList.size() == 0
        assert model.gearListGearInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.gearListGearInstance != null
    }

    void testSave() {
        controller.save()

        assert model.gearListGearInstance != null
        assert view == '/gearListGear/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/gearListGear/show/1'
        assert controller.flash.message != null
        assert GearListGear.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/gearListGear/list'

        populateValidParams(params)
        def gearListGear = new GearListGear(params)

        assert gearListGear.save() != null

        params.id = gearListGear.id

        def model = controller.show()

        assert model.gearListGearInstance == gearListGear
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/gearListGear/list'

        populateValidParams(params)
        def gearListGear = new GearListGear(params)

        assert gearListGear.save() != null

        params.id = gearListGear.id

        def model = controller.edit()

        assert model.gearListGearInstance == gearListGear
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/gearListGear/list'

        response.reset()

        populateValidParams(params)
        def gearListGear = new GearListGear(params)

        assert gearListGear.save() != null

        // test invalid parameters in update
        params.id = gearListGear.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/gearListGear/edit"
        assert model.gearListGearInstance != null

        gearListGear.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/gearListGear/show/$gearListGear.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        gearListGear.clearErrors()

        populateValidParams(params)
        params.id = gearListGear.id
        params.version = -1
        controller.update()

        assert view == "/gearListGear/edit"
        assert model.gearListGearInstance != null
        assert model.gearListGearInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/gearListGear/list'

        response.reset()

        populateValidParams(params)
        def gearListGear = new GearListGear(params)

        assert gearListGear.save() != null
        assert GearListGear.count() == 1

        params.id = gearListGear.id

        controller.delete()

        assert GearListGear.count() == 0
        assert GearListGear.get(gearListGear.id) == null
        assert response.redirectedUrl == '/gearListGear/list'
    }
}
