package com.mastergear.web

import com.mastergear.GearList
import com.mastergear.GearUser
import com.mastergear.Trail

class CorporateController {

    def index() {}

    def about() {
        render view: "about"
    }

    def sitemap() {
        render(contentType: 'text/xml', encoding: 'UTF-8') {
            mkp.yieldUnescaped '<?xml version="1.0" encoding="UTF-8"?>'
            urlset(xmlns: "http://www.sitemaps.org/schemas/sitemap/0.9",
                    'xmlns:xsi': "http://www.w3.org/2001/XMLSchema-instance",
                    'xsi:schemaLocation': "http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd") {
                url {
                    loc(g.createLink(absolute: true, controller: 'gearList', action: 'index'))
                    changefreq('hourly')
                    priority(1.0)
                }
                url {
                    loc(g.createLink(absolute: true, controller: 'trailShow', action: 'list'))
                    changefreq('hourly')
                    priority(1.0)
                }
                GearList.list().each { domain ->
                    url {
                        loc(g.createLink(absolute: true, controller: 'gearList', action: 'show', id: domain.id))
                        changefreq('hourly')
                        priority(0.8)
                    }
                }
                GearUser.findAllByAnonymous(false).each { domain ->
                    url {
                        loc(g.createLink(absolute: true, controller: 'user', action: 'show', params: [userId: domain.id]))
                        changefreq('hourly')
                        priority(0.8)
                    }
                }
                Trail.list().each { domain ->
                    url {
                        loc(g.createLink(absolute: true, controller: 'trailShow', action: 'show', id: domain.id))
                        changefreq('hourly')
                        priority(0.8)
                    }
                }
            }
        }
    }
}