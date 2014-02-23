package com.mastergear

class WeightPrintService {

    def getOzInLbOz(double oz) {
        int lb = Math.floor(oz / 16);
        int remainingOz = oz - (lb * 16);

        String lbString = lb > 0 ? String.format("%slb ", lb) : "";
        String ozString = remainingOz > 0 ? String.format("%soz", remainingOz) : "";
        return lbString + ozString;
    }

    def getOzInLbOz(String oz) {
        if (oz.size() > 0){
            return getOzInLbOz(Double.parseDouble(oz));
        } else {
            return "";
        }
    }

    def getTotalWeight(List<GearListGear> gear) {
        def weights = gear.collect {
            it.gear.weight
        }

        def sum = 0D;
        weights.each {
            sum += it;
        }

        return getOzInLbOz(sum);
    }
}
