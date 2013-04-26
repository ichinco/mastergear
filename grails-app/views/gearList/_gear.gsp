<%--
  User: denise
  Date: 3/26/13
  Time: 9:55 PM
--%>

<%@ page import="com.mastergear.Provider; java.util.regex.Pattern" contentType="text/html;charset=UTF-8" %>
<html>
    <h3>${gear.brand.name} ${gear.title} ${gear.item.name} <g:if test="${quantity > 1}">x${quantity}</g:if></h3>
    <div class="gear-data">
        weight: ${gear.weight}oz
    </div>
    <g:if test="${gear.providers != null && gear.providers.size() > 0}">
        <%
            Provider provider = gear.providers.first();
        %>
        <div class="provider">
            <div class="provider-links">
                <g:message code="providertype.html.${provider.type.toString().toLowerCase()}" args="${ [provider.providerId, provider.imageId] }" />
            </div>
            <div class="provider-links">
                Buy from:
                <g:each in="${gear.providers}" var="p">
                    <g:message code="providertype.html.icon.${p.type.toString().toLowerCase()}" args="${ [p.providerId, provider.imageId] }" />
                </g:each>
            </div>
        </div>
    </g:if>

    <div class="gear-notes">
        ${notes}
    </div>
    %{--<div>${gear.notes}</div>--}%
</html>