<%@ page import="com.mastergear.GearList" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'gearList.label', default: 'GearList')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-gearList" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-gearList" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list gearList">

        <g:if test="${gearListInstance?.dateCreated}">
            <li class="fieldcontain">
                <span id="dateCreated-label" class="property-label"><g:message code="gearList.dateCreated.label"
                                                                               default="Date Created"/></span>

                <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                        date="${gearListInstance?.dateCreated}"/></span>

            </li>
        </g:if>

        <g:if test="${gearListInstance?.hikeType}">
            <li class="fieldcontain">
                <span id="hikeType-label" class="property-label"><g:message code="gearList.hikeType.label"
                                                                            default="Hike Type"/></span>

                <span class="property-value" aria-labelledby="hikeType-label"><g:fieldValue bean="${gearListInstance}"
                                                                                            field="hikeType"/></span>

            </li>
        </g:if>

        <g:if test="${gearListInstance?.lastUpdated}">
            <li class="fieldcontain">
                <span id="lastUpdated-label" class="property-label"><g:message code="gearList.lastUpdated.label"
                                                                               default="Last Updated"/></span>

                <span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate
                        date="${gearListInstance?.lastUpdated}"/></span>

            </li>
        </g:if>

        <g:if test="${gearListInstance?.listDescription}">
            <li class="fieldcontain">
                <span id="listDescription-label" class="property-label"><g:message code="gearList.listDescription.label"
                                                                                   default="List Description"/></span>

                <span class="property-value" aria-labelledby="listDescription-label"><g:fieldValue
                        bean="${gearListInstance}" field="listDescription"/></span>

            </li>
        </g:if>

        <g:if test="${gearListInstance?.season}">
            <li class="fieldcontain">
                <span id="season-label" class="property-label"><g:message code="gearList.season.label"
                                                                          default="Season"/></span>

                <span class="property-value" aria-labelledby="season-label"><g:fieldValue bean="${gearListInstance}"
                                                                                          field="season"/></span>

            </li>
        </g:if>

        <g:if test="${gearListInstance?.trail}">
            <li class="fieldcontain">
                <span id="trail-label" class="property-label"><g:message code="gearList.trail.label"
                                                                         default="Trail"/></span>

                <span class="property-value" aria-labelledby="trail-label"><g:link controller="trail" action="show"
                                                                                   id="${gearListInstance?.trail?.id}">${gearListInstance?.trail?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${gearListInstance?.id}"/>
            <g:link class="edit" action="edit" id="${gearListInstance?.id}"><g:message code="default.button.edit.label"
                                                                                       default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
