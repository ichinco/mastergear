package com.mastergear

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

class GeocodingService {

    def List<Trail> getTrail(String name) {
        def http = new HTTPBuilder('http://maps.googleapis.com')

        List<Trail> trails = new LinkedList<Trail>();

        // perform a GET request, expecting JSON response data
        http.request(GET, JSON) {
            uri.path = '/maps/api/geocode/json'
            uri.query = [sensor: 'false', address: name]

            headers.'User-Agent' = 'feathergear'

            // response handler for a success response code:
            response.success = { resp, json ->
                println resp.statusLine

                // parse the JSON response object:
                trails =
                    json.results.collect {
                        Trail t = new Trail();
                        t.latitude = it.geometry.location.lat;
                        t.longitude = it.geometry.location.lng;
                        t.name = it.address_components[0].short_name;
                        t.location = it.formatted_address
                        t.dateCreated = new Date();
                        t.lastUpdated = new Date();

                        return t;
                    }
            }

            // handler for any failure status code:
            response.failure = { resp ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
        }

        return trails;
    }
}
