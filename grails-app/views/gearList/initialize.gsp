<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 4/10/13
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
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
    <meta name="layout" content="flat">
    <r:require module="initlist" />
</head>
<body>
    <%--
    <div class="trail-selection pop-background">
        <div class="pop">
            <div class="content">
                <div class="close-pop" style="background-image: url(${resource(dir:"images", file:"brightmix_delete.png")})"></div>
                %{--<g:textField name="search" class="trail-search" />--}%
                <h1>Select Trail</h1>
                <div class="get-suggestions">
                    <g:form class="search-form" >
                        <g:textField name="category" class="category-desc" />
                        <g:submitButton name="search" class="category" />
                        <img class="loading" src="${resource(dir:'images', file:'spinner.gif')}" />
                    </g:form>
                </div>
                <div class="trails"></div>
            </div>
        </div>
    </div>
    <div class="bubble">
        <g:form controller="gearList" action="initializeSave" class="object-form">
            <h1>Create a Gear List</h1>
            <g:hiddenField name="user" value="-1" />
            <label for="title">title</label>
            <g:textField name="title" size="100" /><br />
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
    --%>
    <main id="create-gearlist">
        <h1>create a gearlist</h1>
        <div id="create-gearlist-form-container">
            <g:form controller="gearList" action="initializeSave" class="gearlist-create-form">
                <!-- important: this is needed to process user data -->
                <g:hiddenField name="user" value='-1'><</g:hiddenField>

                <!-- title -->
                <fieldset class="title">
                    <label for="title">title</label>
                    <g:textField name="title" size="100" />
                </fieldset>

                <!-- season -->
                <fieldset class="season">
                    <label for="season">season</label>
                    <g:select name="season"
                              from="${seasonValues}"
                              keys="${Season.values()}" />
                </fieldset>

                <!-- hike type -->
                <fieldset class="hike type">
                    <label for="hikeType">hike type</label>
                    <g:select name="hikeType"
                              from="${hikeTypeValues}"
                              keys="${HikeType.values()}" /><br />
                </fieldset>

                <!-- trail -->
                <fieldset class="trail">
                    <label for="trail">trail</label>
                    <g:textField name="trail" size="100" />
                </fieldset>

                <!-- description -->
                <fieldset class="description">
                    <label for="listDescription">description</label>
                    <g:textArea name="listDescription" rows="10" cols="50" /><br />
                </fieldset>

                <!-- submit button -->
                <g:submitButton class="create-gearlist-submit" name="add items"></g:submitButton>
            </g:form>
        </div>
    </main>
</body>
</html>