<%--
  User: denise
  Date: 3/26/13
  Time: 9:34 PM
--%>

<%@ page import="java.text.NumberFormat; com.mastergear.GearType" contentType="text/html;charset=UTF-8" %>
<%
    NumberFormat noDecimals = NumberFormat.getInstance();
    noDecimals.setMaximumFractionDigits(0);

    NumberFormat twoDecimals = NumberFormat.getInstance();
    twoDecimals.setMaximumFractionDigits(2);
%>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <div class="bubble">
        <h1><g:render template="title" model="[list: list]" /> </h1>
        <div class="map">
            <g:link controller="trail" action="show" params="[id : list.trail.id]">
                <img src="http://maps.googleapis.com/maps/api/staticmap?zoom=2&size=100x100&maptype=roadmap&markers=color:blue%7Clabel:%7C${list.trail.latitude},${list.trail.longitude}&sensor=false" />
            </g:link>
        </div>
        <div class="list-info">
            <div class="trail-location">${list.trail.location}</div>
            <div class="user">created by: <g:link controller="user" action="show" params="[userId: list.user.id]">${list.user.username}</g:link></div>
            <div class="list-weight">gear weight: ${noDecimals.format(totalWeight.getPounds())}lbs ${twoDecimals.format(totalWeight.getOunces())}oz</div>
        </div>
        <div class="list-description">${list.listDescription}</div>
    </div>


    <g:render template="gearType" model="[gear : pack, code: 'geartype.pack']"/>
    <g:render template="gearType" model="[gear : sleep, code: 'geartype.sleep']"/>
    <g:render template="gearType" model="[gear : cooking, code: 'geartype.cooking']"/>
    <g:render template="gearType" model="[gear : food, code: 'geartype.food']"/>
    <g:render template="gearType" model="[gear : water, code: 'geartype.water']"/>
    <g:render template="gearType" model="[gear : clothes, code: 'geartype.clothes']"/>
    <g:render template="gearType" model="[gear : electronics, code: 'geartype.electronics']"/>
    <g:render template="gearType" model="[gear : emergency, code: 'geartype.emergency']"/>
    <g:render template="gearType" model="[gear : other, code: 'geartype.other']"/>

</body>
</html>