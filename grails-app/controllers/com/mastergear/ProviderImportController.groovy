package com.mastergear

import java.util.concurrent.Future

class ProviderImportController {

    def providerImportService;
    def jestElasticSearchService;

    def index() {
        render view: "index"
    }

    def run() {
        providerImportService.importAvantlinkDatafeed();
    }

    def syncWithElasticSearch() {
        Gear.list().each {
            jestElasticSearchService.insertGearRecord(it);
        }
    }

    def deleteFromElasticSearch(){
        Gear.list().each {
            jestElasticSearchService.deleteGearRecord(it);
        }
    }
}
