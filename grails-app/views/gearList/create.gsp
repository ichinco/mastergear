<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/31/13
  Time: 3:26 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mastergear.GearType; com.mastergear.Provider; com.mastergear.ProviderType; com.mastergear.GearGender; com.mastergear.HikeType; com.mastergear.Season" contentType="text/html;charset=UTF-8" %>

<%
    List<String> geartypeValues = GearType.values().collect {
         message(code:"geartype.${it.toString().toLowerCase()}");
     }
%>
<html>
<head>
    <title>Create a new gear list</title>
    <meta name="layout" content="flat">
    <r:require module="createlist" />
</head>
<body>
    <div id="review-gear" class="pop-background">
        <div class="pop">
            <div class="content">
                <div class="close-pop" style="background-image: url(${resource(dir:"images", file:"brightmix_delete.png")})"></div>
                <h1></h1>
                <div>
                    Tell us why you can't leave it home. Do you make any modifications to it?
                    Are there aspects of this particular brand that you wish were different?
                </div>
                <g:textArea name="gear-review" class="gear-review" rows="4" cols="75" />
                <button class="create-review">create review</button>
            </div>
        </div>
    </div>

    <div id="create-item-dialog" class="add-gear pop-background">
        <div class="pop">
            <div class="content">
                <h1>add gear item</h1>
                <div class="get-suggestions">
                    <g:form class="search-form" >
                        <fieldset>
                            <label>search items</label>
                            <g:textField name="category" class="category-desc" />
                            <g:submitButton name="search" class="category" />
                            <img class="loading" src="${resource(dir:'images', file:'spinner.gif')}" />
                        <fieldset>
                    </g:form>
                </div>
                <fieldset class="gearType-field">
                    <label for="type">type</label>
                    <g:select name="type"
                              from="${geartypeValues}"
                              class="gearType"
                              keys="${GearType.values()}" />
                </fieldset>
                <button class="add-gear-button">add item</button>
            </div>
            <div class="gear-suggestion">

            </div>
        </div>
    </div>
    <div id="gear-list-display-header">
        <g:render template="gearSummary" model="[list:list, totalWeight:totalWeight]" />
        <button class="add-gear-button">add gear</button>
    </div>

    <g:render template="createGearType" model="[gearType:'pack']" />
    <g:render template="createGearType" model="[gearType:'sleep']" />
    <g:render template="createGearType" model="[gearType:'cooking']" />
    <g:render template="createGearType" model="[gearType:'food']" />
    <g:render template="createGearType" model="[gearType:'water']" />
    <g:render template="createGearType" model="[gearType:'clothes']" />
    <g:render template="createGearType" model="[gearType:'electronics']" />
    <g:render template="createGearType" model="[gearType:'emergency']" />
    <g:render template="createGearType" model="[gearType:'other']" />

<script type="text/template" id="gear_type_template">
    <div class="item-container">
        <a name="{{id}}" class="reference" ></a>
        <div class="item-image">
            <div class="image-wrapper">
                {{gear.providers[0].imageUrl}}
            </div>
        </div>
        <!-- item information -->
        <div class="item-info">
            <h3 class="item-title">
                {{gear.brand}} {{gear.title}} {{gear.itemType}}
            </h3>
            <div class="item-provider">
                buy from:
                {! for (var i = 0; i < gear.providers.length; i++) { !}
                    {! var provider = gear.providers[0]; !}
                    {{provider.iconUrl}}
                {! } !}
            </div>
            <div class="item-description">
                {{notes}}
            </div>
            <div class="item-data">
                weight: {{gear.weight}}oz
            </div>
        </div>
        <div class="gear-delete" data-gear-id={{id}} style="background-image:url('${resource(dir: "images", file: "brightmix_delete.png")}')"></div>
        <button class="review-gear" data-gear-id={{id}}>review</button>
    </div>
</script>
<script type="text/template" id="gear_template">
    <div class="item-container gear-object" data-gear-id={{id}}>
        <div class="item-image">
            <div class="image-wrapper">
                {! if (providers.length > 0) { !}
                    {{providers[0].imageUrl}}
                {! } !}
            </div>
        </div>

        <!-- item information -->
        <div class="item-info">
            <h3 class="item-title">
                {{brand}} {{title}} {{itemType}}
            </h3>
                <div class="item-provider">
                    buy from:
                    {! for (var i = 0; i < providers.length; i++) { !}
                        {! var provider = providers[i]; !}
                        {{provider.iconUrl}}
                    {! } !}
                </div>
        </div>
    </div>
</script>
    <script type="text/javascript">
    var Mastergear = Mastergear || {};
    Mastergear.listId = ${list.id};
    </script>
</body>
</html>