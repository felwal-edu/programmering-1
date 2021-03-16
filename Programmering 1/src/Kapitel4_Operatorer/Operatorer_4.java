package Kapitel4_Operatorer;
import java.util.Scanner;

public class Operatorer_4 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // ctrl + alt + m för att Skapa en Metod

        // Delkapitel boken
            // AritmenskaOperatorer();
            // TilldelandeOperatorer();
            // FörändringsOperatorer();
            // Prioritering();
            Uppgifter();

        // Genomgångar
            Lektionsuppgifter();

    }

    static void AritmenskaOperatorer() {
        // de värden som operatorn hanterar kallas operanders

        // Övming 4.1 modulo med double och int
        double a = 27;
        double b = 7;
        System.out.println(a/b);
        System.out.println((int)a/(int)b);
        System.out.println(a%b); // % double räknar som om det vore heltal, ger resultat i double
        System.out.println((int)a%(int)b);

        // Övning 4.2 månader till år och månader
        System.out.println("antal månader: ");
        int antalMånader = input.nextInt();
        int år = antalMånader/12;
        int månader = antalMånader%12;
        System.out.println(år + " år och " + månader + " månader");

        // Minuter till timmar och minuter
        System.out.println("antal minuter:");
        int antalMinuter = input.nextInt();
        int minuter = antalMinuter % 60;
        int timmar = antalMinuter / 60;
        System.out.println(timmar + " h och " + minuter + " min");

    } // 4.1
    static void TilldelandeOperatorer() {
        // +=
        int a = 5;
        System.out.println("vad vill du plussa " + a + " med?");
        int plussa = input.nextInt();
        a += plussa;
        System.out.println(a);

    } // 4.2
    static void FörändringsOperatorer(){
        // Övning 4.4
        int a = 10;
        System.out.println(a--); // printar tal, ger sen tal värdet 5-1
        System.out.println(a);
        System.out.println(--a); // ger tal värdet 4-1, printar sen

    } // 4.3
    static void Prioritering(){
        // Övning 4.5
        int tal1 = 5 + 6%4;
        int tal2 = (5+6)%4;
        double tal3 = 5;
        tal3 *= 2.5 +1;
        System.out.println(tal1 +" "+ tal2 +" "+ tal3); // *= tilldelas sist

    } // 4.4
    static void Uppgifter(){
        // 4.6 endast till timmar / minuter / sekunder
        String format[] = {"timmar", "minuter", "sekunder"};
        int antal[] = new int[3];
        for(int i = 0; i < 3; i++){
            System.out.printf("ange antalet %s ", format[i]);
            antal[i] = input.nextInt();
        }
        double timmar1 = (double)antal[0] + (double)antal[1]/60 + (double)antal[2]/3600;
        double minuter1 = (double)antal[0]*60 + (double)antal[1] + (double)antal[2]/60;
        double sekunder1 = (double)antal[0]*3600 + (double)antal[1]*60 + (double)antal[0];
        System.out.printf("tidsomvandling ger: %n%.3f h = %.3f min = %.3f sec %n", timmar1, minuter1, sekunder1);

        // 4.7 sekunder till timmar, minuter, sekunder
        System.out.println("tid i sekunder: ");
        int antalSekunder = input.nextInt();
        int sekunder  = antalSekunder % 60;
        int timmar = antalSekunder / 60;
        int minuter = timmar % 60;
        timmar /= 60;
        System.out.printf("%d h, %d min, %d sec", timmar, minuter, sekunder);

    }
    static void Lektionsuppgifter(){
        // PrintFormat
        float a = 2.232456f;
        int b = 4;
        int c = 6;
        System.out.printf("a är %.2f och b är %d och c är %d.", a,b,c); // d står för heltal, f för float. .2 = 2 decimaler

        // 1. Liter färg
        System.out.println("hur många liter färg? 1 hink = 5 liter.");
        int liter = input.nextInt();
        int hinkar = (liter+4)/5; // bättre sätt?
        int sistaHinken = liter % 5;
        System.out.println(hinkar + " hinkar. " + sistaHinken + " liter i sista hinken.");

        // 2. Differens, produkt & summa mellan 3 tal med for
        int tal[] = new int[3];
        char bokstav[] = {'a', 'b', 'c'};
        for(int i = 0; i < 3; i++){
            System.out.printf("tal %c: ", bokstav[i]);
            tal[i] = input.nextInt();
        }
        int produkt = tal[0]*tal[1]*tal[2];
        int summa = tal[0]+tal[1]+tal[2];
        System.out.println("differens: " + (produkt-summa));

    }
}















