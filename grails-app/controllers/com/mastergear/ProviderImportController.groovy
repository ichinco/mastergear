package com.mastergear

class ProviderImportController {

    def providerImportService;

    def index() {
        render view: "index"
    }

    def run() {
        providerImportService.importAvantlinkDatafeed();
    }

    def syncWithElasticSearch() {
        providerImportService.syncWithElasticSearchAsync();
    }

    def syncWithElasticSearchAync() {
        providerImportService.syncWithElasticSearchAsync();
    }

    def deleteFromElasticSearch(){
        providerImportService.deleteFromElasticSearch();
    }
}
