package com.company;

public class Ladowisko {
    static int LADOWISKO = 1;
    static int START = 2;
    static int LOT = 3;
    static int KONIEC_LOTU = 4;
    static int KATASTROFA = 5;

    int ilosc_miejsc;
    int ilosc_zajetych;
    int ilosc_helikopterow;

    Ladowisko(int ilosc_miejsc, int ilosc_helikopterow)
    {
        this.ilosc_miejsc = ilosc_miejsc;
        this.ilosc_helikopterow = ilosc_helikopterow;
        this.ilosc_zajetych = 0;
    }
    synchronized int start(int numer)
    {
        ilosc_zajetych--;
        System.out.println("Pozwolenie na start helikopterowi nr: " + numer);
        return START;
    }
    synchronized int laduj()
    {
        try
        {
            Thread.currentThread().sleep(1000);
        }
        catch (Exception e)
        {

        }
        if(ilosc_zajetych < ilosc_miejsc)
        {
            ilosc_zajetych++;
            System.out.println("Pozwolenie ladowania na miejscu nr: " + ilosc_zajetych);
            return LADOWISKO;
        }
        else
            return KONIEC_LOTU;
    }
    synchronized void zmniejsz()
    {
        ilosc_helikopterow--;
        System.out.println("ZABILEM");
        if(ilosc_helikopterow == ilosc_miejsc)
            System.out.println("Ilosc samolotow jest taka sama jak ilosc miejsc");
    }
}
