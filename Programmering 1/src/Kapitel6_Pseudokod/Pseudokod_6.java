package Kapitel6_Pseudokod;
import java.util.Scanner;

public class Pseudokod_6 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Delkapitel boken
            // AlgoritmerOchPseudokod();
            // Aktivitetsdiagram();
            // Uppgifter();
    }

    static void info(){
        /*
        Algorithm:
        väldefinierade instruktioner för att lösa ett specifikt problem med ett ändligt antal steg
        en algoritm på människospråk kallas
        Pseudokod:
        ex:
        läs in 5 tal
        sortera talen i storleksordning
        skriv ut de två stärsta talen

        Kontrollstrukturer:
        Sekvens (en instruktion efter en annan)
        Selektion (beroende på villkor, if-else)
        Iteration (om och om igen, loopar)

        Aktivitetsdiagram:
        startar och slutar med Kvadrat med runda hörn
        instruktion Fyrkant
        villkår Romb
        */
    }

    static void AlgoritmerOchPseudokod(){
        // 6.1 översätt
        int tal[] = new int[3];
        for(int i = 0; i<3; i++){
            System.out.printf("tal %d: ", i+1);
            tal[i] = input.nextInt();
        }
        int summa = tal[0] + tal[1] + tal[2];
        System.out.printf("summa: %d", summa);

    } // 6.1
    static void Aktivitetsdiagram(){
        // 6.2 översätt
        /* pseudo
        läs in timmar
        läs in minuter
        läs in sekunder
        omvandla till endast sekunder */
        System.out.println("timmar:");
        int timmar = input. nextInt();
        System.out.println("minuter:");
        int minuter = input. nextInt();
        System.out.println("sekunder:");
        int sekunder = input. nextInt();
        int antalSekunder = timmar*3600 + minuter*60 + sekunder;
        System.out.println("sekunder: " + antalSekunder);

        // 6.3 rabatt
        /* pseudo
        om vikt >= 5 hg
        10% på pris
        skriv ut pris */
        System.out.println("vikt i hg: ");
        double vikt = input.nextDouble();
        if(vikt >= 5){
            vikt *= 0.9;
            System.out.println("du får rabatt!");
        }
        else {
            System.out.println("ingen rabatt för dig"); }

        // 6.4 räkna baklänges
        /* pseudo
        skriv ut 10, 9, 8, 7... */
        System.out.println("ett tal tack:");
        int a = input.nextInt();
        for(int i= 0; i<a; i++)
            System.out.println(a-i);

    } // 6.3
    static void Uppgifter(){
        // 6.2 jämt delbart?
        /* pseudo
        läs in tal 1 och 2
        om 1 modulo 2 är 0
        ingen rest
        annars
        rest */
        System.out.println("två tal tack:");
        int tal[] = {input.nextInt(), input.nextInt()};
        if (tal[0]%tal[1] == 0)
            System.out.println("ingen rest :)");
        else
            System.out.println("rest :(");

        // 6.3 gångertabellen
        System.out.println("ett tal tack: ");
        int valtTal = input.nextInt();
        for(int i = 1; i<= 12; i++)
            System.out.print(valtTal*i + ", ");
    }
}