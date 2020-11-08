package com.company;

import java.util.Random;

public class Pilot extends Thread {
    Random rand = new Random();
    static int LADOWISKO = 1;
    static int START = 2;
    static int LOT = 3;
    static int KONIEC_LOTU = 4;
    static int KATASTROFA = 5;
    int numerHelikoptera;
    int aktualnyStan;
    Pilot(int numerHelikoptera)
    {
        this.numerHelikoptera = numerHelikoptera;
    }
    public void run()
    {
        while (true)
            try
            {
                sleep(rand.nextInt(1000));
                if(aktualnyStan == LOT)
                    System.out.println("Pilot helikoptera nr " + numerHelikoptera + " przelatuje nad miastem");
                else if(aktualnyStan == START)
                    System.out.println("Pilot helikoptera nr " + numerHelikoptera + " rozpoczyna lot");
                else if(aktualnyStan == KONIEC_LOTU)
                    System.out.println("Pilot helikoptera nr " + numerHelikoptera + " musi niedlugo wyladowac");
                else if(aktualnyStan == LADOWISKO)
                    System.out.println("Pilot helikoptera nr " + numerHelikoptera + " odpoczywa na ladowisku");
                else if(aktualnyStan == KATASTROFA)
                    System.out.println("Pilot helikoptera nr " + numerHelikoptera + " zmarl");



            }
            catch (Exception e){}
    }
}
