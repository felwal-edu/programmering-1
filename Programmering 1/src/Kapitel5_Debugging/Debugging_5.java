package Kapitel5_Debugging;
import java.util.Scanner;

public class Debugging_5 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Debugging();

    }

    static void Debugging(){
        // markera med rött till vänster för att stanna inom dubugging

        // med variabler
        String[] minLista = new String[3];
        minLista[0] = "hej";
        minLista[1] = "hallå";
        minLista[2] = "tjenamors";
        System.out.printf("%s på dig. %s där. %s äppelmos.", minLista[0], minLista[1], minLista[2]);
        System.out.println();

        // med scanner
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(s);

    }

}
