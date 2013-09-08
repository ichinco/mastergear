package com.mastergear.admin

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ProviderImportController {

    def providerImportService;

    def index() {
        render view: "index"
    }

    def run() {
        providerImportService.importAvantlinkDatafeed();
    }

    def getSpecs() {
        providerImportService.getSpecs();
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
