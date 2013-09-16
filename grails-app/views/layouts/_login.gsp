<div class="login">
    <g:if test="${isLoggedIn}">
        ${username} | <g:link controller="logout" action="index">logout</g:link>
    </g:if>
    <g:else>
        <g:link controller="login" action="auth">log in</g:link>
    </g:else>
</div>