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
        <div class="trails"></div>
        <div class="no-trail">None of these</div>
        <div class="create-trail object-form">
            <label for="trail-name">name</label>
            <g:textField name="trail-name" class="trail-name" />
            <label for="location">city, state</label>
            <g:textField name="location" class="location" />
            <label for="latitude">latitude</label>
            <g:textField name="latitude" class="latitude" />N
            <label for="longitude">longitude</label>
            <g:textField name="longitude" class="longitude" />W
            <label for="maxElevation">max elevation</label>
            <g:textField name="maxElevation" class="maxElevation" />ft
            <label for="create"></label>
            <button class="create">create trail</button>
        </div>
    </div>
    <div class="bubble">
        <g:form controller="gearList" action="initializeSave" class="object-form">
            <h1>Create a Gear List</h1>
            <label for="user">user</label>
            <g:textField name="user" /><br />
            <label for="season">season</label>
            <g:select name="season" from="${seasonValues}" keys="${Season.values()}" /><br />
            <label for="hikeType">hike type</label>
            <g:select name="hikeType" from="${hikeTypeValues}" keys="${HikeType.values()}" /><br />
            <label for="trail">trail</label>
            <div class="selected-trail"></div> <button class="select-trail">select</button><br />
            <label for="listDescription">description</label>
            <g:textArea name="listDescription" rows="10" cols="50" /><br />
            <label for="create"></label>
            <button>create</button>
        </g:form>
    </div>
</body>
</html>