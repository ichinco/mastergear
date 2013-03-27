<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <h3>${gear.name} <g:if test="${gear.quantity > 1}">x${gear.quantity}</g:if></h3>
    <a href="${gear.url}">
        <img src="${gear.imageUrl}" />
    </a>
    weight: ${gear.weight}oz
    <div>${gear.notes}</div>
</html>