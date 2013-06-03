package com.mastergear

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
}
