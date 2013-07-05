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
    <div class="add-gear pop-background">
        <div class="pop">
            <div class="content">
                <div class="close-pop" style="background-image: url(${resource(dir:"images", file:"brightmix_delete.png")})"></div>
                <h1>Add <g:message code="geartype.${gearType}" /> Gear</h1>
                <div class="get-suggestions">
                    <g:form class="search-form" >
                        <g:textField name="category" class="category-desc" />
                        <g:submitButton name="search" class="category" />
                        <img class="loading" src="${resource(dir:'images', file:'spinner.gif')}" />
                    </g:form>
                    <div class="gear-suggestion"></div>
                    %{--<button class="no-match">none of these</button>--}%
                </div>
                <div class="gear-create object-form">
                </div>
                <g:hiddenField name="listId" value="${list.id}" />
                <label for="brand">brand</label>
                <g:textField name="brand" class="brand" /><br />
                <label for="style">style</label>
                <g:textField name="style" class="style" /><br />
                <label for="itemType">type (ie, pack, pants, sunhat)</label>
                <g:textField name="itemType" class="item-type" /><br />
                <label for="weight">weight</label>
                <g:textField name="weight" class="weight" />oz<br />
                <label for="gender">gender</label>
                <g:select name="gender" class="gender" from="${genderValues}" keys="${com.mastergear.GearGender.values()}"/><br />
                <label for="provider">link to buy</label>
                <g:textField name="provider" class="provider" /><br />
                <label for="create-gear"></label>
                <button class="create-gear">add</button>
            </div>
        </div>
    </div>
    <h2><g:message code="geartype.${gearType}" /></h2>
    <div class="added-gear"></div>
    <button class="add-gear-button">add gear</button>
</div>