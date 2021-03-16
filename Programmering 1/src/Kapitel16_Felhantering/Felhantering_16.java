package Kapitel16_Felhantering;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Felhantering_16 {
    static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {

        // Exekveringsfel
            divideByZero();
            numberFormat();
            inputMismatch();
            negativeArraySize();

    }

    private static void divideByZero(){
        // prövar om koden kör
        try{
            System.out.print("täljare: "); int täljare = in.nextInt();
            System.out.print("nämnare: "); int nämnare = in.nextInt();
            int kvot = täljare / nämnare;
            System.out.println("intkvot: " + kvot);
        }
        // om det blir exekveringsfel, fånga det här
        catch (ArithmeticException error){
            System.out.println("division med 0 ej tillåtet.");
            // använd kanske System.serr
        }
    }
    private static void numberFormat(){
        try{
            System.out.print("ett TAL tack: "); int tal = Integer.valueOf(in.nextLine());
            System.out.println("tack och lov du gav ett tal");
        }
        catch (NumberFormatException error){
            System.out.println("SNÄLLA skriv ett TAL tack :(");
        }
    }
    private static void inputMismatch(){
        try{
            System.out.print("ett TAL tack: "); int tal = in.nextInt();
            System.out.println("tack och lov du gav ett tal");
        }
        catch (InputMismatchException error){
            System.out.println("SNÄLLA skriv ett TAL tack :(");
        }
    }
    private static void negativeArraySize(){
        try{
            System.out.println("hur lång lista? "); int längd = in.nextInt();
            int[] lista = new int[längd];

        }
        catch (NegativeArraySizeException error){
            System.out.println("man kan inte ha en negativ längd, sådeså. gör om gör rätt.");
        }
    }

}
