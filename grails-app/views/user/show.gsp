<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/31/13
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="flat">
    <r:require module="startcss" />
    <title>${user.computeDisplayableUsername()} - feathergear</title>
</head>
<body>
    <div class="gear-list-main-panel user-list">
        <article>
            <header id="gear-list-display-header">
                <h1 class="title">${user.computeDisplayableUsername()}</h1>

                <g:if test="${profile.twitterId}"><div>twitter: ${profile.twitterId}</div></g:if>
                <div>favorite hike: <g:link controller="trail" action="show" params="[id : profile.favoriteTrail.id]">${profile.favoriteTrail.name}</g:link></div>
            </header>

            <section class="gear-list-category user-list">
                <h2 class="category-title">About</h2>
                ${profile.about}
            </section>

            <section class="gear-list-category user-list trail-list">
                <h2 class="category-title">Gear Lists</h2>
                <g:each in="${lists}" var="list">
                    <g:render template="/gearList/gearList" model="[list : list]" />
                </g:each>
            </section>

            <section class="gear-list-category user-list">
                <h2 class="category-title">Favorite Gear</h2>
                <g:each in="${gear}" var="g">
                    <g:render template="/gearList/gear" model="[gear:g, quantity:1, notes: '']"/>
                </g:each>
            </section>
        </article>
    </div>
</body>
</html>