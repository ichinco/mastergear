<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 4/28/13
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <div class="bubble">
        <h1>Users</h1>
        <div class="lists">
            <g:each in="${users}" var="user">
                <g:link controller="User" action="show" params="[userId : user.id]">${user.username}</g:link>
            </g:each>
        </div>
    </div>
</body>
</html>

</body>
</html>