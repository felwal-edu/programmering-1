package Prov;
import java.security.CodeSource;
import java.util.Scanner;

public class FELIX_WALLIN_PROV_KAP_1_9 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //uppgift1_4poäng();
        //uppgift2_4poäng(); //
        //uppgift3_4poäng(); //

        //uppgift4_4poäng(); //
        //uppgift5_6poäng(); //
        //uppgift6_6poäng(); //

        uppgift7_8poäng();
    }


    private static void uppgift1_4poäng() {
    /*
        UPPGIFT 1: Är talet delbart med?                                            4 POÄNG
        Fråga användaren efter två tal, t1 och t2. t1 står för tal och t2 står för delare.
        Skapa en metod static boolean ärTalDelbartMed(int tal, int delare) som givet ett tal och en delare
        returnerar true om tal är jämnt delbart med delare och false om tal inte är jämnt delbart med delare.
        Anropa din nyligen skapade metod och skriv en informerande text som anger om talet som användaren skrev in
        är delbart med eller inte delbart med den delare som användaren skrev in.
        Körexempel:
        Skriv in ett tal, tack:
        125
        Skriv in en delare, tack:
        5
        125 är jämnt delbart med 5.
     */
    }

    private static void uppgift2_4poäng() {
    /*
        UPPGIFT 2: Skriva ut en given sekvens                                       4 POÄNG
        Använd någon typ av loop för att skriva ut följande:
        22 24 26 28.0 32 34 36 38.0 42 44 46 48.0 FEMTIO 52 54 56 58.0 62
     */

        for (int i = 22; i <= 62; i += 2){

            if (Integer.toString(i).charAt(1) == '8')   { System.out.print((double)i + " "); }
            else if (i == 50)                           { System.out.print("FEMTIO "); }
            else if (i % 10 == 0)                       { }
            else                                        { System.out.print(i + " "); }
        }

    }

    private static void uppgift3_4poäng() {
    /*
        UPPGIFT 3: Beräkning av summan och medelvärdet i en lista                   4 POÄNG
        Fråga användaren hur många tal som ska skapas.
        Skapa en lista med anbefallt antal heltal.
        Skapa en metod static int summaAvTal(int[] lista) som beräknar summan av alla tal i en lista.
        Anropa metoden summaAvTal(int[] lista) med din lista som parameter och skriv ut summan.
        Skapa en metod static int medelvärde(int[] lista) som beräknar medelvärdet av alla tal i en lista.
        Anropa metoden medelvärde(int[] lista) med din lista som parameter och skriv ut medelvärdet.
     */

        System.out.print("hur lång lista? "); int antalTal = in.nextInt();
        int[] lista = new int[antalTal];

        for (int i = 0; i < antalTal; i++){
            lista[i] = (int) (Math.random()*10);
            System.out.print(lista[i] + " ");
        }
        System.out.println();

        int summa = summmaAvTal(lista);
        System.out.println("summa: " + summa);
        double medelvärde = medelvärde(lista);
        System.out.println("medelvärde: " + medelvärde);

    }
    static int summmaAvTal(int[] lista){

        int summa = 0;
        for (int i = 0; i < lista.length; i++){
            summa += lista[i];
        }
        return summa;

    }
    static double medelvärde(int[] lista){

        double medelvärde = (double) summmaAvTal(lista) / lista.length;
        return medelvärde;

    }

    // fullpot
    private static void uppgift4_4poäng() {
    /*
        UPPGIFT 4: Beräkna tecken i sträng                                          4 POÄNG
        Skapa en metod med lämpligt metodnamn som tar två parametrar; en sträng text och ett tecken tecken.
        Metoden ska returnera produkten av antal gånger som tecken förekommer i text och
        antal gånger som tecknet ‘s’ finns i text.
        Exempel:
        Parametrarna text = “stina sopar skorpsmulor” och tecken = ‘p’ ska returnera 8 eftersom det finns 4 st ‘p’ och 2 st ‘s’. 4*2 = 8.
     */

        System.out.print("en text: ");
        String text = in.nextLine();

        System.out.print("ett tecken: ");
        char tecken = in.nextLine().charAt(0);

        int produkt = antalTeckenISträng(text, tecken);
        System.out.println("produkt: " + produkt); // skriv ut produkten av antalen

    }
    public static int antalTeckenISträng(String text, char tecken){

        int antalTecken = 0;
        int antalS = 0;

        // upprepa för varje tecken i text
        for (int i = 0; i < text.length(); i++){

            // kolla om det matchar tecken
            if (text.charAt(i) == tecken) {
                antalTecken++;
            }
            // kolla om det matchar s
            if (text.charAt(i) == 's'){
                antalS++;
            }
        }
        System.out.println("antal " + tecken + ": "  + antalTecken);
        System.out.println("antal s: " + antalS);

        int produkt = antalTecken * antalS; // räkna ut produkten av antalen
        return produkt;

    }

    private static void uppgift5_6poäng() {
    /*
        UPPGIFT 5: Simulering med tärning                                           6 POÄNG
        Beräkna, med hjälp av att simulera minst 10.000 försök,
        sannolikheten att få exakt 3 sexor när du kastar 5 st åttasidiga tärningar.
     */

        int antalKast = 10000; // gör simuleringen 10000 gånger
        int antalTrippla6 = 0; // antal simuleringar som resulterar i 3 sexor

        // gör simuleringen antalKast gånger
        for (int i = 0; i < antalKast; i++){
            int antal6 = 0; // antal sexor vid varje simulering

            // gör 5st kast med 8-sidiga tärningar
            for (int j = 0; j < 5; j++){

                int kast = (int) (1 + Math.random()*8); // gör ett kast
                if (kast == 6) { antal6++; } // kolla om det blev en sexa
            }
            if (antal6 == 3){ antalTrippla6++; } // kolla om det blev exakt 3 sexor

        }
        double sannolikhet = (double) antalTrippla6 / antalKast;

        System.out.println("antal trippla sexor: " + antalTrippla6);
        System.out.println("sannolikhet att få 3 sexor: " + sannolikhet);


    }

    private static void uppgift6_6poäng() {
    /*
        UPPGIFT 6:  Rövarspråket                                                    6 POÄNG
        Skapa en metod static String rövarSpråk(String text) som tar en sträng som parameter och
        som returnerar strängen skriven i rövarspråket.
        Regeln för rövarspråket är att man efter varje konsonant lägger ett ‘o’ och därefter samma konsonant igen.
        Till exempel byts b ut mot "bob" och f mot "fof". Vokalerna är oförändrade.
        "Jag talar rövarspråket" blir alltså "jojagog totalolaror rorövovarorsospoproråkoketot".
        Bokstäverna a, e, i, o, u, y, å, ä, ö är vokaler.
        Konsonanter är alla bokstäver som inte är vokaler.
     */

        System.out.print("en sträng att röva: "); String text = in.nextLine();
        String rövadText = rövarSpråk(text);
        System.out.println("din sträng, rövad: " +  rövadText);

    }
    static String rövarSpråk(String text){

        String rövadText = "";

        // gå igenom alla bokstäver i text
        for (int i = 0; i < text.length(); i++){
            int bokstav = text.charAt(i);

            // om bokstav är en konsonant
            if ( bokstav != 'a' && bokstav != 'e' && bokstav != 'i' && bokstav != 'o' && bokstav != 'u'
                    && bokstav != 'y' && bokstav != 'å' && bokstav != 'ä' && bokstav != 'ö'
                    && bokstav != 'A' && bokstav != 'E' && bokstav != 'I' && bokstav != 'O' && bokstav != 'U'
                    && bokstav != 'Y' && bokstav != 'Å' && bokstav != 'Ä' && bokstav != 'Ö' && bokstav != ' ' )
            {
                rövadText += (char)bokstav + "o" + (char)bokstav;
            }
            // om bokstav är en vokal
            else{
                rövadText = rövadText +(char)bokstav;
            }
        }

        return rövadText;
    }

    //

    private static void uppgift7_8poäng() {
    /*
        UPPGIFT 7: Skriv ut Java-klass                                              8 POÄNG
        Skriv en metod med signaturen static void skrivUtKlass(String paketNamn, String klassNamn, String[] metodNamn, String[] variabler)
        som ska skriva ut källkoden till en Java-klass.

        Följande kod med anrop bör ge utskriften nedan:
        String[] metoder = new String[] {“kvadrera”, “derivera”};
        String[] variabler = new String[]{“variabel1”, “variabel2”};
        skrivUtKlass(“mattehörnan”, “Matte”, metoder, variabler);

        UTSKRIFT:
        package mattehörnan;
        public class Matte{
            static int variabel1 = 4;  // Det här är en variabel av typen int.
            static int variabel2 = 8; // Det här är en variabel av typen in.
        public static void main(String[] argZ){}
            // Den här metoden har returtypen void
            static void kvadrera(){}
            // Den här metoden har returtypen void
            static void derivera(){}
        }
        OBSERVERA:
        * Samtliga metoder i klassfilen ska vara void och inte ha några parametrar.
        * Samtliga variabler är av typen int och har slumpvisa värden mellan 1 och 10.
        * Klassen ska ha en main-metod.
     */

        String[] metoder = new String[] {"del1", "del2"};
        String[] variabler = new String[]{"variabel1", "variabel2"};

        skrivUtKlass("Prov", "Uppgift7", metoder, variabler);


    }
    static void skrivUtKlass(String paketNamn, String klassNamn, String[] metodNamn, String[] variabler){

        //System.out.println();

    }


}





















