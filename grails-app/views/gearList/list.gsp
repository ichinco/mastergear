<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:34 PM
--%>

<%@ page import="java.text.NumberFormat; com.mastergear.GearType" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta name="layout" content="mastergear">
    <title><g:render template="title" model="[list: list]" /> - feathergear</title>
</head>
<body>
    <div id="sidebarList">
        <g:render template="sidebarList"  model="[gear : pack, code:'geartype.pack']" />
        <g:render template="sidebarList"  model="[gear : sleep, code:'geartype.sleep']" />
        <g:render template="sidebarList"  model="[gear : cooking, code:'geartype.cooking']" />
        <g:render template="sidebarList"  model="[gear : food, code:'geartype.food']" />
        <g:render template="sidebarList"  model="[gear : water, code:'geartype.water']" />
        <g:render template="sidebarList"  model="[gear : clothes, code:'geartype.clothes']" />
        <g:render template="sidebarList"  model="[gear : electronics, code:'geartype.electronics']" />
        <g:render template="sidebarList"  model="[gear : other, code:'geartype.other']" />
        <g:render template="sidebarList"  model="[gear : emergency, code:'geartype.emergency']" />
    </div>
    <g:render template="gearSummary" model="[list:list, totalWeight:totalWeight]" />
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