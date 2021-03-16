package Övrigt;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Verktygslåda {
    static Scanner in = new Scanner(System.in);


    // Sortera & Sök
    public static int[] bubbelsortera(int[] lista){

        for (int i = lista.length-1; i >= 0; i--){
            for (int j = 0; j < i; j++){

                if (lista[j] > lista[j+1]){

                    int temp = lista[j+1];
                    lista[j+1] = lista[j];
                    lista[j] = temp;
                }
            }
        }

        return lista;
    }
    public static int sökSekventiellt(int[] lista, int sökvärde){

        int index = -1;
        for (int i = 0; i < lista.length; i++){
            if (lista[i] == sökvärde) { index = i; }
        }
        return index;

    }
    public static int sökBinärt(int[] lista, int sökvärde){

        int min = 0;
        int max = lista.length-1;
        int index = -1;

        while ( min <= max && index == -1 ){
            int mitt = (min + max) / 2;

            if      (sökvärde > lista[mitt])    { min = mitt + 1; }
            else if (sökvärde < lista[mitt])    { max = mitt - 1; }
            else                                { index = mitt; }
        }
        return index;
    }


    // Chars
    public static int[] charIndex(String[] term, char tecken){

        int[] charIndex = new int[term.length];
        for (int i = 0; i < term.length; i++){

            charIndex[i] = -1;
            for (int j = 0; j < term[i].length(); j++){
                // sätt index för tecken
                if (term[i].charAt(j) == tecken){
                    charIndex[i] = j;
                }
            }
        }
        return charIndex;
    }
    public static int[] intMellanChars(String[] term, int[] förstaIndex, int[] andraIndex){

        int[] siffra = new int[term.length];
        for (int i = 0; i < term.length; i++){

            siffra[i] = Integer.valueOf(term[i].substring(förstaIndex[i]+1, andraIndex[i]));
        }
        return siffra;
    }
    public static char[] slumpaGemen(int antalGemener, String undvik, boolean dubletter){

        char[] gemen = new char[antalGemener];
        char[] undvikChar = stringCharred(undvik);
        boolean oönskad;

        // om för många
        if (!dubletter && antalGemener > 26-undvikChar.length || dubletter && undvikChar.length >= 26) {
            System.out.println("för höga krav"); return gemen;
        }

        // skapa chars
        for (int i = 0; i < gemen.length; i++) {
            do {
                oönskad = false;
                gemen[i] = (char) (int) (97 + Math.random() * 26);

                // kolla om dublett
                if (!dubletter) {
                    for (int d = 0; d < i; d++) {
                        if (gemen[i] == gemen[d]) { oönskad = true; break; }
                    }
                }

                // kolla om oönskad
                for (int c = 0; c < undvikChar.length; c++) {
                    if (gemen[i] == undvikChar[c]) { oönskad = true; break; }
                }

            } while (oönskad);
        }

        return gemen;

    }

    // Sträng till char Array
    public static char[] stringCharred(String sträng){

        char[] strängCharred = new char[sträng.length()];
        for (int i = 0; i < strängCharred.length; i++){
            strängCharred[i] = sträng.charAt(i);
        }
        return strängCharred;
    }


    // Array - skapa & ändra
    public static int[] intArrayAnpassad(){

        System.out.print("hur många tal? / hur lång lista? ");
        int antal = in.nextInt();
        int[] lista = new int[antal];

        for (int i = 0; i < lista.length; i++) {
            System.out.print("tal " + (i+1) + ": "); lista[i] = in.nextInt();
        }

        return lista;
    }
    public static int[] intArraySlumpad(int golv, int tak){

        System.out.print("hur många tal? / hur lång lista? ");
        int antal = in.nextInt();
        int[] lista = new int[antal];

        for (int i = 0; i < lista.length; i++){
            lista[i] = (int) ( golv + Math.random()*tak );
        }

        return lista;
    }

    // Array - räkna antal tecken
    public static int intArrayAntal(int[] lista, int sökvärde){
        // kollar hur många av ett tecken som finns i en lista

        int antal = 0;
        for (int i = 0; i < lista.length; i++){
            if (lista[i] == sökvärde) { antal++; }
        }
        return antal;
    }
    public static int doubleArrayAntal(double[] lista, double decimaltal){
        // kollar hur många av ett tecken som finns i en lista

        int antal = 0;
        for (int i = 0; i < lista.length; i++){
            if (lista[i] == decimaltal) { antal++; }
        }
        return antal;
    }
    public static int charArrayAntal(char[] lista, char tecken){
        // kollar hur många av ett tecken som finns i en lista

        int antal = 0;
        for (int i = 0; i < lista.length; i++){
            if (lista[i] == tecken) { antal++; }
        }
        return antal;
    }
    public static int stringAntal(String sträng, char tecken){

        int antal = 0;
        for (int i = 0; i < sträng.length(); i++){
            if (sträng.charAt(i) == tecken) { antal++; }
        }
        return antal;
    }

    // Organisera
    public static int[] intArrayBytPlats(int tal0, int tal1){
        int[] byttÄrBytt = { tal0, tal1};
        int temp = byttÄrBytt[0];
        byttÄrBytt[0] = byttÄrBytt[1];
        byttÄrBytt[1] = temp;

        return byttÄrBytt;
    }
    public static String stringBaklänges(String ord){
        String ordBaklänges = "";
        for (int i = ord.length()-1; i>=0; i--){
            ordBaklänges += ord.charAt(i);
        }
        return ordBaklänges;
    }

    // Array - till sträng
    public static String intArraySträngad(int[] lista){

        String strängadLista = Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", " ");
        return strängadLista;
    }
    public static String charArraySträngad(char[] lista){

        String strängadLista = Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", "");
        return strängadLista;
    }
    public static String stringArraySträngad(String[] lista){

        String strängadLista = Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", " ");
        return strängadLista;
    }
    // arrayList
    public static String intArrayListSträngad(ArrayList<Integer> samling){

        String strängadLista = samling.toString().replaceAll("\\[|\\]|,|\\s", " ");
        return strängadLista;
    }
    public static String charArrayListSträngad(ArrayList<Character> samling){

        String strängadLista = samling.toString().replaceAll("\\[|\\]|,|\\s", "");
        return strängadLista;
    }
    public static String stringArrayListSträngad(ArrayList<Integer> samling){

        String strängadLista = samling.toString().replaceAll("\\[|\\]|,|\\s", " ");
        return strängadLista;
    }
    // stack
    public static String intStackSträngad(Stack<Integer> samling){

        String strängadLista = samling.toString().replaceAll("\\[|\\]|,|\\s", " ");
        return strängadLista;
    }
    public static String charStackSträngad(Stack<Character> samling){

        String strängadLista = samling.toString().replaceAll("\\[|\\]|,|\\s", "");
        return strängadLista;
    }
    public static String stringStackSträngad(Stack<String> samling){

        String strängadLista = samling.toString().replaceAll("\\[|\\]|,|\\s", " ");
        return strängadLista;
    }


    // Double
    public static double doubleAvrunda(double dubbel, int decimaler){

        String sharps = "#.";
        for (int i = 0; i < decimaler; i++){ sharps += "#"; }

        // skapa en formatter med sharps st decimaler
        DecimalFormat df = new DecimalFormat(sharps);
        df.setRoundingMode(RoundingMode.HALF_UP);

        // avrunda
        String dubbelSträng;
        dubbelSträng = df.format(dubbel).replace(",", ".");
        dubbel = Double.valueOf(dubbelSträng);

        return dubbel;
    }
    public static double[] doubleArrayAvrunda(double[] dubbel, int decimaler){

        String sharps = "#.";
        for (int i = 0; i < decimaler; i++){ sharps += "#"; }

        // skapa en formatter med sharps st decimaler
        DecimalFormat df = new DecimalFormat(sharps);
        df.setRoundingMode(RoundingMode.HALF_UP);

        // avrunda
        String[] dubbelSträng = new String[dubbel.length];
        for (int i = 0; i < dubbel.length; i++){
            dubbelSträng[i] = df.format(dubbel[i]).replace(",", ".");
            dubbel[i] = Double.valueOf(dubbelSträng[i]);
        }

        return dubbel;
    }


}
























