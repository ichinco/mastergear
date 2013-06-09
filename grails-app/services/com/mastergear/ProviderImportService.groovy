package com.mastergear

import java.util.concurrent.Future
import static groovyx.gpars.GParsPool.withPool;

class ProviderImportService {

    def jestElasticSearchService

    private Exception lastException;

    def importAvantlinkDatafeed() {
        withPool {
            Future result = {
                readDataFeed("C:/Users/denise/Downloads/RamseyOutdoor_134583_datafeed.csv", ProviderType.RAMSEY_OUTDOOR)
                readDataFeed("C:/Users/denise/Downloads/Rei_132663_datafeed.csv", ProviderType.REI)
            }.callAsync()

            try {
                result.get();
            } catch (Exception e) {
                lastException = e;
            }
        }
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

                        GearItemType.withTransaction({
                            type.save(flush: true);
                        });

                    }

                    def brand = line[headerMap.get("Brand Name")];
                    Brand b = Brand.findByName(brand);
                    if (b == null) {
                        b = new Brand();
                        b.name = brand;
                        Brand.withTransaction {
                            b.save(flush : true);
                        };

                    }

                    String manufacturerId = line[headerMap.get("Manufacturer Id")];
                    String title = line[headerMap.get("Product Name")];

                    Gear gear = null;
                    Provider thisProvider;

                    if (manufacturerId) {
                        gear = Gear.findByBrandAndManufacturerId(b,manufacturerId);
                    } else {
                        String providerId = line[headerMap.get("Buy Link")].split("\\?")[1].split("&")[3].split("=")[1]
                        thisProvider = Provider.findByProviderIdAndType(providerId, providerType);
                        if (thisProvider != null) {
                            gear = thisProvider.gear
                        }
                    }

                    boolean insertGear = false;
                    if (gear == null) {
                        insertGear = true;
                        gear = new Gear();
                        gear.item = type;
                        gear.brand = b;
                        gear.title = title;
                        gear.manufacturerId = manufacturerId;

                        Gear.withTransaction({
                            gear.save();
                        });
                    }

                    if (thisProvider == null ){
                        for (Provider provider : Provider.findAllByGear(gear)) {
                            if (provider.type.equals(providerType)){
                                thisProvider = provider;
                            }
                        }
                    }

                    if (thisProvider == null) {
                        thisProvider = new Provider();
                    }

                    thisProvider.type = providerType;
                    thisProvider.gear = gear;
                    thisProvider.category = line[headerMap.get("SubCategory")]
                    thisProvider.gender = gear.title.toLowerCase().contains("women") ? GearGender.FEMALE : GearGender.UNISEX;
                    thisProvider.providerSku = line[headerMap.get("SKU")]
                    thisProvider.imageUrl = line[headerMap.get("Image URL")]
                    thisProvider.linkUrl = line[headerMap.get("Buy Link")]
                    thisProvider.impressionUrl = line[headerMap.get("Product Page View Tracking")]
                    thisProvider.imageId = ""
                    thisProvider.longDescription = line[headerMap.get("Long Description")]
                    thisProvider.shortDescription = line[headerMap.get("Short Description")]
                    thisProvider.subCategory = line[headerMap.get("SubCategory")]
                    thisProvider.productGroup = line[headerMap.get("Product Group")]
                    thisProvider.keywords = line[headerMap.get("Keywords")]
                    thisProvider.providerId = thisProvider.linkUrl.split("\\?")[1].split("&")[3].split("=")[1]

                    Provider.withTransaction {
                        thisProvider.save();
                    };

                    if (insertGear) {
                        jestElasticSearchService.insertGearRecord(gear);
                    }
                }
        }
    }
}
