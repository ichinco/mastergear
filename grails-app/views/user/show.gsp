<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/31/13
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <div class="bubble">
        <h1>${user.username}</h1>
        <g:if test="${profile.twitterId}"><div>twitter: ${profile.twitterId}</div></g:if>
        <div>favorite hike: <g:link controller="trail" action="show" params="[id : profile.favoriteTrail.id]">${profile.favoriteTrail.name}</g:link></div>
    </div>
    <div class="bubble">
        <h2>About</h2>
        ${profile.about}
    </div>
    <div class="bubble">
        <h2>Gear philosophy</h2>
        ${profile.gearPhilosophy}
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