package com.mastergear

import grails.converters.JSON

class GearUser {

	transient springSecurityService

	String username
	String password
    boolean anonymous = false;
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
    Date dateCreated
    Date lastUpdated

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}

    public static void register() {
        JSON.registerObjectMarshaller(GearUser) {
            return [id: it.id,
                    username:it.anonymous ? "anonymous" : it.username,
                    dateCreated: it.dateCreated.getTime(),
                    lastUpdated: it.lastUpdated.getTime()]
        }
    }
}
