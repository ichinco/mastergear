package com.mastergear



import org.junit.*
import grails.test.mixin.*

@TestFor(ProspectiveUserController)
@Mock(ProspectiveUser)
class ProspectiveUserControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/prospectiveUser/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.prospectiveUserInstanceList.size() == 0
        assert model.prospectiveUserInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.prospectiveUserInstance != null
    }

    void testSave() {
        controller.save()

        assert model.prospectiveUserInstance != null
        assert view == '/prospectiveUser/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/prospectiveUser/show/1'
        assert controller.flash.message != null
        assert ProspectiveUser.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/prospectiveUser/list'

        populateValidParams(params)
        def prospectiveUser = new ProspectiveUser(params)

        assert prospectiveUser.save() != null

        params.id = prospectiveUser.id

        def model = controller.show()

        assert model.prospectiveUserInstance == prospectiveUser
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/prospectiveUser/list'

        populateValidParams(params)
        def prospectiveUser = new ProspectiveUser(params)

        assert prospectiveUser.save() != null

        params.id = prospectiveUser.id

        def model = controller.edit()

        assert model.prospectiveUserInstance == prospectiveUser
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/prospectiveUser/list'

        response.reset()

        populateValidParams(params)
        def prospectiveUser = new ProspectiveUser(params)

        assert prospectiveUser.save() != null

        // test invalid parameters in update
        params.id = prospectiveUser.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/prospectiveUser/edit"
        assert model.prospectiveUserInstance != null

        prospectiveUser.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/prospectiveUser/show/$prospectiveUser.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        prospectiveUser.clearErrors()

        populateValidParams(params)
        params.id = prospectiveUser.id
        params.version = -1
        controller.update()

        assert view == "/prospectiveUser/edit"
        assert model.prospectiveUserInstance != null
        assert model.prospectiveUserInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/prospectiveUser/list'

        response.reset()

        populateValidParams(params)
        def prospectiveUser = new ProspectiveUser(params)

        assert prospectiveUser.save() != null
        assert ProspectiveUser.count() == 1

        params.id = prospectiveUser.id

        controller.delete()

        assert ProspectiveUser.count() == 0
        assert ProspectiveUser.get(prospectiveUser.id) == null
        assert response.redirectedUrl == '/prospectiveUser/list'
    }
}
