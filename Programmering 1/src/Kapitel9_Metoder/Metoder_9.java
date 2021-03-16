package Kapitel9_Metoder;
import Övrigt.Verktygslåda;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// private  : bara classen
// inget    : paketet
// public   : hela pojektet

public class Metoder_9 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Delkapitel
            // Introduktion();
            // FältOchSträngar();
            // KlassenMath();
            // Uppgifter();

        // Uppgifter Classroom
            // DagarKvar();
            Talbaser(101, 2);

    }

    // Delkapitel
    static void Introduktion(){

        // byt plats
        System.out.println("två tal att byta?");
        int tal1 = in.nextInt();
        int tal2 = in.nextInt();
        int[] byttÄrBytt = Verktygslåda.intArrayBytPlats(tal1, tal2);
        System.out.println(byttÄrBytt[0] + "\t" + byttÄrBytt[1]);

        // power
        System.out.print("ett tal att upphöja i: ");
        double bas = in.nextDouble();
        System.out.println("ett tal att upphöja med: ");
        //double y = Verktygslåda.Power(bas, in.nextDouble());
        //System.out.println("kvadrat: " + y);

        // kubera
        System.out.print("en bredd: "); int bredd = in.nextInt();
        System.out.print("en längd: "); int längd = in.nextInt();
        System.out.print("en höjd: "); int höjd = in.nextInt();
        //int volym = Verktygslåda.Cube(bredd, längd, höjd); // om inte static måste man skapa en ny instance
        //System.out.println("kubik: " + volym);

    }
    static void FältOchSträngar(){

        // fält kopieras inte, de ändras
        int[] hej = {0, 1, 2};
        System.out.println(hej[1]);
        hej(hej);
        System.out.println(hej[1]);

        // ovning 9.7 Ord Baklänges
        System.out.println("ett ord.");
        String ord = in.nextLine();
        String ordBaklänges = Verktygslåda.stringBaklänges(ord);
        System.out.println(ordBaklänges);

    } // 9.5
    static void KlassenMath(){

        // 10.000 Tärningskast antal 10:or (enkel)
        int antal = 0;

        for (int i = 0; i < 10000; i++){
            int summa = (int) (1 + Math.random()*6) + (int) (1 + Math.random()*6) + (int) (1 + Math.random()*6);
            if (summa == 10) { antal++; }
        }
        System.out.println("antal 10:or: " + antal);
        System.out.println("sannolikhet " + (antal / (double)10000));


        // 10.000 Tärningskast antal 10:or (spara värden)
        int[] resultat1 = new int[10000];
        int[] resultat2 = new int[10000];
        int[] resultat3 = new int[10000];
        int[] summa = new int[10000];

        for (int i = 0; i < 10000; i++){
            resultat1[i] = (int)(1 + Math.random()*6);
            resultat2[i] = (int)(1 + Math.random()*6);
            resultat3[i] = (int)(1 + Math.random()*6);
        }
        for (int i = 0; i < 10000; i++){
            summa[i] = resultat1[i] + resultat2[i] + resultat3[i];
        }

        int antalTior = Verktygslåda.intArrayAntal(summa, 10);
        double sannolikhet = antalTior / (double)10000;
        System.out.println("sannolikhet" + sannolikhet);


        // övning 9.9 Tärningskast statistik
        System.out.println("hur många tärningskast vil du göra?");
        int kast = in.nextInt();
        int[] resultat = new int[kast];

        for (int i = 0; i < kast; i++){
            resultat[i] = (int)(1 + Math.random()*6);
            System.out.print(resultat1[i] + ", ");
        }

        System.out.println();
        for (int i = 1; i <= 6; i++){
            System.out.println("antal " + i + ":or: " + Verktygslåda.intArrayAntal(resultat, i));
        }
    } // 9.6
    static void Uppgifter(){

        // 9.10
        double[] falt = {156, 564, 238, 520, 145, 812};
        System.out.println("variationsbredd: " + variationsbredd(falt));


        // 9.7 Primtal?
        System.out.println("ett tal tack (är det ett primtal?)");
        int tal = in.nextInt();
        System.out.println(ärPrimtal(tal));


        // 9.5 Siffra?
        System.out.println("ett tecken tack");
        in.nextLine();
        char tecken = in.nextLine().charAt(0);
        System.out.println(siffra(tecken));


        // 9.3b ritaRomb
        System.out.println("rombens höjd/bredd:");
        int höjd = in.nextInt();
        // hur hög
        for (int i = 0; i < höjd; i++){
            // hur sne
            for (int b = 0; b < i; b++){
                System.out.print(" ");
            }
            // hur bred
            for(int j = 0; j < höjd; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
        // verktyg
    static int hej(int[] hejj){
        hejj[1] = 2;
        System.out.println(hejj[1]);
        return 4;

    } // FältOchSträngar / fält kopieras inte
    static boolean siffra(char tecken){
        if(Integer.valueOf(tecken) > 47 && Integer.valueOf(tecken) < 58 ){
            return true;
        }
        else { return false; }
    } // Uppgifter / 9.5
    static boolean ärPrimtal(int tal){

        boolean ärPrimtal = true;
        for (int i = 1; i < tal; i++){
            if (i == 1) { continue; }
            if (tal % i == 0) { ärPrimtal = false; }
        }
        if (tal == 1) { ärPrimtal = false; }
        return ärPrimtal;

    } // Uppgifter / 9.7
    static double variationsbredd(double falt[]){

        int antal = falt.length;
        double minstaTalet = falt[0];
        double störstaTalet = falt[0];
        for (int i = 0; i < antal; i++){
            if (falt[i] < minstaTalet) { minstaTalet = falt[i]; }
            if (falt[i] > störstaTalet) { störstaTalet = falt[i]; }
        }
        return störstaTalet-minstaTalet;

    } // Uppgifter / 9.10

    // Uppgifter Classroom
    static void DagarKvar(){
        // import java.util.InputMismatchException

        try{
            // aktuellt datum
            System.out.print("månad (1-12): "); int månad = in.nextInt();
            System.out.print("dag: "); int dag = in.nextInt();
            System.out.print("sökt månad (1-12): "); int söktMånad = in.nextInt();
            System.out.print("sökt dag: "); int söktDag = in.nextInt();
            System.out.print("skåttår? (true / false) "); boolean skåttår = in.nextBoolean();

            // om ogiltigt datum
            if (månad > 12 || månad < 1 || dag > 31 || dag < 1) {
                System.out.println("försök med ett giltigt datum :( snälla");
            }
            // räkna & skriv ut dagar kvar
            else {
                int dagarKvar = dagarKvarTillDatum(månad, dag, söktMånad, söktDag, skåttår);
                System.out.println("dagar kvar till sökt datum: " + dagarKvar);
            }
        }
        catch (InputMismatchException error){
            System.out.println("försök med ett giltigt datum :( snälla  och snälla en bool oxå :]");
        }

    }
    static int dagarKvarTillDatum(int månad, int dag, int söktMånad, int söktDag, boolean skåttår) {

        int[] dagarPerMånad = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //                     1   2   3   4   5   6   7   8   9   10  11  12
        if (skåttår) { dagarPerMånad[1] = 29; }

        int dagarTillIdag = 0;
        int dagarTillSöktDag = 0;
        int dagarKvar;


        // dagar till idag
        for (int i = 0; i < månad-1; i++){
            dagarTillIdag += dagarPerMånad[i];
        }
        dagarTillIdag += dag;


        // dagar till sökt datum
        for (int i = 0; i < söktMånad-1; i++){
            dagarTillSöktDag += dagarPerMånad[i];
        }
        dagarTillSöktDag += söktDag;


        // räkna ut dagar kvar
        // om sökt datum inte passerat
        if (dagarTillSöktDag >= dagarTillIdag) {
            dagarKvar = dagarTillSöktDag - dagarTillIdag;
        }
        // om sökt datum passerat
        else {
            dagarKvar = dagarTillSöktDag - dagarTillIdag + 365;
        }

        return dagarKvar;

    }

    static void Talbaser(int tal, int talbas){

        int talbasInnan = 2;
        int talInnan = 101;
        int[] talInnanLista = new int [Integer.toString(talInnan).length()];

        int talTio = 0;
        int talbasEfter = 2;
        String talEfterSträng = "";
        ArrayList<String> talEfterLista = new ArrayList<>();
        int talEfter = 0;

        System.out.printf("i %dbas: %d\n", talbasInnan, talInnan);

        // till 10bas
        for (int i = 0; i < talInnanLista.length; i++){

            talInnanLista[i] = Character.getNumericValue(Integer.toString(talInnan).charAt(i));
            //System.out.printf("i 10bas: %d\n", (int)(Math.pow(talbasInnan, talInnanLista.length-1 -i)));
            talTio +=  talInnanLista[i] * Math.pow(talbasInnan, talInnanLista.length-1 -i);

        }
        System.out.printf("i %dbas: %d\n", 10, talTio);

        // till Xbas
        for (int i = 0; i < talInnanLista.length; i++){
            int e = 0;
            boolean fortsätt = true;
            do{
                int antalBaser = 0;

                // så länge det får plats hela bas^e
                if ((talTio / Math.pow(talbasEfter, e) > 1)){
                    // öka exponenten, kolla om det får plats ännu större tal
                    e++;
                }
                else{
                    if (e > 0) e--;
                    // räkna hur många hela bas^e som får plats
                    antalBaser = (int)(talTio / Math.pow(talbasEfter, e));

                    // lägg till siffran
                    //talEfterLista.add(Integer.toString(antalBaser));
                    talEfterSträng += Integer.toString(antalBaser);
                    // ta bort från talTio
                    talTio -= Math.pow(talbasEfter, antalBaser); // /e ??
                    fortsätt = false;

                }
                //System.out.println(antalBaser);
            } while(fortsätt);

        }



        talEfterSträng += Integer.toString(talTio);
        talEfter = Integer.valueOf(talEfterSträng);

        System.out.printf("i %dbas: %d\n", talbasEfter, talEfter);
        //System.out.printf("%d i talbas %d =\n%d i talbas %d =\n%d i talbas %d", talInnan, talbasInnan, talTio, 10, talEfter, talbasEfter);

    }



}

// split??
















