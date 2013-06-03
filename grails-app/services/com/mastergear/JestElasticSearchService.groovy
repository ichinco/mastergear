package com.mastergear

import io.searchbox.client.JestClient
import io.searchbox.client.JestClientFactory
import io.searchbox.client.JestResult
import io.searchbox.client.config.ClientConfig
import io.searchbox.client.config.ClientConstants
import io.searchbox.core.Index
import io.searchbox.core.Search

import javax.annotation.PostConstruct

class JestElasticSearchService {

    static singleton = true;

    private JestClient client;
    private static final String INDEX = "com.mastergear";

    @PostConstruct
    def createJest() {
        ClientConfig clientConfig = new ClientConfig();
        LinkedHashSet<String> servers = new LinkedHashSet<String>();
        servers.add("http://qiqgsxgp:nxxu4adr05zwy4q@elm-4941848.us-east-1.bonsai.io:80");
        clientConfig.getProperties().put(ClientConstants.SERVER_LIST, servers);
        clientConfig.getProperties().put(ClientConstants.IS_MULTI_THREADED, true);

        // Construct a new Jest client according to configuration via factory
        JestClientFactory factory = new JestClientFactory();
        factory.setClientConfig(clientConfig);
        client = factory.getObject();
    }

    def insertGearRecord(Gear gear) {
        String gearRecord = """{"brand":"${gear.brand.name}",
                    "type":"${gear.item.name}",
                    "title":"${gear.title}",
                    "weight":"${gear.weight}",
                    "manufacturerId": "${gear.manufacturerId}"}"""
        Index index = new Index.Builder(gearRecord).index(INDEX).type("gear").id(Long.toString(gear.getId())).build();
        client.execute(index);
    }

    List<Gear> getGear(String query){
        Search search = new Search(query);
        // multiple index or types can be added.
        search.addIndex(INDEX)
        search.addType("gear");

        JestResult result = client.execute(search)

        List<Object> sourceList = (List<Object>) result.extractSource();

        List<Gear> gear = sourceList.collect({
            Gear.get(it.get("es_metadata_id"));
        })

        return gear;
    }
}
