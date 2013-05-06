<g:if test="${gear.size() > 0}">
    <div class="bubble">
        <h2><g:message code="${code}" /></h2>
        <g:each in="${gear}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity: g.quantity, notes: g.notes]"/>
        </g:each>
    </div>
</g:if>
