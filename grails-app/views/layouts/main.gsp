<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<div id="grailsLogo" role="banner"><a href="http://grails.org"><img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/></a></div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
<!--

<!DOCTYPE html>
<html>
<head>
   <title>
      Feathergear - Find/Create/Share hiking gear list.
   </title>
<script type='text/javascript' 
        src='http://code.jquery.com/jquery-1.10.1.min.js'>
</script>
<link rel='stylesheet' href='css/main.css'>
</link>
<style>
   @import url(http://fonts.googleapis.com/css?family=Open+Sans:400,600,300|Open+Sans+Condensed:300);
</style>
<script type='text/javascript'>
(function( $ )
{
   if(!$)
   {
      console.log('game over');

      var navigation = $('.navigation');
   }
})(jQuery);
</script>
</head>
<body class='.radial-center'>
   <section class='logo'>
      <a href='./index.html'>
         <div class='logo-container'>
            <img alt='feathergear logo' 
                 src='images/logo.png' />
            <span class='logo'>
               <span class='feather'>feather</span>
               <span class='gear'>gear</span>
            </span>
         </div>
      </a>
   </section>
   <menu class='navigation'>
   <div class='nav-links'>
      <a href='./index.html'>
         <div class='nav-links-items'>
         <img src='images/icons.png' 
              class='home' />
         </div>
      </a>
      <a href='./index.html'>
         <div class='nav-links-items'>
         <img src='images/icons.png' 
              class='lists' />
         </div>
      </a>
      <a href='./index.html'>
         <div class='nav-links-items'>
         <img src='images/icons.png' 
              class='info'/>
         </div>
      </a>
      <a href='./index.html'>
         <div class='nav-links-items'>
         <img src='images/icons.png' 
              class='users'/>
         </div>
      </a>
      <a href='./index.html'>
         <div class='nav-links-items'>
         <img src='images/icons.png' 
              class='location'/>
         </div>
      </a>
   </div>
   </menu>
</body>
</html>

-->