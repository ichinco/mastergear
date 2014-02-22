<%@ page import="com.mastergear.HikeType" %>
<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html class="front-page">
<head>
    <meta name="layout" content="flat">
    <r:external dir="css" file="front.css" />
</head>
<body>
    <g:link class="create-list-button-front" controller="login" action="auth" params="[targetUri: g.createLink(controller:'gearList',action:'initialize'), anonymousAllowed:true]"><div class="text">create a gear list</div></g:link>
    <section>
        <h1><div class='Day Hike hike-symbol'></div>Day Hike Lists</h1>
        <ul>
            <g:each in="${lists.get(HikeType.DAY)}" var="list">
                <li>
                    <g:link controller="gearList" action="show" id="${list.id}">
                        <div class="title">${list.title}: ${weights.get(list.id)}</div>
                    </g:link>
                    <div class="description">${list.listDescription}</div>
                    <div class="trail-info">Hiked in <span><g:message code="season.${list.season.toString().toLowerCase()}" /></span> at <span>${list.trail.name}</span></div>
                    <div class="list-info">List created on <g:formatDate date="${list.dateCreated}" format="yyyy-MM-dd" /> by ${list.user.computeDisplayableUsername()}</div>
                </li>
            </g:each>
        </ul>
    </section>
    <section>
        <h1><div class='Backpacking Hike hike-symbol'></div>Backpacking Lists</h1>
        <ul>
            <g:each in="${lists.get(HikeType.BACKPACKING)}" var="list">
                <li>
                    <g:link controller="gearList" action="show" id="${list.id}">
                        <div class="title">${list.title}: ${weights.get(list.id)}</div>
                    </g:link>
                    <div class="description">${list.listDescription}</div>
                    <div class="trail-info">Hiked in <span><g:message code="season.${list.season.toString().toLowerCase()}" /></span> at <span>${list.trail.name}</span></div>
                    <div class="list-info">List created on <g:formatDate date="${list.dateCreated}" format="yyyy-MM-dd" /> by ${list.user.computeDisplayableUsername()}</div>
                </li>
            </g:each>
        </ul>
    </section>
    <section>
        <h1><div class='Car Hike hike-symbol'></div>Car Camping Lists</h1>
        <ul>
            <g:each in="${lists.get(HikeType.CARCAMPING)}" var="list">
                <li>
                    <g:link controller="gearList" action="show" id="${list.id}">
                        <div class="title">${list.title}</div>
                    </g:link>
                    <div class="description">${list.listDescription}</div>
                    <div class="trail-info">Hiked in <span><g:message code="season.${list.season.toString().toLowerCase()}" /></span> at <span>${list.trail.name}</span></div>
                    <div class="list-info">List created on <g:formatDate date="${list.dateCreated}" format="yyyy-MM-dd" /> by ${list.user.computeDisplayableUsername()}</div>
                </li>
            </g:each>
        </ul>
    </section>
</body>
</html>