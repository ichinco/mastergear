package com.mastergear

import com.mastergear.rest.TrailController
import grails.test.mixin.*

@TestFor(TrailController)
@Mock(Trail)
class TrailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/trail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.trailInstanceList.size() == 0
        assert model.trailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.trailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.trailInstance != null
        assert view == '/trail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/trail/show/1'
        assert controller.flash.message != null
        assert Trail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/trail/list'

        populateValidParams(params)
        def trail = new Trail(params)

        assert trail.save() != null

        params.id = trail.id

        def model = controller.show()

        assert model.trailInstance == trail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/trail/list'

        populateValidParams(params)
        def trail = new Trail(params)

        assert trail.save() != null

        params.id = trail.id

        def model = controller.edit()

        assert model.trailInstance == trail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/trail/list'

        response.reset()

        populateValidParams(params)
        def trail = new Trail(params)

        assert trail.save() != null

        // test invalid parameters in update
        params.id = trail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/trail/edit"
        assert model.trailInstance != null

        trail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/trail/show/$trail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        trail.clearErrors()

        populateValidParams(params)
        params.id = trail.id
        params.version = -1
        controller.update()

        assert view == "/trail/edit"
        assert model.trailInstance != null
        assert model.trailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/trail/list'

        response.reset()

        populateValidParams(params)
        def trail = new Trail(params)

        assert trail.save() != null
        assert Trail.count() == 1

        params.id = trail.id

        controller.delete()

        assert Trail.count() == 0
        assert Trail.get(trail.id) == null
        assert response.redirectedUrl == '/trail/list'
    }
}
