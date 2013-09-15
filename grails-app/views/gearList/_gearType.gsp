<g:if test="${gear.size() > 0}">
    <section class="gear-list-category">
        <a name="${code}" class="reference"></a>
        <h2 class="category-title"><g:message code="${code}" />: <g:getTotalWeight gear="${gear}" /></h2>
        <g:each in="${gear}" var="g">
            <g:render template="gear" model="[gear:g.gear, quantity: g.quantity, notes: g.notes, id: g.id]"/>
        </g:each>
    </section>
</g:if>
