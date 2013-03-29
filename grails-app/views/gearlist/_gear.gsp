<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <h3>${gear.brand.name} ${gear.item.name} ${gear.title} <g:if test="${quantity > 1}">x${quantity}</g:if></h3>
    %{--<g:each in="${gear.providers}" var="provider">--}%
        %{--<a href="${gear.url}">--}%
            %{--<img src="${gear.imageUrl}" />--}%
        %{--</a>--}%
    %{--</g:each>--}%
    weight: ${gear.weight}oz
    %{--<div>${gear.notes}</div>--}%
</html>