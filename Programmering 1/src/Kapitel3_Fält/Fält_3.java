package Kapitel3_Fält;
import java.util.Arrays;
import java.util.Scanner;

public class Fält_3 {
    public static void main(String[] args){

        // Genomgångar
            // Arrays();

        // Delkapitel boken
            Talfält();
            // Teckenfält();
            // Lektionsuppgifter();
            Repetitionsuppgifter();
            Uppgifter();
    }

    public static void Arrays(){
        Scanner input = new Scanner(System.in);

        // listor v1 (int) - längre, när vill välja värden senare
        double[]poängProv1; // Deklarering
        poängProv1 = new double[22]; // Tilldelning [antal platser, räknar inte med 0]. alla har värdet 0
        poängProv1[0] = 1;
        poängProv1[1] = 0.5;
        System.out.println(poängProv1[1]);

        // listor v2 (String) - kompaktare, när man vet värden från början
        String[] minFruktkorg = {"Banan", "Äpple", "Apelsin"}; // lägga till värden i lista
        String förstaFrukten = minFruktkorg[0];
        System.out.println(förstaFrukten);
        System.out.println(minFruktkorg.length);

        // byta plats på värden i en lista
        int[] minaVärden = {3,7,5};
        System.out.println(minaVärden[0] + ", " + minaVärden[1] + ", " + minaVärden[2]); // innan
        int a = minaVärden[1];
        minaVärden[1] = minaVärden[2];
        minaVärden[2] = a;
        System.out.println(minaVärden[0] + ", " + minaVärden[1] + ", " + minaVärden[2]); // efter

        // 2D-listor
        String[][] provResultat = new String[3][2];
        String[] prov1 = {"Prov 1", "A"};
        provResultat[0] = prov1;
        String[] prov2 = {"Prov 2", "C"};
        provResultat[1] = prov2;
        String[] prov3 = {"Prov 3", "C"};
        provResultat[2] = prov3;
        System.out.println(provResultat[0][1]);

        // split
        System.out.println("vad är klockan?");
        String klockslag = input.nextLine();
        String[] klockslagUppdelat = klockslag.split(":");
        System.out.println("timmar: " + klockslagUppdelat[0]);
        System.out.println("minuter: " + klockslagUppdelat[1]);

    }
    public static void Talfält(){
        Scanner input = new Scanner(System.in);

    } // 3.1
    public static void Teckenfält(){
        Scanner input = new Scanner(System.in);

    } // 3.2
    public static void Lektionsuppgifter(){
        Scanner input = new Scanner(System.in);

        // Veckodagar
        String[] veckodagar = {"måndag", "tisdag", "onsdag", "torsdag", "fredag", "lördag", "söndag"};
        System.out.println("dag idag? (i nummer)");
        int dagIdag = input.nextInt();
        input.nextLine();
        System.out.println("idag är det " + veckodagar[dagIdag-1]);

        // Ord baklänges
        System.out.println("välj ett ord med 5 bokstäver");
        String ordGammalt = input.nextLine().substring(0, 5);
        System.out.println("du har valt ordet " + ordGammalt);
        char[] tecken;
        tecken = new char[5];
        for(int i = 0; i<5; i++){
            tecken[i] = ordGammalt.charAt(i);
        }
        char buffert = tecken[0];
        tecken[0] = tecken[4];
        tecken[4] = buffert;
        buffert = tecken[1];
        tecken[1] = tecken[3];
        tecken[3] = buffert;
        String ordNytt = new String(tecken); // char array till string
        System.out.println("ditt ord baklänges: " + ordNytt);

        // Kombinationer Megaord
        String[] ord = new String[3];
        for (int i = 1; i<=3; i++) {
            System.out.println("ord " + i + ": ");
            ord[i-1] = input.nextLine();
        }
        String[][] ordLista = new String[][]{
                {ord[0], ord[1], ord[2]}, {ord[0], ord[2], ord[1]},
                {ord[1], ord[2], ord[0]}, {ord[1], ord[0], ord[2]},
                {ord[2], ord[0], ord[1]}, {ord[2], ord[1], ord[0]}};
        String megaOrd[] = new String[6];
        for (int i = 0; i<=5; i++) {
            megaOrd[i] = Arrays.toString(ordLista[i]).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
            System.out.println(megaOrd[i]);
        }

        // Anpassad längd på array
        System.out.println("hur många värden vill du spara?");
        int längd = input.nextInt();
        input.nextLine();
        String[] användarensLista = new String[längd];
        for (int i = 1; i <= längd; i++) {
            System.out.println("spara värde " + i + ":");
            användarensLista[i-1] = input.nextLine();
        }
        System.out.println("vilket värde vill du hämta ut?");
        int önskatVärde = input.nextInt();
        System.out.println("värde nummer " + önskatVärde + " är: " + användarensLista[önskatVärde-1]);

        // 1 lista med 3 listor med 3 tal
        int[][] moderLista = new int[3][3];
        for(int i = 1; i<=3; i++){
            for(int a = 1;  a <= 3; a++){
                System.out.println("lista " + i + " tal " + a + ":");
                moderLista[i-1][a-1] = input.nextInt();
                System.out.println(moderLista[i-1][a-1]);
            }
        }
    }
    public static void Repetitionsuppgifter(){
        Scanner input = new Scanner(System.in);

    }
    public static void Uppgifter(){
        Scanner input = new Scanner(System.in);

    }
}















































