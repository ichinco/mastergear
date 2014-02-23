package com.mastergear

import com.mastergear.rest.GearListGearOpinionController
import grails.test.mixin.*

@TestFor(GearListGearOpinionController)
@Mock(GearListGearOpinion)
class GearListGearOpinionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/gearListGearOpinion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.gearListGearOpinionInstanceList.size() == 0
        assert model.gearListGearOpinionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.gearListGearOpinionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.gearListGearOpinionInstance != null
        assert view == '/gearListGearOpinion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/gearListGearOpinion/show/1'
        assert controller.flash.message != null
        assert GearListGearOpinion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/gearListGearOpinion/list'

        populateValidParams(params)
        def gearListGearOpinion = new GearListGearOpinion(params)

        assert gearListGearOpinion.save() != null

        params.id = gearListGearOpinion.id

        def model = controller.show()

        assert model.gearListGearOpinionInstance == gearListGearOpinion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/gearListGearOpinion/list'

        populateValidParams(params)
        def gearListGearOpinion = new GearListGearOpinion(params)

        assert gearListGearOpinion.save() != null

        params.id = gearListGearOpinion.id

        def model = controller.edit()

        assert model.gearListGearOpinionInstance == gearListGearOpinion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/gearListGearOpinion/list'

        response.reset()

        populateValidParams(params)
        def gearListGearOpinion = new GearListGearOpinion(params)

        assert gearListGearOpinion.save() != null

        // test invalid parameters in update
        params.id = gearListGearOpinion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/gearListGearOpinion/edit"
        assert model.gearListGearOpinionInstance != null

        gearListGearOpinion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/gearListGearOpinion/show/$gearListGearOpinion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        gearListGearOpinion.clearErrors()

        populateValidParams(params)
        params.id = gearListGearOpinion.id
        params.version = -1
        controller.update()

        assert view == "/gearListGearOpinion/edit"
        assert model.gearListGearOpinionInstance != null
        assert model.gearListGearOpinionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/gearListGearOpinion/list'

        response.reset()

        populateValidParams(params)
        def gearListGearOpinion = new GearListGearOpinion(params)

        assert gearListGearOpinion.save() != null
        assert GearListGearOpinion.count() == 1

        params.id = gearListGearOpinion.id

        controller.delete()

        assert GearListGearOpinion.count() == 0
        assert GearListGearOpinion.get(gearListGearOpinion.id) == null
        assert response.redirectedUrl == '/gearListGearOpinion/list'
    }
}
