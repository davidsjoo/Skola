package com.company;

/**
 * Created by David on 2014-11-04.
 */
public class MpKm {

    private double tid;
    private double distance;

    public int getMpkm() {
        double mpkm = tid / distance;
        return (int) mpkm;
    }

    public MpKm(double tid, double distance) {
        this.tid = tid;
        this.distance = distance;
    }
}
