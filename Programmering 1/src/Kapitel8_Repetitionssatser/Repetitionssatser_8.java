package Kapitel8_Repetitionssatser;
import java.util.Scanner;

public class Repetitionssatser_8 {
    static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {

        // Delkapitel boken
            // For();
            // While();
            // Do();
            // Uppgifter();

        // Extra Uppgifter
            // serie();

    }

    static void For (){
        // 8.4 skriv ut minsta värdet
        int[] arr = { 2, 5, 10, 4, 3, 7, };
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min)
                min = arr[i];
        }
        System.out.println(min);

        // 8.5 tabell v1
        for(int m = 1; m <= 10; m++){
            for(int n = 1; n <= 10; n++){
                System.out.print(m*n + "\t"); }
            System.out.println();
        }

        System.out.println();

        // tabell v2
        for(int m = 1; m <= 10; m++){
            for(int n = 1; n <= m; n++){
                System.out.print(m*n + "\t");
            }
            System.out.println();
        }

    } // 8.1
    static void While (){
        // 8.7 miniräknare
        while (true){
            System.out.print("räknesätt? (1+ 2- 3* 4/) "); int räknesätt = in.nextInt();
            System.out.print("tal 1: "); int tal1 = in.nextInt();
            System.out.print("tal 2: "); int tal2 = in.nextInt();
            switch(räknesätt){
                case 1:
                    System.out.println(tal1+tal2);
                    break;
                case 2:
                    System.out.println(tal1-tal2);
                    break;
                case 3:
                    System.out.println(tal1*tal2);
                    break;
                case 4:
                    System.out.println(tal1/tal2);
                    break; }
            System.out.print("igen? (1 / 0) "); int igen = in.nextInt();
            if( igen == 0)
                break;
            System.out.println(); }

        // 8.8 DO miniräknare
        char igen;
        do {
            System.out.print("räknesätt? (1+ 2- 3* 4/) "); int räknesätt = in.nextInt();
            System.out.print("tal 1: "); int tal1 = in.nextInt();
            System.out.print("tal 2: "); int tal2 = in.nextInt();
            switch(räknesätt){
                case 1:
                    System.out.println(tal1+tal2);
                    break;
                case 2:
                    System.out.println(tal1-tal2);
                    break;
                case 3:
                    System.out.println(tal1*tal2);
                    break;
                case 4:
                    System.out.println(tal1/tal2);
                    break; }
            System.out.print("igen? (j/n) ");
            igen = in.next().charAt(0);
            System.out.println();
        } while(igen == 'j');

    } // 8.2
    static void Do (){

        // 8.9 Bankkonto Meny
        int behållning = 1000;
        int belopp;
        int menyVal;
        boolean fortsätt = true;
        do{
            System.out.println();
            System.out.printf("MENY %n1. insättning %n2. uttag %n3. visa behållning %n4. avsluta");
            System.out.println();
            menyVal = in.nextInt();
            switch (menyVal){
                case 1:
                    System.out.print("vänligen ange aktuellt belopp: ");
                    belopp = in.nextInt();
                    System.out.println("insatt: " + belopp + " kr");
                    behållning += belopp;
                    System.out.println("ny behållning: " + behållning);
                    break;
                case 2:
                    System.out.print("vänligen ange aktuellt belopp: ");
                    belopp = in.nextInt();
                    if (belopp <= behållning){
                        System.out.println("uttag: " + belopp);
                        behållning -= belopp;
                        System.out.println("ny behållning: " + behållning);
                    }
                    else
                        System.out.println("du saknar " + (belopp-behållning) + ". vänligen välj annan mängd.");
                    break;
                case 3:
                    System.out.printf("du har %d kr på kontot.\n", behållning);
                    break;
                case 4:
                    fortsätt = false;
                    break;
                default:
                    System.out.println("ERROR"); }
        } while (fortsätt);

    } // 8.3
    static void Uppgifter(){

        // 8.10 Unicode +20
        System.out.println("hur många vill du ha i taget?");
        int antal = in.nextInt(); in.nextLine(); // måste ha nextLine efter nextInt?
        int start = 0;
        char fort;
        do{
            for(int n = start; n < start+antal; n++) {
                System.out.println(n + "\t" + (char) n);
            }
            System.out.printf("vill du ha %d till? (j/n) ", antal);
            fort = in.nextLine().charAt(0);
            start += antal;
        } while (fort == 'j');

        // 8.11 Företagsstatistik
        // förlänga array??
        boolean fortsätt = true;
        int [] löner = {10000, 15000, 60000, 80000, 35000, 20000};
        do{
            int val;
            int medellön = (löner[0] + löner[1] + löner[2] + löner[3] + löner[4] + löner[5]) / löner.length;
            System.out.println("1. Presentera statistik");
            System.out.println("2. Mata in nya uppgifter");
            System.out.println("3. Avsluta"); val = in.nextInt();

            switch (val){
                case 1:
                    System.out.println("antal anställda: " + löner.length);
                    for(int i = 0; i < löner.length; i++){
                        System.out.println("anställd " + (i+1) + ": " + löner[i] + " kr");
                    }
                    System.out.println("medellön: " + medellön + " kr");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("uppdatera lön (1) eller anställ ny (under arbete)(2)?");
                    int val2 = in.nextInt();
                    switch (val2){
                        case 1:
                            System.out.println("vilken anställds lön vill du uppdatera? (1-" + löner.length + ")");
                            int nummer = in.nextInt();
                            System.out.println("ny lön:");
                            löner[nummer-1] = in.nextInt();
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("lön för ny anställd:");
                            löner[löner.length+1] = in.nextInt(); // förläng lista??
                            break;
                    }
                    break;
                case 3:
                    fortsätt = false;
            }
        } while (fortsätt);


    }

    static void serie (){

        // efterfrågad serie
        for(int i=22; i<=70; i+=2){

            if(i%10 == 0)
                System.out.print((double)i + "\t");
            else if ( Integer.toString(i).charAt(1) == '6')
                continue;
            else if (i == 52)
                System.out.print("X \t");
            else
                System.out.print(i + "\t");
        }

    }
}