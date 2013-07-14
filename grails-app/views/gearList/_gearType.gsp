<g:if test="${gear.size() > 0}">
    <section class="gear-list-category">
        <h2 class="category-title"><g:message code="${code}" /></h2>
        <g:each in="${gear}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity: g.quantity, notes: g.notes]"/>
        </g:each>
    </section>
</g:if>
