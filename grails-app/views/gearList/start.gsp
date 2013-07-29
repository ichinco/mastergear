<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.mastergear.HikeType" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html class="front-page">
<head>
    <meta name="layout" content="flat">
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCURdG3H4OW33dNUQGrxI531CAJcYovDeE&sensor=false"></script>
    <r:require module="start" />
</head>
<body class="front-page">
    <div id="map-container">
        <div id="map">

        </div>
        <div class="intro">
            <div class="close">x</div>
            Browse gear lists that other hikers have created. Click
            on a pin and see what they have in their arsenal.
        </div>
    </div>
    <div id="gear-list-display">
        <div class='close-button'>
        </div>
        <div class="gearlist"></div>
    </div>

    <!-- backbone template for gearlist: see gearlist js files -->
    <script type="text/template" id="gear_list_template">
        <!-- make these boxes and cells -->
        <a href="{{url}}">
            <div class='list-icon'>
                <div class='{{hikeType}} hike-symbol'></div>
            </div>
            <div class='gear-list-item'>
                    <!-- this really should be the title -->
                    <div class='list-title'>{{title}}</div>
                    <div class='list-description'>{{listDescription}}</div>

                    <!-- reformat the date so that it is human readable -->
                    <div class='list-date'>{{moment(dateCreated).format('MMMM D, YYYY')}}</div>
                    <div class='icon-{{season}}'></div>
                    <div class='icon-{{hikeType}}'></div>

            </div>
        </a>
    </script>
    <script type="text/javascript">
        $(document).ready(function(evt)
            {
                $('body').addClass('front-page');
            }
        )
    </script>
</body>
</html>