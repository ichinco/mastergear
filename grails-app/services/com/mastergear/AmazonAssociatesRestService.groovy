package com.mastergear

import com.mastergear.amazon.AWSECommerceService
import com.mastergear.amazon.AWSECommerceServicePortType
import com.mastergear.amazon.Item
import com.mastergear.amazon.ItemSearch
import com.mastergear.amazon.ItemSearchRequest
import com.mastergear.amazon.ItemSearchResponse
import com.mastergear.amazon.Items
import com.mastergear.GearGender
import org.apache.cxf.interceptor.LoggingOutInterceptor
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean

import javax.annotation.PostConstruct
import javax.xml.ws.Service

class AmazonAssociatesRestService {

    private static final String SEARCH_INDEX = "SportingGoods";

    private static final String AWS_ACCESS_KEY_ID = "1VH1V4VNZN4YQ7P9AXG2";
    private static final String AWS_ASSOCIATES_TAG = "trythaton-20";

    List<Gear> getGear(String keywords) {
        AWSECommerceService locator = new AWSECommerceService();
        AWSECommerceServicePortType service = locator.getAWSECommerceServicePort();



        // Construct a simple ItemLookup request
        ItemSearchRequest isr = new ItemSearchRequest()
        isr.setKeywords(keywords);
        isr.setSearchIndex(SEARCH_INDEX);

        ItemSearch request = new ItemSearch();
        request.setAssociateTag(AWS_ASSOCIATES_TAG)
        request.setAWSAccessKeyId(AWS_ACCESS_KEY_ID)
        request.setShared(isr);

        // Fetch the response and print out the title
        ItemSearchResponse response = service.itemSearch(request);
        List<Items> items = response.getItems();
        List<Gear> gear = new ArrayList<Gear>();
        items.each { i ->
            List<Item> itemList = i.item;
            itemList.each { item ->
                Provider p = new Provider()
                p.setCategory(item.itemAttributes.productTypeName)
                p.setGender(GearGender.UNISEX)
                p.setImageUrl(item.mediumImage.URL)
                p.setProductGroup(item.itemAttributes.productGroup)
                p.setSubCategory(item.itemAttributes.productTypeSubcategory)
                p.setLinkUrl(item.itemLinks.itemLink.get(0).URL)
                p.setProviderId(item.ASIN)
                Set<Provider> providers = new HashSet<Provider>()
                providers.add(p)

                Brand b = new Brand()
                b.setName(item.itemAttributes.brand)

                Gear g = new Gear();
                g.setTitle(item.itemAttributes.title)
                g.setBrand(b)
                g.setProviders(providers)

                gear.add(g)
            }
        }

        return gear
    }
}
