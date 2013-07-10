<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="flat">
        <link href='${resource(dir:"css", file:"gearlist.css")}' rel='stylesheet' type='text/css' />
        <r:require module='start' />
    </head>
    <script type='text/javascript'>
    </script>
    <body>
        <%-- boy oh boy oh boy --%>
        <%-- is there a way to pass a bunch of variables to this
             template? --%>
        <g:render template="/layouts/gear_list_display" />
    </body>
</html>