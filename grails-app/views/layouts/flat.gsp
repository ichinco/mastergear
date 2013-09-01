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
    <link href="${resource(dir:'css', file:'flat.css')}" rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Lato:100,400' rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css' />
    <script src="${resource(dir:'js', file:'jquery.js')}" type="text/javascript"></script>
    <script type="text/javascript">
        var Mastergear = Mastergear || {};
        Mastergear.Urls = Mastergear.Urls || {};

        Mastergear.Urls = {
            trail : '${createLink(controller:"trails")}',
            search : '${createLink(controller:"gear", action:"search")}',
            gearListGear : '${createLink(controller:"gearListGear", action:"list")}',
            gear: '${createLink(controller:"gear")}',
            gearlist : '${createLink(controller:"gearLists")}',
            gearListGearItem : '${createLink(controller:"gearListGear")}',
            images : '${resource(dir:'images')}/'
        };
    </script>
    <g:layoutHead/>
    <r:layoutResources />
</head>
<body class='flat'>
    <div class="background"></div>

    <div class="main-content" >
        <g:layoutBody/>
    </div>
    <g:render template="/layouts/flat_navigation" />
    <g:render template="/layouts/logo" />

    <g:javascript library="application"/>
    <r:layoutResources />
    <script type="text/javascript">

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-39726351-1']);
      _gaq.push(['_setDomainName', 'feathergear.herokuapp.com']);
      _gaq.push(['_setAllowLinker', true]);
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