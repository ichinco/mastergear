<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.mastergear.HikeType" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="flat">
    <r:require module="start" />
</head>
<body>
    <div id="map"></div>
    <div class="intro">
        <div class="close">x</div>
        Browse gear lists that other hikers have created. Click
        on a pin and see what they have in their arsenal. Or
        <g:link controller="gearList" action="initialize">create your own list.</g:link>
    </div>
</body>
</html>