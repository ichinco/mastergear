<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 7/6/13
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="feathergear: find out what your gear adds up to"/></title>
    <link href="${resource(dir:'css', file:'mastergear.css')}" rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Lato:100,400' rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css' />
    <script src="${resource(dir:'js', file:'jquery.js')}" type="text/javascript"></script>
    <g:layoutHead/>
    <r:layoutResources />
</head>
<body class='flat'>
    <g:render template="/layouts/flat_navigation" />
    <g:render template="/layouts/logo" />
    <div class="main-content" >
        <g:layoutBody/>
    </div>
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
    <script type="text/template" id="trail_template">
    <div>
        <div class="trail-object" data-trail-id={{id}}>{{name}}</div>
    </div>
</script>
    <script type="text/template" id="trail_form_template">
        <input type="hidden" name="trail" value="{{id}}"/>
        <div class="trail-object" data-trail-id={{id}}>{{name}}</div>
    </script>
    <g:javascript library="application"/>
    <r:layoutResources />
    <script type="text/javascript">
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-39726351-1']);
      _gaq.push(['_trackPageview']);

      (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();

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
</body>
</html>