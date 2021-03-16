package Projekt;
import Övrigt.Verktygslåda;
import java.util.*;

public class IntegralDifferentialKalkyl {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("genom att använda denna tjänst godkänner du våra användarvillkår:" +
                "\n - positiva exponenter" +
                "\n - positiva koefficienter" +
                "\n - använd a-z" +
                "\n - inga (), * eller andra tecken" +
                "\n - kx^e\n");

        boolean fortsätt = true;

        ArrayList<String> sparadeFunktioner = new ArrayList<>();
        sparadeFunktioner.add("8.1x^1.5 - 6x^2 + 4x + 88");
        sparadeFunktioner.add("x^4 + 5");
        sparadeFunktioner.add("z^100");

        try { do {
                System.out.println("[1] Derivera\n[2] AntiDerivera\n[3] Integrera\n[0] Avsluta");
                char kalkyl = in.nextLine().charAt(0);
                System.out.println();

                String funktion;

                switch (kalkyl) {
                    case '1': // derivera
                        System.out.println("ange en polynomfunktion (\"s\" för sparade): ");
                        funktion = in.nextLine();

                        // hämta sparad
                        if (funktion.equalsIgnoreCase("s")){
                            for (int i = 0; i < sparadeFunktioner.size(); i++){
                                System.out.printf("[%d] %s", i, sparadeFunktioner.get(i));
                                System.out.println();
                            }
                            int valdFunktion = in.nextInt();
                            funktion = sparadeFunktioner.get(valdFunktion);
                        }

                        System.out.print("antal gånger: ");
                        int antalGånger = in.nextInt(); System.out.println();

                        funktion = derivera(funktion, antalGånger, Verktygslåda.slumpaGemen(2, "dle", false));
                        in.nextLine();
                        sparadeFunktioner = sparaFunktion(funktion, sparadeFunktioner);
                        break;

                    case '2': // antiderivera
                        System.out.println("ange en polynomfunktion (\"s\" för sparade): ");
                        funktion = in.nextLine();

                        // hämta sparad
                        if (funktion.equalsIgnoreCase("s")){
                            for (int i = 0; i < sparadeFunktioner.size(); i++){
                                System.out.printf("[%d] %s", i, sparadeFunktioner.get(i));
                                System.out.println();
                            }
                            int valdFunktion = in.nextInt();
                            funktion = sparadeFunktioner.get(valdFunktion);
                        }

                        funktion = antiDerivera(funktion, Verktygslåda.slumpaGemen(2, "dle", false));
                        in.nextLine();
                        sparadeFunktioner = sparaFunktion(funktion, sparadeFunktioner);
                        break;

                    case '3': // integrera
                        System.out.println("ange en polynomfunktion (\"s\" för sparade): ");
                        funktion = in.nextLine();

                        // hämta sparad
                        if (funktion.equalsIgnoreCase("s")){
                            for (int i = 0; i < sparadeFunktioner.size(); i++){
                                System.out.printf("[%d] %s", i, sparadeFunktioner.get(i));
                                System.out.println();
                            }
                            int valdFunktion = in.nextInt();
                            funktion = sparadeFunktioner.get(valdFunktion);
                        }

                        System.out.print("övre gräns: "); double övreGräns = in.nextDouble();
                        System.out.print("nedre gräns: "); double nedreGräns = in.nextDouble(); System.out.println();

                        integrera(funktion, nedreGräns, övreGräns);
                        break;

                    case '0':
                        System.out.println("avslutar...");
                        fortsätt = false;
                        break;

                    default:
                        System.out.println("ange ett giltigt tecken");
                        break;
                }

            System.out.println("-----------------------------------------\n");

            } while (fortsätt); }
        catch(NumberFormatException | InputMismatchException | IndexOutOfBoundsException error){ System.err.println("vänligen följ reglerna"); }

    }

    private static String derivera(String funktion, int antalGånger, char[] bokstav){

        // om tom
        if (funktion.equals("")){ System.err.println("kan ej derivera en tom sträng"); return ""; }

        double[][] polynom = polynom(funktion);

        // derivera funktion
        for (int a = 0; a < antalGånger; a++) {
            // derivera term
            for (int i = 0; i < polynom.length; i++) {
                polynom[i][0] *= polynom[i][1]; // multiplicera med exponent
                polynom[i][1]--;                // reducera exponent
            }
        }

        return funktionTillSträng(funktion, polynom, antalGånger, bokstav, true);
    }
    private static String antiDerivera(String funktion, char[] bokstav){

        // om tom
        if (funktion.equals("")){ System.err.println("kan ej antiderivera en tom sträng"); return ""; }

        double[][] polynom = polynom(funktion);

        // antiderivera term
        for (int i = 0; i < polynom.length; i++) {
            polynom[i][1]++;                // öka exponent
            polynom[i][0] /= polynom[i][1]; // dividera med exponent
        }

        return funktionTillSträng(funktion, polynom, -1, bokstav, true);
    }
    private static double integrera(String funktion, double nedreGräns, double övreGräns){

        // om tom
        if (funktion.equals("")){ System.err.println("kan ej integrera en tom sträng"); return -1; }

        char[] bokstav = Verktygslåda.slumpaGemen(2, "dle", false);

        // funktion till sträng
        funktion = funktionTillSträng(funktion, polynom(funktion), 0, bokstav, false);

        // antiderivera
        String funktionPrimitiv = antiDerivera(funktion, bokstav);

        // beräkna integral
        double[][] polynomPrimitiv = polynom(funktionPrimitiv);
        double funktionÖvreVärde = 0, funktionNedreVärde = 0;
        for (int i = 0; i < polynomPrimitiv.length; i++){ funktionÖvreVärde += polynomPrimitiv[i][0] * (Math.pow(övreGräns, polynomPrimitiv[i][1])); }
        for (int i = 0; i < polynomPrimitiv.length; i++){ funktionNedreVärde += polynomPrimitiv[i][0] * (Math.pow(nedreGräns, polynomPrimitiv[i][1])); }
        double integral = funktionÖvreVärde - funktionNedreVärde;

        // skriv ut integral
        String övreGränsSträng = Double.toString(övreGräns).replace(".0", "");
        String nedreGränsSträng = Double.toString(nedreGräns).replace(".0", "");

        System.out.printf("%s\n∫(%s)d%c = [%s] = %.2f\n%s\n\n",
                övreGränsSträng, funktion,  bokstav[1], funktionPrimitiv, integral, nedreGränsSträng);
        in.nextLine();

        return integral;
    }


    private static ArrayList<String> sparaFunktion(String funktionAttSpara, ArrayList destination){

        System.out.println("Spara ny funktion? (j/n)");
        char spara = in.nextLine().charAt(0);

        switch (spara){
            case 'j':
                System.out.println("sparar...");
                destination.add(funktionAttSpara);
                break;
            case 'n':
                break;
            default:
                break;
        }
        System.out.println();
        return destination;

    }
    private static String funktionTillSträng(String funktion, double[][] polynom, int antalGånger, char[] bokstav, boolean skrivUt){

        // byt ut variab(ler)el
        funktion = funktion.replaceAll("[a-df-zA-DF-Z]", Character.toString(bokstav[1]));

        if (skrivUt) {
            System.out.printf("%c(%c) = %s\n", bokstav[0], bokstav[1], funktion);
        }

        // termer till strängar
        String[] termEfter = new String[polynom.length];
        for (int i = 0; i < polynom.length; i++){

            // avrunda
            polynom[i] = Verktygslåda.doubleArrayAvrunda(polynom[i], 2);

            String k = polynom[i][0] + "";
            String xe = bokstav[1] + "^" + polynom[i][1];

            // exponentialregler
            if (polynom[i][0] == 0){
                // om k = 0
                k = "_"; xe = ""; // tom
            }
            else {
                // om k = 1
                if (polynom[i][0] == 1) {
                    k = ""; // endast x^e
                }
                // om e = 0
                if (polynom[i][1] == 0) {
                    xe = ""; // endast k
                }
                // om e = 1
                else if (polynom[i][1] == 1) {
                    xe = bokstav[1] + ""; // endast kx
                }
            }

            termEfter[i] = k + xe;
        }

        // deriverad term array till sträng
        String funktionEfter = Arrays.toString(termEfter)
                .replaceAll("[\\[\\]]", "").replace(",", " +").replace(".0", "")
                .replace("+ _", "");

        if (skrivUt) {
            // derivata
            if (antalGånger >= 1) {
                String primtecken = "";
                for (int i = 0; i < antalGånger; i++) { primtecken += "'"; }
                System.out.printf("%c%s(%c) = %s\n\n", bokstav[0], primtecken, bokstav[1], funktionEfter);
            }
            // antiderivata
            else if (antalGånger == -1) {
                System.out.printf("%C(%c) = %s\n\n", bokstav[0], bokstav[1], funktionEfter);
            }
        }

        return funktionEfter;
    }

    private static double[][] polynom(String funktion){

        funktion = funktion.replace(" ", "");

        //try {
            // dela upp i delar
            int antalOperatorer = antalOperatorer(funktion);
            int[] operatorIndex = operatorIndex(funktion, antalOperatorer);
            String[] term = term(funktion, antalOperatorer, operatorIndex);
            int[] varIndex = varIndex(term);
            double[] koefficient = koefficient(term, varIndex);
            int[] caretIndex = caretIndex(term);
            double[] exponent = exponent(term, caretIndex, varIndex);

            // lägg delar i array [term][koefficient/exponent]
            double[][] polynom = new double[term.length][2];
            for (int i = 0; i < term.length; i++){
                polynom[i][0] = koefficient[i];
                polynom[i][1] = exponent[i];
            }
            return polynom;
        /*}
        catch(NumberFormatException error){
            System.err.println("vänligen följ reglerna");
        }

        return new double[0][0];*/
    }
    private static int antalOperatorer(String funktion){

        int antalOperatorer = 0;
        for (int i = 0; i < funktion.length(); i++){
            if (funktion.charAt(i) == '+' || funktion.charAt(i) == '-'){ antalOperatorer++; }
        }
        return antalOperatorer;
    }
    private static int[] operatorIndex(String funktion, int antalOperatorer){

        int[] operatorIndex = new int[antalOperatorer];
        int operatorNummer = 0;
        for (int i = 0; i < funktion.length(); i++){
            if (funktion.charAt(i) == '+' || funktion.charAt(i) == '-'){
                operatorIndex[operatorNummer] = i;
                operatorNummer++;
            }
        }
        return operatorIndex;
    }
    private static String[] term(String funktion, int antalOperatorer, int[] operatorIndex){

        String[] term = new String[antalOperatorer+1];

        // dela upp i termer
        for (int i = 0; i < term.length; i++){

            // om första & sista term
            if (i == 0 && i == term.length-1){
                term[i] = funktion;
            }
            // om första
            else if (i == 0){
                term[i] = funktion.substring(0, operatorIndex[0]);
            }
            // om sista
            else if (i == term.length-1){
                term[i] = funktion.substring(operatorIndex[i-1]+1, funktion.length());
            }
            // om mellan
            else{
                term[i] = funktion.substring(operatorIndex[i-1]+1, operatorIndex[i]);
            }
        }
        return term;
    }
    private static int[] varIndex(String[] term){

        int[] varIndex = new int[term.length];
        for (int i = 0; i < term.length; i++){

            varIndex[i] = -1;
            for (int j = 0; j < term[i].length(); j++){
                // sätt index för bokstav // gemen || VERSAL
                if (term[i].charAt(j) != 'E' && (term[i].charAt(j) >= 97 && term[i].charAt(j) <= 122 || term[i].charAt(j) >= 65 && term[i].charAt(j) <= 90)){
                    varIndex[i] = j;
                }
            }
        }
        return varIndex;
    }
    private static double[] koefficient(String[] term, int[] varIndex){

        double[] koefficient = new double[term.length];
        for (int i = 0; i < term.length; i++){

            // ingen variabel, 8
            if (varIndex[i] == -1){
                koefficient[i] = Double.valueOf(term[i]);
            }
            // ingen koefficient, x^2
            else if (term[i].charAt(0) == term[i].charAt(varIndex[i])){
                koefficient[i] = 1;
            }
            // med variabel & koefficient, 8x^2
            else{
                koefficient[i] = Double.valueOf(term[i].substring(0, varIndex[i]));
            }
        }
        return koefficient;
    }
    private static int[] caretIndex(String[] term){

        int[] caretIndex = new int[term.length];
        // gå igenom varje term
        for (int i = 0; i < term.length; i++){
            // gå igenom varje tecken
            for (int j = 0; j < term[i].length(); j++){
                if (term[i].charAt(j) == '^'){
                    caretIndex[i] = j;
                }
            }
        }
        return caretIndex;
    }
    private static double[] exponent(String[] term, int[] caretIndex, int[] varIndex){

        double[] exponent = new double[term.length];
        for (int i = 0; i < term.length; i++){

            // om exponent, x^2
            if (caretIndex[i] != 0){
                exponent[i] = Double.valueOf( term[i].substring(caretIndex[i]+1) );
            }
            // om ingen variabel, 8
            else if (varIndex[i] == -1){
                exponent[i] = 0;
            }
            // om ingen exponent, 8x
            else{
                exponent[i] = 1;
            }
        }

        return exponent;
    }

}

// avrunda??
// operator i term
// om -2 i funktiontillsträng
// negativ exponent - paranteser



































