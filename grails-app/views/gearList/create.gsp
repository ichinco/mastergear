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
    <div id="review-gear">
        <g:textArea name="gear-review" class="gear-review" rows="4" cols="75" />
        <button class="create-review">create review</button>
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