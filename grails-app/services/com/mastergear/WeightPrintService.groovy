package com.mastergear

class WeightPrintService {

    def getOzInLbOz(double oz) {
        int lb = Math.floor(oz / 16);
        int remainingOz = oz - (lb * 16);

        String lbString = lb > 0 ? String.format("%slb ", lb) : "";
        String ozString = remainingOz > 0 ? String.format("%soz", remainingOz) : "";
        return lbString + ozString;
    }
}
