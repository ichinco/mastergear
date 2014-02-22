package com.mastergear

import com.mastergear.aws.SignedRequestsHelper
import com.mastergear.GearGender
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

class AmazonProductApiService {
    static transactional = true

    def grailsApplication

    List<Gear> getGear(String keywords) {
        List<Gear> gear = new ArrayList<Gear>();
        getAmazonUrl(grailsApplication.config.amazon.searchUrl.replace("[responseGroup]", grailsApplication.config.amazon.responseGroup).replace("[keywords]", keywords),
                { resp, json ->
                    if (json.Items.Request.IsValid.equals("True") && json.Items.Errors.size.equals('')){
                        json.Items.each {
                            it.Item.each{ item ->
                                Provider p = new Provider()
                                p.setCategory(item.ItemAttributes.ProductTypeName.toString())
                                p.setGender(GearGender.UNISEX)
                                p.setImageUrl(item.MediumImage.URL.toString())
                                p.setProductGroup(item.ItemAttributes.ProductGroup.toString())
                                p.setSubCategory(item.ItemAttributes.ProductTypeSubcategory.toString())
                                p.setLinkUrl(item.DetailPageURL.toString())
                                p.setProviderId(item.ASIN.toString())
                                p.setType(ProviderType.AMAZON)
                                Set<Provider> providers = new HashSet<Provider>()
                                providers.add(p)

                                Brand b = new Brand()
                                b.setName(item.ItemAttributes.Brand.toString())

                                Gear g = new Gear();
                                g.setTitle(item.ItemAttributes.Title.toString())
                                g.setBrand(b)
                                g.setProviders(providers)

                                gear.add(g)
                            }
                        }
                    } else {
                        throw new RuntimeException("amazon product search failed.")
                    }
                })

        return gear
    }

    def getAmazonUrl(String url, success) {
        def signatureHelper = new SignedRequestsHelper(grailsApplication.config.amazon.accessKeySecret)
        def paramMap = [:]
        url.split('\\?')[1].split("&").each {
            def entry = it.split("=")
            paramMap[entry[0]] = entry[1]
        }
        def finalUrl = signatureHelper.sign(paramMap)

        def http = new HTTPBuilder(finalUrl)
        http.request(GET, XML) {
            response.success = success
        }
    }
}
