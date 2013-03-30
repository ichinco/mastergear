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
    <div class="bubble">
        <h1>${list.hikeType} on ${list.trail.name} in ${list.season}</h1>
        ${list.trail.location}

        gear weight: ${totalWeight}oz
        <div>${list.listDescription}</div>
    </div>

    <div class="bubble">
        <h2>Pack</h2>
        <g:each in="${pack}" var="g">
            <g:render template="gear" model="[gear:g.gear]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2>Sleeping</h2>
        <g:each in="${sleep}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2>Cooking</h2>
        <g:each in="${cooking}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2>Food</h2>
        <g:each in="${food}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2>Water</h2>
        <g:each in="${water}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2>Clothes</h2>
        <g:each in="${clothes}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2>Electronics</h2>
        <g:each in="${electronics}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2>Emergency</h2>
        <g:each in="${emergency}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

</body>
</html>