<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:34 PM
--%>

<!DOCTYPE html>
<%@ page import="java.text.NumberFormat; com.mastergear.GearType" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="flat">
    <link type="text/css" rel="stylesheet"
          href="${resource(dir:'css', file:'gearlistdisplay.css')}" />
</head>
<body>
    <article>
        <header id="gear-list-display-header">
            <g:render template="gearSummary" model="[list:list, totalWeight:totalWeight]" />
        </header>
        <section></section>
        <section id="gear-list"></section>
    </article>
</body>
</html>
<%--
<html>
<head>
    <meta name="layout" content="mastergear">
    <title><g:render template="title" model="[list: list]" /> - feathergear</title>
</head>
<body>
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
--%>