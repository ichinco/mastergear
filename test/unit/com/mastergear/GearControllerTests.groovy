package com.mastergear

import com.mastergear.rest.GearController
import grails.test.mixin.*

@TestFor(GearController)
@Mock(Gear)
class GearControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/gear/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.gearInstanceList.size() == 0
        assert model.gearInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.gearInstance != null
    }

    void testSave() {
        controller.save()

        assert model.gearInstance != null
        assert view == '/gear/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/gear/show/1'
        assert controller.flash.message != null
        assert Gear.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/gear/list'

        populateValidParams(params)
        def gear = new Gear(params)

        assert gear.save() != null

        params.id = gear.id

        def model = controller.show()

        assert model.gearInstance == gear
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/gear/list'

        populateValidParams(params)
        def gear = new Gear(params)

        assert gear.save() != null

        params.id = gear.id

        def model = controller.edit()

        assert model.gearInstance == gear
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/gear/list'

        response.reset()

        populateValidParams(params)
        def gear = new Gear(params)

        assert gear.save() != null

        // test invalid parameters in update
        params.id = gear.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/gear/edit"
        assert model.gearInstance != null

        gear.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/gear/show/$gear.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        gear.clearErrors()

        populateValidParams(params)
        params.id = gear.id
        params.version = -1
        controller.update()

        assert view == "/gear/edit"
        assert model.gearInstance != null
        assert model.gearInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/gear/list'

        response.reset()

        populateValidParams(params)
        def gear = new Gear(params)

        assert gear.save() != null
        assert Gear.count() == 1

        params.id = gear.id

        controller.delete()

        assert Gear.count() == 0
        assert Gear.get(gear.id) == null
        assert response.redirectedUrl == '/gear/list'
    }
}
