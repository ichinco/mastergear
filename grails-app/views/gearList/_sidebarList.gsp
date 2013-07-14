<%@ page import="com.mastergear.GearType" %>
<g:if test="${gear.size() > 0}">
    <li class="heading-item"><g:message code="${code}" /></li>
    <g:each in="${gear}" var="g">
    <li class="list-item">${g.gear.title}</li>
    </g:each>
</g:if>

