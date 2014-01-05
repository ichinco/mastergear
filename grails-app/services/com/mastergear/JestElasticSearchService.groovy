package com.mastergear

import io.searchbox.client.JestClient
import io.searchbox.client.JestClientFactory
import io.searchbox.client.JestResult
import io.searchbox.client.config.ClientConfig
import io.searchbox.client.config.ClientConstants
import io.searchbox.core.Delete
import io.searchbox.core.Index
import io.searchbox.core.Search

import javax.annotation.PostConstruct

class JestElasticSearchService {

    static singleton = true;

    def grailsApplication

    private JestClient client;
    private static final String INDEX = "com.mastergear.1";
    private static final String TYPE = "gear";

    @PostConstruct
    def createJest() {
        ClientConfig clientConfig = new ClientConfig();
        LinkedHashSet<String> servers = new LinkedHashSet<String>();
        servers.add(grailsApplication.config.elasticsearch.serverpath);
        clientConfig.getProperties().put(ClientConstants.SERVER_LIST, servers);
        clientConfig.getProperties().put(ClientConstants.IS_MULTI_THREADED, true);

        // Construct a new Jest client according to configuration via factory
        JestClientFactory factory = new JestClientFactory();
        factory.setClientConfig(clientConfig);
        client = factory.getObject();
    }

    def insertGearRecord(Gear gear) {
        String longDescription = ""
        String shortDescription = ""
        String subCategory = ""
        String category = ""
        String productGroup = ""
        String keywords = ""
        gear.providers.each {provider ->
            longDescription += " " + provider.longDescription
            shortDescription += " " + provider.shortDescription
            category += " " + provider.category
            subCategory += " " + provider.subCategory
            productGroup += " " + provider.productGroup
            keywords += " " + provider.keywords
        }
        String gearRecord = """{"brand":"${gear.brand.name}",
                    "type":"${gear.item.name}",
                    "title":"${gear.title}",
                    "weight":"${gear.weight}",
                    "manufacturerId": "${gear.manufacturerId}",
                    "longDescription": "${longDescription}",
                    "shortDescription": "${shortDescription}",
                    "category": "${category}",
                    "subCategory": "${subCategory}",
                    "productGroup": "${productGroup}",
                    "keywords": "${keywords}"
                    }"""
        Index index = new Index.Builder(gearRecord).index(INDEX).type(TYPE).id(Long.toString(gear.getId())).build();
        client.execute(index);
    }

    def deleteGearRecord(Gear gear) {
        Delete delete = new Delete.Builder(gear.getId().toString()).index(INDEX).type(TYPE).build();
        client.execute(delete);
    }

    List<Gear> getGear(String query){
        Search search = new Search(query);
        // multiple index or types can be added.
        search.addIndex(INDEX)
        search.addType(TYPE);

        JestResult result = client.execute(search)

        if (!result.isSucceeded()) {
            throw new RuntimeException(result.errorMessage)
        }

        List<Object> sourceList = (List<Object>) result.extractSource();

        List<Gear> gear = sourceList.collect({
            Gear.get(it.get("es_metadata_id"));
        })

        return gear;
    }
}
