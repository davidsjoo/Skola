package com.company;

/**
 * Created by David on 2014-11-03.
 */
public class SpKm {

    private double distance;
    private double tid;

    public SpKm(double tid, double distance) {
        this.tid = tid;
        this.distance = distance;
    }

    public int getSpkm() {
        double mpkm = tid / distance;
        double rest = mpkm % 1;
        rest = rest * 100;
        rest = rest * 0.6;
        return (int) rest;
    }
}
