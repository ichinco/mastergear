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
    <div id="map">
        <div class="intro">
            <div class="close">x</div>
            Browse gear lists that other hikers have created. Click
            on a pin and see what they have in their arsenal. <br />
            Or <g:link controller="gearList" action="initialize">create your own list.</g:link>
        </div>
    </div>
    <div id="gear-list-display">
        <g:render template="/layouts/logo" />
        <svg xmlns='http://www.w3.org/2000/svg'
             version='1.1'>
            <circle id='close-button' r='30px'
                    cx='30px'
                    cy='30px' />
        </svg>
        <div class="gearlist"></div>
    </div>

    <!-- backbone template for gearlist: see gearlist js files -->
    <script type="text/template" id="gear_list_template">
        <!-- make these boxes and cells -->
        <div class='list-icon'></div>
        <div class='gear-list-item'>
            <!-- this really should be the title -->
            <div class='list-title'>{{user.username}}</div>
            <div class='list-description'>{{listDescription}}</div>

            <!-- reformat the date so that it is human readable -->
            <div class='list-date'>{{dateCreated}}</div>
            <div class='icon-{{season}}'></div>
            <div class='icon-{{hikeType}}'></div>
        </div>
    </script>
</body>
</html>