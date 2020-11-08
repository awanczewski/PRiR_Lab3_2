package com.company;

public class Main {
    static int ilosc_helikopterow = 5;
    static int ilosc_miejsc = 2;
    static Ladowisko ladowisko;
    public static void main(String[] args) {
        ladowisko = new Ladowisko(ilosc_miejsc, ilosc_helikopterow);
        for(int i = 0; i < ilosc_helikopterow; i++)
            new Helikopter(i, 2000, ladowisko).start();
    }
}


