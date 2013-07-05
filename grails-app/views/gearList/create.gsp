<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/31/13
  Time: 3:26 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mastergear.ProviderType; com.mastergear.GearGender; com.mastergear.HikeType; com.mastergear.Season" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Create a new gear list</title>
    <meta name="layout" content="mastergear">
    <r:require module="createlist" />
</head>
<body>
    <div id="review-gear" class="pop-background">
        <div class="pop">
            <div class="content">
                <div class="close-pop" style="background-image: url(${resource(dir:"images", file:"brightmix_delete.png")})"></div>
                <h1></h1>
                <div>
                    Tell us why you can't leave it home. Do you make any modifications to it?
                    Are there aspects of this particular brand that you wish were different?
                </div>
                <g:textArea name="gear-review" class="gear-review" rows="4" cols="75" />
                <button class="create-review">create review</button>
            </div>
        </div>
    </div>
    <g:render template="gearSummary" model="[list:list, totalWeight:totalWeight]" />

    <g:render template="createGearType" model="[gearType:'pack']" />
    <g:render template="createGearType" model="[gearType:'sleep']" />
    <g:render template="createGearType" model="[gearType:'cooking']" />
    <g:render template="createGearType" model="[gearType:'food']" />
    <g:render template="createGearType" model="[gearType:'water']" />
    <g:render template="createGearType" model="[gearType:'clothes']" />
    <g:render template="createGearType" model="[gearType:'electronics']" />
    <g:render template="createGearType" model="[gearType:'emergency']" />
    <g:render template="createGearType" model="[gearType:'other']" />

    <script type="text/javascript">
    var Mastergear = Mastergear || {};
    Mastergear.listId = ${list.id};
    </script>
</body>
</html>