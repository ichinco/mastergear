package com.mastergear;

/**
 * User: denise
 * Date: 9/8/13
 * Time: 2:33 PM
 */
public enum WeightName {
    MINIMUM_TRAIL_WEIGHT_METRIC(0),
    MINIMUM_TRAIL_WEIGHT(1),
    WEIGHT(2),
    PACAKAGED_WEIGHT(3),
    NET_WEIGHT(4),
    AVERAGE_WEIGHT_METRIC(5),
    AVERAGE_WEIGHT(6),
    FILL_WEIGHT(7),
    WEIGHT_PER_PAIR(8),
    FLY_FOOTPRINT_PITCH_WEIGHT(9),
    NON_WEIGHT(10);

    int sortOrder;

    private WeightName(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public boolean isWeight(){
        return sortOrder < WeightName.NON_WEIGHT.getSortOrder();
    }

    public static WeightName getWeightName(String name){
        try {
            String converted = name.toUpperCase().replace(" - "," ").replace(" / ", " ").replace(" ", "_");
            return WeightName.valueOf(converted);
        } catch (Exception e) {
            return WeightName.NON_WEIGHT;
        }
    }
}
