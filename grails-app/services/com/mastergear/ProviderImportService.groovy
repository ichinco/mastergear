package com.mastergear

class ProviderImportService {

    def jestElasticSearchService

    def importAvantlinkDatafeed() {
        readDataFeed("C:/Users/denise/Downloads/RamseyOutdoor_134583_datafeed.csv", ProviderType.REI);
    }

    def readDataFeed(String filename, ProviderType providerType) {
        boolean firstLine = true;
        def headerMap = [:]
        new File(filename).eachCsvLine {
            line ->
                if (firstLine) {
                    int i=0;
                    for (String title : line){
                        headerMap.put(title, i);
                        i++;
                    }
                    firstLine = false;
                } else {

                    def category = line[headerMap.get("Category")];
                    GearItemType type = GearItemType.findByName(category);
                    if (type == null){
                        type = new GearItemType();
                        type.name = category;
                        type.save(flush: true);

                    }

                    def brand = line[headerMap.get("Brand Name")];
                    Brand b = Brand.findByName(brand);
                    if (b == null) {
                        b = new Brand();
                        b.name = brand;
                        b.save(flush : true);

                    }

                    String manufacturerId = line[headerMap.get("Manufacturer Id")];
                    String title = line[headerMap.get("Product Name")];

                    Gear gear = Gear.findByBrandAndManufacturerId(b,manufacturerId);

                    if (gear == null) {
                        gear = new Gear();
                        gear.item = type;
                        gear.brand = b;
                        gear.title = title;
                        gear.manufacturerId = manufacturerId;

                        gear.save();

                        jestElasticSearchService.insertGearRecord(gear);
                    }

                    Provider thisProvider = null;
                    for (Provider provider : gear.providers) {
                        if (provider.type.equals(providerType)){
                            thisProvider = provider;
                        }
                    }

                    if (thisProvider == null) {
                        thisProvider = new Provider();
                        thisProvider.type = providerType;
                        thisProvider.gear = gear;
                        thisProvider.category = line[headerMap.get("SubCategory")]
                        thisProvider.gender = gear.title.toLowerCase().contains("women") ? GearGender.FEMALE : GearGender.UNISEX;
                        thisProvider.providerSku = line[headerMap.get("SKU")]
                        thisProvider.imageUrl = line[headerMap.get("Image URL")]
                        thisProvider.linkUrl = line[headerMap.get("Buy Link")]
                        thisProvider.impressionUrl = line[headerMap.get("Product Page View Tracking")]
                        thisProvider.imageId = ""
                        thisProvider.providerId = thisProvider.linkUrl.split("\\?")[1].split("&")[3].split("=")[1]

                        thisProvider.save();
                    }

                }
        }
    }
}
