package com.mastergear

class ProviderImportController {

    def providerImportService;

    def index() {
        render view: "index"
    }

    def run() {
        providerImportService.importAvantlinkDatafeed();
    }
}
