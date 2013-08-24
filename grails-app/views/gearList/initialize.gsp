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
    <main id="create-gearlist">
        <h1>create a gearlist</h1>
        <div id="create-gearlist-form-container">
            <g:form controller="gearList" action="initializeSave" class="gearlist-create-form">
                <!-- important: this is needed to process user data -->
                <g:hiddenField name="user" value='-1'><</g:hiddenField>

                <!-- title -->
                <fieldset class="title ${hasErrors(bean:list,field:'title','errors')}">
                    <label for="title">title</label>
                    <g:renderErrors bean="${list}" field="title" />
                    <g:textField name="title" size="100" value="${fieldValue(bean:list,field:'title')}" />
                </fieldset>

                <!-- season -->
                <fieldset class="season ${hasErrors(bean:list,field:'season','errors')}">
                    <label for="season">season</label>
                    <g:renderErrors bean="${list}" field="season" />
                    <g:select name="season"
                              from="${seasonValues}"
                              keys="${Season.values()}"
                              value="${fieldValue(bean:list,field:'season')}"/>
                </fieldset>

                <!-- hike type -->
                <fieldset class="hike type ${hasErrors(bean:list,field:'hikeType','errors')}">
                    <label for="hikeType">hike type</label>
                    <g:renderErrors bean="${list}" field="hikeType" />
                    <g:select name="hikeType"
                              from="${hikeTypeValues}"
                              keys="${HikeType.values()}"
                              value="${fieldValue(bean:list,field:'hikeType')}"  />
                    <br />
                </fieldset>

                <!-- trail -->
                <fieldset class="trail ${hasErrors(bean:list,field:'trail','errors')}">
                    <label for="trail">trail</label>
                    <g:renderErrors bean="${list}" field="trail" />
                    <div class="selected-trail"></div> <button class="select-trail">select</button>
                </fieldset>

                <!-- description -->
                <fieldset class="description ${hasErrors(bean:list,field:'listDescription','errors')}">
                    <label for="listDescription">description</label>
                    <g:renderErrors bean="${list}" field="listDescription" />
                    <g:textArea name="listDescription" rows="10" cols="50" value="${fieldValue(bean:list,field:'listDescription')}" /><br />
                </fieldset>

                <!-- submit button -->
                <g:submitButton class="create-gearlist-submit" name="add-items" value="build list"></g:submitButton>
            </g:form>
            <div class="trail-selection pop-background">
                <div class="pop">
                    <div class="content">
                        <div class="close-pop" style="background-image: url(${resource(dir:"images", file:"brightmix_delete.png")})"></div>
                        %{--<g:textField name="search" class="trail-search" />--}%
                        <h1>Select Trail</h1>
                        <div class="close-button"></div>
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
            <div class="pick-trail">

            </div>
        </div>
    </main>

<script type="text/template" id="trail_form_template">
    <input type="hidden" name="trail" value="{{location}}"/>
    <input type="hidden" name="latitude" value="{{latitude}}"/>
    <input type="hidden" name="longitude" value="{{longitude}}"/>
    <input type="hidden" name="trailName" value="{{name}}"/>
    <div class="trail-object" data-trail-id={{id}}>{{location}}</div>
</script>
<script type="text/template" id="trail_template">
    <div>
        <div class="trail-object" data-trail-id={{id}}>{{location}}</div>
    </div>
</script>
</body>
</html>