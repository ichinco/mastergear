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
        <g:link controller="GearList" action="showList" params="[id : list.id]">${list.trail.name} (${list.season})</g:link>
    </g:each>
    <h1>Backpacking</h1>
    <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.BACKPACKING)}" var="list">
        <g:link controller="GearList" action="showList" params="[id : list.id]">${list.trail.name} (${list.season})</g:link>
    </g:each>
    <h1>Thru hiking</h1>
    <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.THRU)}" var="list">
        <g:link controller="GearList" action="showList" params="[id : list.id]">${list.trail.name} (${list.season})</g:link>
    </g:each>
    <h1>Car camping</h1>
    <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.CARCAMPING)}" var="list">
        <g:link controller="GearList" action="showList" params="[id : list.id]">${list.trail.name} (${list.season})</g:link>
    </g:each>
</body>
</html>