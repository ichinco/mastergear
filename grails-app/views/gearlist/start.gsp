<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.mastergear.HikeType" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <h1>Day Hikes</h1>
    <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.DAY)}" var="list">

    </g:each>

</body>
</html>