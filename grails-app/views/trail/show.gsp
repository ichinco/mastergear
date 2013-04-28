<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/31/13
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <div class="bubble">
        <h1>${trail.name}</h1>
        <div>${trail.location}</div>
        <div>max elevation: ${trail.maxElevation}ft</div>

        <div class="map">
            <img src="http://maps.googleapis.com/maps/api/staticmap?zoom=3&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:%7C${trail.latitude},${trail.longitude}&sensor=false" />
        </div>
    </div>

    <div class="bubble">
        <h2>Gear Lists</h2>
        <div class="lists">
            <g:each in="${lists}" var="list">
                <g:link controller="GearList" action="showList" params="[id : list.id]"><g:render template="/gearList/title" model="[list: list]" /></g:link>
            </g:each>
        </div>
    </div>
    <div class="bubble">
        <h2>Favorite Gear</h2>
        <g:each in="${gear}" var="g">
            <g:render template="/gearList/gear" model="[gear:g, quantity:1, notes: '']"/>
        </g:each>
    </div>
</body>
</html>