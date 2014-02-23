<html>
<head>
	<meta name='layout' content='flat'/>
	<title><g:message code="springSecurity.login.title"/></title>
    <r:external dir="css" file="auth.css" />
</head>

<body>
<div id='login'>
	<div class='inner'>
		<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
		</g:if>

        <g:form controller="login" action="create" method="POST" autocomplete="off" class="create-form">
            <h1>New User</h1>
            <g:hiddenField name="targetUri" value="${targetUri}" />
            <p>
                <label for="desired_username"><g:message code="springSecurity.login.username.label"/></label>
            </p>
            <p>
                <input type="text" name='j_desired_username' id="desired_username" placeholder="username" />
            </p>
            <p>
                <label for="email"><g:message code="springSecurity.login.email.label"/></label>
            </p>
            <p>
                <input type="email" name='j_email' id="email" placeholder="someone@something.com" />
            </p>
            <p>
                <label for="new_password"><g:message code="springSecurity.login.password.label"/>:</label>
            </p>
            <p>
                <input type="password" name='j_new_password' id="new_password" placeholder="password" />
            </p>
            <p>
                <input type='submit' id="submit_create" value='${message(code: "springSecurity.create.button")}'/>
            </p>
        </g:form>

		<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
            <h1>Log in</h1>
			<p>
				<label for='username'><g:message code="springSecurity.login.username.label"/></label>
            </p>
            <p>
                <input type='text' class='text_' name='j_username' id='username' placeholder="username"/>
            </p>
            <p>
                <label for='password'><g:message code="springSecurity.login.password.label"/></label>
            </p>
            <p>
                <input type='password' class='text_' name='j_password' id='password' placeholder="password"/>
            </p>

            <p id="remember_me_holder">
				<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
				<label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
			</p>

			<p>
				<input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
			</p>
		</form>

        <g:if test="${anonymousAllowed}">
            <g:form controller="login" action="continueAnonymously" method="post">
                <g:hiddenField name="targetUri" value="${targetUri}" />
                <h1>Continue</h1>
                <p>
                    You can create a list anonymously, but you cannot comment or view your previously used gear.
                </p>
                <p>
                    <input type='submit' id="submit_anon" value='go'/>
                </p>
            </g:form>
        </g:if>
	</div>
</div>
<script type='text/javascript'>
	<!--
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
	// -->
</script>
</body>
</html>
