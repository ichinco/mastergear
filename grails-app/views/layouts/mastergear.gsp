<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Master Gear"/></title>
    <link href="${resource(dir:'css', file:'mastergear.css')}" rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Lato:100,400' rel='stylesheet' type='text/css'>
    <script src="${resource(dir:'js', file:'jquery.js')}" type="text/javascript"></script>
    <g:layoutHead/>
    <r:layoutResources />
</head>
<body>
    <g:render template="/layouts/navigation" />
    <g:layoutBody/>
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
                // Checks to see if the ctrl or command key is held down
                // which could indicate the link is being opened in a new tab
                if (e.metaKey || e.ctrlKey) {
                    // console.log('ctrl or meta key pressed');
                    var newtab = true;
                }
                // If it is not a new tab, we need to delay the loading
                // of the new link for a just a second in order to give the
                // Google track event time to fully fire
                if (!newtab) {
                    // console.log('default prevented');
                    e.preventDefault();
                    // console.log('loading link after brief timeout');
                    setTimeout('document.location = "' + url + '"', 100);
                }
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