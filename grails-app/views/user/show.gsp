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
        <div>favorite hike: ${profile.favoriteTrail.name}</div>
    </div>
    <div class="bubble">
        <h2>About</h2>
        ${profile.about}
    </div>
    <div class="bubble">
        <h2>Gear philosophy</h2>
        ${profile.gearPhilosophy}
    </div>
</body>
</html>