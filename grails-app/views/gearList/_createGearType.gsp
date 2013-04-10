<div class="bubble ${gearType}">
    <div class="add-gear">
        <div class="get-suggestions">
            <g:textField name="gear-search" class="gearSearch" />
            <div class="gear-suggestion"></div>
            <div class="no-match">none of these match</div>
        </div>
        <div class="gear-create">
            <div>brand: <g:textField name="brand" class="brand" /></div>
            <div>style: <g:textField name="style" class="style" /></div>
            <div>type: <g:textField name="itemType" class="item-type" /></div>
            <div>url: <g:textField name="url" class="url" /></div>
            <button class="create">add</button>
        </div>
    </div>
    <h2><g:message code="geartype.${gearType}" /></h2>
    <div class="added-gear"></div>
    <button class="add-gear-button">add gear</button>
</div>