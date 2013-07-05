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
    <div class="trail-selection pop-background">
        <div class="pop">
            <div class="content">
                <div class="close-pop" style="background-image: url(${resource(dir:"images", file:"brightmix_delete.png")})"></div>
                %{--<g:textField name="search" class="trail-search" />--}%
                <h1>Select Trail</h1>
                <div class="trails"></div>
                <button class="no-trail">None of these</button>
                <div class="create-trail">
                    <div class="object-form">
                        <label for="trail-name">name</label>
                        <g:textField name="trail-name" class="trail-name" /><br />
                        <label for="location">city, state</label>
                        <g:textField name="location" class="location" /><br />
                        <label for="latitude">latitude</label>
                        <g:textField name="latitude" class="latitude" /> N<br />
                        <label for="longitude">longitude</label>
                        <g:textField name="longitude" class="longitude" /> E<br />
                        <label for="maxElevation">max elevation</label>
                        <g:textField name="maxElevation" class="maxElevation" /> ft<br />
                        <label for="create"></label>
                        <button class="create">create trail</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="bubble">
        <g:form controller="gearList" action="initializeSave" class="object-form">
            <h1>Create a Gear List</h1>
            <g:hiddenField name="user" value="1" />
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