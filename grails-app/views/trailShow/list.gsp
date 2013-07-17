<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 4/28/13
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="flat">
    <title>Browse trails - feathergear</title>
</head>
<body>
    <article>
    <header class="trails-display">
       <div class="trails-title">
           <h2>Trails</h2>
       </div>
    </header>
    <section id="trail-list">
    <div class="trail-list-container">
        <ul class="trail-list">
        <li>
            <div class="trail-item-container">
                <g:each in="${trails}" var="trail">
                    <div class="trail-item-text">
                        <g:link controller="TrailShow" action="show" params="[id : trail.id]">${trail.name}</g:link>
                    </div>
                </g:each>
            </div>
        </li>
        </ul>
    </div>
    </section>
    </article>
</body>
</html>