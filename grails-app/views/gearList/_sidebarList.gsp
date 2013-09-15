    <%@ page import="com.mastergear.GearType" %>
<g:if test="${gear.size() > 0}">
    <a href="#${code}"><li class="heading-item"><g:message code="${code}" />: <g:getTotalWeight gear="${gear.collect{it.gear}}" /></li></a>
    <g:each in="${gear}" var="g">
        <a href="#${g.id}"><li class="list-item">${g.gear.title}</li></a>
    </g:each>
</g:if>

