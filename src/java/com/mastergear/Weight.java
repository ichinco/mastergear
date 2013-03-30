package com.mastergear;

/**
 * User: denise
 * Date: 3/30/13
 * Time: 1:17 PM
 */
public class Weight {

    private static final int OUNCES_PER_LB = 16;

    private double pounds;
    private double ounces;

    public Weight(double ounces) {
        this.pounds = Math.floor(ounces / OUNCES_PER_LB);
        this.ounces = ounces % OUNCES_PER_LB;
    }

    public double getPounds() {
        return pounds;
    }

    public double getOunces() {
        return ounces;
    }
}
