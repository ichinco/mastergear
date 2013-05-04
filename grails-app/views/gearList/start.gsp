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
    <meta name="layout" content="mastergear">
</head>
<body>
    <div class="bubble title" >
        <h1>feathergear</h1>
        <div class="tagline">Find out what your gear adds up to.</div>
    </div>
    <div class="bubble">
        <h1><g:message code="hiketype.day" /></h1>
        <div class="lists">
            <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.DAY)}" var="list">
                <g:render template="gearList" model="[list : list]" />
            </g:each>
            <g:link class="prosp" controller="prospectiveUser" action="create" params="[category:'Create']">
                <div>
                    create your own list
                </div>
            </g:link>
        </div>
    </div>

    <div class="bubble">
        <h1><g:message code="hiketype.backpacking" /></h1>
        <div class="lists">
            <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.BACKPACKING)}" var="list">
                <g:render template="gearList" model="[list : list]" />
            </g:each>
            <g:link class="prosp" controller="prospectiveUser" action="create" params="[category:'Create']">
                <div class="text">
                    create your own list
                </div>
            </g:link>
        </div>
    </div>

    <div class="bubble">
        <h1><g:message code="hiketype.carcamping" /></h1>
        <div class="lists">
            <g:each in="${com.mastergear.GearList.findAllByHikeType(HikeType.CARCAMPING)}" var="list">
                <g:render template="gearList" model="[list : list]" />
            </g:each>
            <g:link class="prosp" controller="prospectiveUser" action="create" params="[category:'Create']">
                <div>
                    create your own list
                </div>
            </g:link>
        </div>
    </div>
</body>
</html>