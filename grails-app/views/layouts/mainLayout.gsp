<!DOCTYPE html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${resource(dir:'css', file:'main.css')}" rel='stylesheet' type='text/css' />
        <script src="${resource(dir:'js', file:'jquery.js')}" type="text/javascript"></script>
        <title><g:layoutTitle default="Feathergear - find/tweak/create/share hiking gear lists"/></title>

        <g:layoutHead/>
		<r:layoutResources />
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

    <script type="text/template" id="gear_type_template">
        <div>
            <div class="gear-delete" data-gear-id={{id}} style="background-image:url('${resource(dir: "images", file: "brightmix_delete.png")}')"></div>
            <div class="gear-object" data-gear-id={{id}}>{{gear.brand.name}} {{gear.title}} {{gear.item.name}}</div>
            <button class="review-gear" data-gear-id={{id}}>review</button>
        </div>
    </script>
    <script type="text/template" id="gear_template">
        <div>
            <div class="gear-object" data-gear-id={{id}}>{{brand.name}}: {{title}}</div>
        </div>
    </script>
    <script type="text/javascript">
        !function(d,s,id){
            var js,fjs=d.getElementsByTagName(s)[0];
            if(!d.getElementById(id)){
                js=d.createElement(s);
                js.id=id;
                js.src="https://platform.twitter.com/widgets.js";
                fjs.parentNode.insertBefore(js,fjs);
            }}(document,"script","twitter-wjs");

    </script>
    <script type="text/javascript">
    // Outbound Link Tracking with Google Analytics
    // Requires jQuery 1.7 or higher (use .live if using a lower version)
    $(function() {
        $("a").on('click',function(e){
            var url = $(this).attr("href");
            // Console logs shows the domain name of the link being clicked and the current window
            // console.log('e.currentTarget.host: ' + e.currentTarget.host);
            // console.log('window.location.host: ' + window.location.host);
            // If the domains names are different, it assumes it is an external link
            // Be careful with this if you use subdomains
            if (e.currentTarget.host != window.location.host) {
    //            console.log('external link click');
                // Outbound link! Fires the Google tracker code.
                _gat._getTrackerByName()._trackEvent("Outbound Links", e.currentTarget.host, url, 0);
            }
            /*
            else {
                console.log('internal link click');
            }
            */
        });
    });
    </script>
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