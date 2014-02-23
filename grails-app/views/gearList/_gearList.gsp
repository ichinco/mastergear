<g:link class="gear-list-item" controller="GearList" action="show" params="[id : list.id]">
    <img src="${list.imageUrl}" />
    <div class="name"><g:render template="/gearList/title" model="[list: list]" /></div>
</g:link>
