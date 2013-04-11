<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 4/10/13
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.mastergear.HikeType; com.mastergear.Season" contentType="text/html;charset=UTF-8" %>
<%
    List<String> seasonValues = Season.values().collect {
        message(code:"season." + it.toString().toLowerCase());
    }

    List<String> hikeTypeValues = HikeType.values().collect {
        message(code:"hiketype." + it.toString().toLowerCase());
    }
%>

<html>
<head>
    <title>Create a new gear list</title>
    <meta name="layout" content="mastergear">
    <r:require module="initlist" />
</head>
<body>
    <div class="trail-selection">
        <g:textField name="search" class="trail-search" />
        <div class="trails">
        </div>
    </div>
    <div class="bubble">
        <g:form controller="gearList" action="create">
            <h1>Create a Gear List</h1>
            <div>season: <g:select name="season" from="${seasonValues}" keys="${Season.values()}" /></div>
            <div>hike type: <g:select name="hikeType" from="${hikeTypeValues}" keys="${HikeType.values()}" /></div>
            <div>trail: <div class="selected-trail"></div> <button class="select-trail">select</button></div>
            <div>description: <g:textArea name="listDescription" rows="10" cols="50" /></div>

            <button>create</button>
        </g:form>
    </div>
</body>
</html>