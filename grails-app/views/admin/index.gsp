<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 7/29/13
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Admin</title>
</head>
<body>
    <nav>
        <div><g:link controller="gearListAdmin" action="index">Edit Gear Lists</g:link></div>
        <div><g:link controller="trailAdmin" action="index">Edit Trails</g:link></div>
        <div><g:link controller="gearUserAdmin" action="index">Edit Users</g:link></div>
        <div><g:link controller="gearAdmin" action="index">Edit Gear</g:link></div>
        <div><g:link controller="providerAdmin" action="index">Edit Providers</g:link></div>
    </nav>


</body>
</html>