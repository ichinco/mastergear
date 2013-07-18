<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 4/28/13
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="flat">
    <title>users - feathergear</title>
</head>
<body>
    <article>
    <header id="trails-title">
       <div class="trails-title-container">
           <h2>Users</h2>
       </div>
    </header>
    <section id="trail-list">
    <div class="trail-list-container">
        <ul class="trail-list">
            <g:each in="${users}" var="user">
                <li>
                    <div class="trail-item-container">
                        <div class="trail-item-text">
                            <g:link controller="User" action="show" params="[userId : user.id]">${user.computeDisplayableUsername()}</g:link>
                        </div>
                    </div>
                </li>
            </g:each>
        </ul>
    </div>
    </section>
    </article>
</body>
</html>

</body>
</html>