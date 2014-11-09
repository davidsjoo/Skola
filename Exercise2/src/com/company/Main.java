package com.company;

public class Main {

    public static void main(String[] args) {

        String day = "Söndag";
        String date = "11/9";
        String month = "November";
        int year = 2014;

        int hour = 12;
        int minute = 58;
        int second = 46;

        int ssm = (hour*60)*60 + minute*60 + second;
        int stm = (24*60)*60 - ssm;

        int seconds = (24*60) * 60;
        int percent = ssm * 100 / seconds;

        System.out.println(day);
        System.out.println(date);
        System.out.println(month);
        System.out.println(year + "\n");

        System.out.println(ssm + " sekunder sedan midnatt");
        System.out.println(stm + " sekunder till midnatt");
        System.out.println(percent + " % av dagen har passerat");

    }
}
