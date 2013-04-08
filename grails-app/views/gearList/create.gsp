<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/31/13
  Time: 3:26 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create a new gear list</title>
    <meta name="layout" content="mastergear">
    <r:require module="createlist" />
</head>
<body>
    <div class="bubble pack">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>
        <h2><g:message code="geartype.pack" /></h2>
        <div class="added-gear"></div>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble sleep">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>
        <h2><g:message code="geartype.sleep" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble cooking">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>
        <h2><g:message code="geartype.cooking" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble food">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>

        <h2><g:message code="geartype.food" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble water">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>
        <h2><g:message code="geartype.water" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble clothes">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>

        <h2><g:message code="geartype.clothes" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble electronics">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>

        <h2><g:message code="geartype.electronics" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble emergency">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>

        <h2><g:message code="geartype.emergency" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
    <div class="bubble other">
        <div class="add-gear">
            <g:textField name="gearSearch" class="gearSearch" />
            <div class="gearSuggestion"></div>
        </div>

        <h2><g:message code="geartype.other" /></h2>
        <button class="add-gear-button">add gear</button>
    </div>
</body>
</html>