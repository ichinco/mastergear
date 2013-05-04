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
    <div class="bubble">
        <h1><g:message code="hiketype.day" /></h1>
        <div class="lists">
            <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.DAY)}" var="list">
                <g:link controller="GearList" action="showList" params="[id : list.id]"><g:render template="title" model="[list: list]" /></g:link>
            </g:each>
        </div>
    </div>

    <div class="bubble">
        <h1><g:message code="hiketype.backpacking" /></h1>
        <div class="lists">
            <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.BACKPACKING)}" var="list">
                <g:link controller="GearList" action="showList" params="[id : list.id]"><g:render template="title" model="[list: list]" /></g:link>
            </g:each>
        </div>
    </div>

    <div class="bubble">
        <h1><g:message code="hiketype.carcamping" /></h1>
        <div class="lists">
            <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.CARCAMPING)}" var="list">
                <g:link controller="GearList" action="showList" params="[id : list.id]"><g:render template="title" model="[list: list]" /></g:link>
            </g:each>
        </div>
    </div>
</body>
</html>