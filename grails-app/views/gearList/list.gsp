<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 3/26/13
  Time: 9:34 PM
--%>

<!DOCTYPE html>

<html>
    <head>
        <meta name="layout" content="flat">
        <link type="text/css" rel="stylesheet"--}%
              href="${resource(dir:'css', file:'gearlistdisplay.css')}" />
        <r:require module="scrollbar" />
    </head>
    <body>
        <div class="gear-list-layout">
            <div class="gear-list-left-panel">
                <menu id="gearlist-side">
                    <ul class="list-container">
                        <g:render template="sidebarList"  model="[gear : pack, code:'geartype.pack']" />
                        <g:render template="sidebarList"  model="[gear : sleep, code:'geartype.sleep']" />
                        <g:render template="sidebarList"  model="[gear : cooking, code:'geartype.cooking']" />
                        <g:render template="sidebarList"  model="[gear : food, code:'geartype.food']" />
                        <g:render template="sidebarList"  model="[gear : water, code:'geartype.water']" />
                        <g:render template="sidebarList"  model="[gear : clothes, code:'geartype.clothes']" />
                        <g:render template="sidebarList"  model="[gear : electronics, code:'geartype.electronics']" />
                        <g:render template="sidebarList"  model="[gear : other, code:'geartype.other']" />
                        <g:render template="sidebarList"  model="[gear : emergency, code:'geartype.emergency']" />
                    </ul>
                </menu>
            </div>
            <div class="gear-list-main-panel">
                <article>
                    <header id="gear-list-display-header">
                        <g:render template="gearSummary" model="[list:list, totalWeight:totalWeight]" />
                    </header>
                    <div id="list-item-container">
                        <g:render template="gearType" model="[gear : pack, code: 'geartype.pack']"/>
                        <g:render template="gearType" model="[gear : sleep, code: 'geartype.sleep']"/>
                        <g:render template="gearType" model="[gear : cooking, code: 'geartype.cooking']"/>
                        <g:render template="gearType" model="[gear : food, code: 'geartype.food']"/>
                        <g:render template="gearType" model="[gear : water, code: 'geartype.water']"/>
                        <g:render template="gearType" model="[gear : clothes, code: 'geartype.clothes']"/>
                        <g:render template="gearType" model="[gear : electronics, code: 'geartype.electronics']"/>
                        <g:render template="gearType" model="[gear : emergency, code: 'geartype.emergency']"/>
                        <g:render template="gearType" model="[gear : other, code: 'geartype.other']"/>
                    </div>
                </article>
            </div>
        </div>
        <footer>
            <div id='gear-list-footer'></div>
        </footer>
        <script type="text/javascript">

            $(document).ready(function(event)
            {
                console.log($('.gear-list-left-panel').offset().top);
                $('.gear-list-left-panel').mCustomScrollbar({
                    scrollButtons:{
                        enable:true,
                    },
                    theme : 'dark-thick',
                });
            });

            $(window).resize(function(event){
                $('.gear-list-left-panel')
                    .height($(window).height() -
                                $('.gear-list-left-panel')
                                        .offset().top);
            })
        </script>
    </body>
</html>