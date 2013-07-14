<%@ page import="com.mastergear.GearType" %>

<h2><g:message code="${code}" /></h2>
<g:each in="${gear}" var="g">
    ${g.gear.title}
</g:each>

