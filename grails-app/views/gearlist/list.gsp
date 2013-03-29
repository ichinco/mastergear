
<%@ page import="com.mastergear.GearList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'gearList.label', default: 'GearList')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-gearList" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-gearList" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'gearList.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="hikeType" title="${message(code: 'gearList.hikeType.label', default: 'Hike Type')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'gearList.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="listDescription" title="${message(code: 'gearList.listDescription.label', default: 'List Description')}" />
					
						<g:sortableColumn property="season" title="${message(code: 'gearList.season.label', default: 'Season')}" />
					
						<th><g:message code="gearList.trail.label" default="Trail" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${gearListInstanceList}" status="i" var="gearListInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${gearListInstance.id}">${fieldValue(bean: gearListInstance, field: "dateCreated")}</g:link></td>
					
						<td>${fieldValue(bean: gearListInstance, field: "hikeType")}</td>
					
						<td><g:formatDate date="${gearListInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: gearListInstance, field: "listDescription")}</td>
					
						<td>${fieldValue(bean: gearListInstance, field: "season")}</td>
					
						<td>${fieldValue(bean: gearListInstance, field: "trail")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${gearListInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
