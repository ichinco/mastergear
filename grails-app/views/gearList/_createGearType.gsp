<%@ page import="com.mastergear.jobs.GearGender; com.mastergear.GearGender; com.mastergear.ProviderType" %>
<%
    List<String> genderValues = GearGender.values().collect {
        message(code:"geargender." + it.toString().toLowerCase());
    }

    List<String> providerTypeValues = ProviderType.values().collect {
        message(code:"providertype." + it.toString().toLowerCase());
    }
%>

<section class="gear-list-category ${gearType.toString().toLowerCase()}">
    <h2 class="category-title"><g:message code="geartype.${gearType}" /></h2>
    <div class="added-gear"></div>
</section>