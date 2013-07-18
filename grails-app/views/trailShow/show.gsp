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
    <meta name="layout" content="flat">
    <title>${trail.name} - feathergear</title>
</head>
<body>
    <div class="bubble">
        <h1>${trail.name}</h1>
        <div class="map">
            <img src="http://maps.googleapis.com/maps/api/staticmap?zoom=3&size=100x100&maptype=roadmap&markers=color:blue%7Clabel:%7C${trail.latitude},${trail.longitude}&sensor=false" />
        </div>
        <div class="list-info">
            <div>${trail.location}</div>
            <div>max elevation: ${trail.maxElevation}ft</div>
        </div>
    </div>

    <div class="bubble">
        <h2>Gear Lists</h2>
        <div class="lists">
            <g:each in="${lists}" var="list">
                <g:render template="/gearList/gearList" model="[list : list]" />
            </g:each>
        </div>
    </div>
    <div class="bubble">
        <h2>Popular Gear</h2>
        <g:each in="${gear}" var="g">
            <g:render template="/gearList/gear" model="[gear:g, quantity:1, notes: '']"/>
        </g:each>
    </div>
</body>
</html>