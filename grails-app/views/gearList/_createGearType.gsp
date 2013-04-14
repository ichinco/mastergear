<%@ page import="com.mastergear.GearGender; com.mastergear.ProviderType" %>
<%
    List<String> genderValues = GearGender.values().collect {
        message(code:"geargender." + it.toString().toLowerCase());
    }

    List<String> providerTypeValues = ProviderType.values().collect {
        message(code:"providertype." + it.toString().toLowerCase());
    }
%>

<div class="bubble ${gearType}">
    <div class="add-gear">
        <div class="get-suggestions">
            <g:textField name="gear-search" class="gearSearch" />
            <div class="gear-suggestion"></div>
            <div class="no-match">none of these match</div>
        </div>
        <div class="gear-create">
            <g:hiddenField name="listId" value="${list.id}" />
            <div>brand: <g:textField name="brand" class="brand" /></div>
            <div>style: <g:textField name="style" class="style" /></div>
            <div>type: <g:textField name="itemType" class="item-type" /></div>
            <div>weight: <g:textField name="weight" class="weight" />oz</div>
            <div>gender: <g:select name="gender" class="gender" from="${genderValues}" keys="${com.mastergear.GearGender.values()}"/></div>
            <div>provider type: <g:select name="providerType" class="providerType" from="${providerTypeValues}" keys="${com.mastergear.ProviderType.values()}"/></div>
            <div>image id: <g:textField name="imageId" class="imageId" /></div>
            <div>providerId: <g:textField name="providerId" class="providerId" /></div>
            <button class="create-gear">add</button>
        </div>
    </div>
    <h2><g:message code="geartype.${gearType}" /></h2>
    <div class="added-gear"></div>
    <button class="add-gear-button">add gear</button>
</div>