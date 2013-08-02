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
    <meta name="layout" content="flat">
    <r:external dir="css" file="forms.css" />
    <r:external dir="css" file="email-page.css" />
</head>
<body>
    <main>
    <div class="email-container">
        <div class='email-icon'
             style="background-image: url('${resource(dir: "images", file: "email.png")}')">
        </div>
        <div class="email-text">
            This feature is still being developed! Join our mailing list
            and we'll let you know when it's ready.
        </div>
        <g:form controller="prospectiveUser" action="save" >
            <g:hiddenField name="category" value="${category}" />
            <label>email:</label>
            <g:textField name="email" value="your email"/>
            <g:submitButton name="sign up" id='notify-me'>done</g:submitButton>
        </g:form>
    </div>
    </main>
</body>
</html>