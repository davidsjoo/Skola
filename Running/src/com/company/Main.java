package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Distans: ");
        double dist = sc.nextDouble();
        System.out.print("Tid: ");
        double tid = sc.nextDouble();
        //double tid2 = sc.nextInt();

        MpKm mpkm = new MpKm(tid, dist);
        SpKm spkm = new SpKm(tid, dist);



        System.out.println(mpkm.getMpkm() + " minuter och " + spkm.getSpkm() + " sekunder per kilometer");





    }
}
