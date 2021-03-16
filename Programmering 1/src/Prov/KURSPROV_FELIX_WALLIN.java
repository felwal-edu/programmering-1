package Prov;
import java.util.*;

public class KURSPROV_FELIX_WALLIN {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        uppgift1();
        uppgift2();
        uppgift3();

    }

    private static void uppgift1(){

        try {

            // skapa lista
            System.out.print("hur många tal vill du ha i din lista? ");
            int antalTal = in.nextInt();
            int[] lista = new int[antalTal];

            // låt användaren lägga in värden
            for (int i = 0; i < lista.length; i++) {
                System.out.print("tal " + (i + 1) + ": ");
                lista[i] = in.nextInt();
            }

            // hämta minsta värde
            int minstaVärde = intArrayMinstaVärde(lista);
            System.out.println("minsta värde: " + minstaVärde + "\n");

        }
        catch(InputMismatchException error){ System.err.println("ange ett heltal"); }
        catch(ArrayIndexOutOfBoundsException error){ System.err.println("listan kan ej innehålla 0 värden"); }
        catch(NegativeArraySizeException error){ System.err.println("listan kan ej ha negativ längd"); }

    }
    private static int intArrayMinstaVärde(int[] lista){

        // beräkna minsta värde
        int minstaVärde = lista[0];
        for (int i = 1; i < lista.length; i++){
            if (lista[i] < minstaVärde) { minstaVärde = lista[i]; }
        }

        return minstaVärde;
    }

    private static void uppgift2(){

        try {

            // mata in sida och höjd
            System.out.println("du bygger en pyramid med en kvadratisk basyta.");
            System.out.print("pyramidens sida (m): "); double sida = in.nextDouble();
            System.out.print("pyramidens höjd (m): "); double höjd = in.nextDouble();
            in.nextLine();

            // beräkna volym
            double volym = volymAvPyramid(sida, höjd);
            System.out.println("pyramidens volym: " + volym + " m3\n");

        }
        catch(InputMismatchException error){ System.err.println("ange ett tal"); }

    }
    private static double volymAvPyramid(double sida, double höjd){

        // använd formeln för volym av en pyramid V = (bh)/3
        double bas = sida * sida;
        double volym = (bas * höjd) / 3;

        return volym;
    }

    private static void uppgift3(){

        int poäng = 0;
        int målPoäng = 20;
        int frågaNr = 1;

        boolean fortsätt = true;

        System.out.printf("mål: %d poäng\nför att ge upp, skriv \"stopp\"\nLÅT SPELEN BÖRJA!\n\n", målPoäng);

        // spelet
        while(fortsätt && poäng < målPoäng) {

            // skapa slumtal mellan -10 och 10
            int slumptalA = (int) (-11 + Math.random() * 22);
            int slumptalB = (int) (-11 + Math.random() * 22);

            // skapa strängar av slumptalen för att kunna omfamna med eventuella paranteser
            String termA;
            String termB;

            // lägg till paranteser om negativa tal
            if (slumptalA < 0)  { termA = "(" + slumptalA + ")"; }
            else                { termA = Integer.toString(slumptalA); }

            if (slumptalB < 0)  { termB = "(" + slumptalB + ")"; }
            else                { termB = Integer.toString(slumptalB); }


            // skapa slumpvalda operator
            int operatorInt = (int) (Math.random() * 3);
            char operator;

            // beräkna facit & konvertera operatorInt till tecken
            int facit;
            switch (operatorInt) {
                case 0:
                    operator = '+';
                    facit = slumptalA + slumptalB;
                    break;
                case 1:
                    operator = '-';
                    facit = slumptalA - slumptalB;
                    break;
                case 2:
                    operator = '*';
                    facit = slumptalA * slumptalB;
                    break;
                default: // om något fel uppstår
                    operator = '?';
                    facit = 0;
                    System.out.println("något blev fel, vi ber om ursäkt för alla olägenheter");
                    break;
            }


            // skriv ut fråga
            System.out.printf("---------\n\nfråga %d:\n%s%c%s\n", frågaNr, termA, operator, termB);

            try{
                // ta emot svar
                int dittSvar;
                String dittSvarString = in.nextLine();
                if (dittSvarString.equalsIgnoreCase("stopp")) { fortsätt = false; break; } // ge upp
                dittSvar = Integer.valueOf(dittSvarString);

                // om rätt svar
                if (dittSvar == facit)  { System.out.println("RÄTT!"); poäng++; }
                // om fel svar
                else                    { System.out.println("FEL! facit: " + facit); poäng--; }

                frågaNr++;
            }
            // vid inmatning av fel tecken
            catch(NumberFormatException error){ System.err.println("vänligen ange ett heltal (tillåtna tecken: 0123456789)"); }


            // skriv ut nuvarande poäng
            System.out.printf("du har nu: %d poäng\n\n", poäng);

        }

        // efterspels-meddelande
        if (poäng >= målPoäng){ System.out.println("-----------------\nGRATTIS! DU VANN!\n-----------------"); }
        else { System.out.println("\ndu ger upp..."); }

    }




}