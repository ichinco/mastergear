<%@ page import="java.text.NumberFormat" %>
<%
    NumberFormat noDecimals = NumberFormat.getInstance();
    noDecimals.setMaximumFractionDigits(0);

    NumberFormat twoDecimals = NumberFormat.getInstance();
    twoDecimals.setMaximumFractionDigits(2);
%>

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