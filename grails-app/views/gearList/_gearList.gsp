<g:link controller="GearList" action="showList" params="[id : list.id]">
    <img src="${list.imageUrl}" />
    <div class="name"><g:render template="/gearList/title" model="[list: list]" /></div>
</g:link>