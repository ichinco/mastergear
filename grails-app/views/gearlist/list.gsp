<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:34 PM
--%>

<%@ page import="com.mastergear.GearType" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <h1>${list.hikeType} on ${list.trail.name} in ${list.season}</h1>
    ${list.trail.location}

    gear weight: ${totalWeight}oz
    <div>${list.listDescription}</div>

    <h2>Pack</h2>
    <g:each in="${list.getGearByType(GearType.PACK)}" var="gear">
        <g:render template="gear" model="[gear:gear]"/>
    </g:each>

    <h2>Sleeping</h2>
    <g:each in="${list.getGearByType(GearType.SLEEP)}" var="gear">
        <g:render template="gear" model="[gear:gear]"/>
    </g:each>

    <h2>Cooking</h2>
    <g:each in="${list.getGearByType(GearType.COOKING)}" var="gear">
        <g:render template="gear" model="[gear:gear]"/>
    </g:each>

    <h2>Food</h2>
    <g:each in="${list.getGearByType(GearType.FOOD)}" var="gear">
        <g:render template="gear" model="[gear:gear]"/>
    </g:each>

    <h2>Clothes</h2>
    <g:each in="${list.getGearByType(GearType.CLOTHES)}" var="gear">
        <g:render template="gear" model="[gear:gear]"/>
    </g:each>

    <h2>Electronics</h2>
    <g:each in="${list.getGearByType(GearType.ELECTRONICS)}" var="gear">
        <g:render template="gear" model="[gear:gear]"/>
    </g:each>

    <h2>Emergency</h2>
    <g:each in="${list.getGearByType(GearType.EMERGENCY)}" var="gear">
        <g:render template="gear" model="[gear:gear]"/>
    </g:each>

</body>
</html>