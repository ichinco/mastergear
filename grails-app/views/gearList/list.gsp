<%--
  Created by IntelliJ IDEA.
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
        <div class="trail-location">${list.trail.location}</div>

        <div class="list-weight">gear weight: ${noDecimals.format(totalWeight.getPounds())}lbs ${twoDecimals.format(totalWeight.getOunces())}oz</div>
        <div class="list-description">${list.listDescription}</div>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.pack" /></h2>
        <g:each in="${pack}" var="g">
            <g:render template="gear" model="[gear:g.gear]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.sleep" /></h2>
        <g:each in="${sleep}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.cooking" /></h2>
        <g:each in="${cooking}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.food" /></h2>
        <g:each in="${food}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.water" /></h2>
        <g:each in="${water}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.clothes" /></h2>
        <g:each in="${clothes}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.electronics" /></h2>
        <g:each in="${electronics}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.emergency" /></h2>
        <g:each in="${emergency}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

    <div class="bubble">
        <h2><g:message code="geartype.other" /></h2>
        <g:each in="${other}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity:g.quantity]"/>
        </g:each>
    </div>

</body>
</html>