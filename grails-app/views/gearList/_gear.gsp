<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:55 PM
--%>

<%@ page import="java.util.regex.Pattern" contentType="text/html;charset=UTF-8" %>
<html>
    <h3>${gear.brand.name} ${gear.title} ${gear.item.name} <g:if test="${quantity > 1}">x${quantity}</g:if></h3>
    <div class="gear-data">
        weight: ${gear.weight}oz
    </div>
    <g:each in="${gear.providers}" var="provider">
        <div class="provider">
            <g:message code="providertype.html.${provider.type.toString().toLowerCase()}" args="${ [provider.providerId, provider.imageId] }" />
            <div class="provider-overlay">
                <div class="overlay-text">
                    BUY AT ${provider.type}
                </div>
            </div>
        </div>
    </g:each>
    %{--<div>${gear.notes}</div>--}%
</html>