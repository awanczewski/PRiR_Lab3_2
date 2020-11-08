package com.company;

import java.util.Random;

public class Helikopter extends Thread {
    static int LADOWISKO = 1;
    static int START = 2;
    static int LOT = 3;
    static int KONIEC_LOTU = 4;
    static int KATASTROFA = 5;
    static int TANKUJ = 1000;
    static int REZERWA = 500;

    int numer;
    int paliwo;
    int stan;
    Ladowisko l;
    Random rand;
    Pilot p;

    public Helikopter(int numer, int paliwo, Ladowisko l)
    {
        this.numer = numer;
        this.paliwo = paliwo;
        this.stan = LOT;
        this.l = l;
        rand = new Random();
        p = new Pilot(numer);
    }

    public void run()
    {
        p.start();
        while(true)
        {
            if(stan == LADOWISKO)
            {
                p.aktualnyStan = stan;
                if(rand.nextInt(2) == 1)
                {
                    stan = START;
                    paliwo = TANKUJ;
                    System.out.println("Na lądowisku prosze o pozwolenie na start, Helikopter nr: " + numer);
                    stan = l.start(numer);
                }
                else
                {
                    System.out.println("Postoje sobie jeszcze troche");
                }
            }
            else if(stan == START)
            {
                p.aktualnyStan = stan;
                System.out.println("Wystartowałem, helikopter nr: " + numer);
                stan = LOT;
            }
            else if(stan == LOT)
            {
                p.aktualnyStan = stan;
                paliwo -= rand.nextInt(500);
                System.out.println("Helikopter nr: " + numer + " w powietrzu");
                if(paliwo<=REZERWA)
                {
                    stan = KONIEC_LOTU;
                }
                else try
                {
                    sleep(rand.nextInt(1000));
                }
                catch(Exception e) { }
            }
            else if(stan == KONIEC_LOTU)
            {
                p.aktualnyStan = stan;
                System.out.println("Prosze o pozwolenie na ladowanie, Helikopter nr: " + numer + " ilosc paliwa " + paliwo);
                stan = l.laduj();
                if(stan == KONIEC_LOTU)
                {
                    paliwo-= rand.nextInt(500);
                    System.out.println("REZERWA " + paliwo);
                    if(paliwo<=0)
                        stan = KATASTROFA;
                }
            }
            else  if(stan == KATASTROFA)
            {
                System.out.println("KATASTROFA helikopter nr: " + numer);
                p.aktualnyStan = stan;
                l.zmniejsz();
            }

        }
    }
}
