<%@ page import="com.mastergear.GearList" %>



<div class="fieldcontain ${hasErrors(bean: gearListInstance, field: 'hikeType', 'error')} required">
	<label for="hikeType">
		<g:message code="gearList.hikeType.label" default="Hike Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="hikeType" from="${com.mastergear.HikeType?.values()}" keys="${com.mastergear.HikeType.values()*.name()}" required="" value="${gearListInstance?.hikeType?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gearListInstance, field: 'listDescription', 'error')} ">
	<label for="listDescription">
		<g:message code="gearList.listDescription.label" default="List Description" />
		
	</label>
	<g:textField name="listDescription" value="${gearListInstance?.listDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gearListInstance, field: 'season', 'error')} required">
	<label for="season">
		<g:message code="gearList.season.label" default="Season" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="season" from="${com.mastergear.Season?.values()}" keys="${com.mastergear.Season.values()*.name()}" required="" value="${gearListInstance?.season?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: gearListInstance, field: 'trail', 'error')} required">
	<label for="trail">
		<g:message code="gearList.trail.label" default="Trail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="trail" name="trail.id" from="${com.mastergear.Trail.list()}" optionKey="id" required="" value="${gearListInstance?.trail?.id}" class="many-to-one"/>
</div>

