<!DOCTYPE html>
<html>
	<head>
		<title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
		<meta name="layout" content="flat">
		<g:if env="development">
            <link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css">
        </g:if>
	</head>
	<body>
		<g:if env="development">
			<g:renderException exception="${exception}" />
		</g:if>
		<g:else>
			<div class="bubble">
				An error has occurred. If this problem persists, please contact
                the website's administrators.
			</div>
		</g:else>
	</body>
</html>
