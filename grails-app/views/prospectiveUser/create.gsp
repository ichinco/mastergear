<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 5/3/13
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="mastergear">
</head>
<body>
    <div class="bubble">
        This feature is still being developed! Leave your email address
        and we'll let you know when it's ready.
        <g:form controller="prospectiveUser" action="save" >
            <g:hiddenField name="category" value="${category}" />
            email: <g:textField name="email" />
            <g:submitButton name="submit">done</g:submitButton>
        </g:form>
    </div>

</body>
</html>