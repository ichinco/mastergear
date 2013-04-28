<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 4/28/13
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <div class="bubble">
        <h1>Trails</h1>
        <div class="lists">
            <g:each in="${trails}" var="trail">
                <g:link controller="Trail" action="show" params="[id : trail.id]">${trail.name}</g:link>
            </g:each>
        </div>
    </div>
</body>
</html>