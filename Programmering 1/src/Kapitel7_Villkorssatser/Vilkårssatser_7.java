package Kapitel7_Villkorssatser;
import java.util.Scanner;

public class Vilkårssatser_7 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Delkapitel boken
            // IfElse();
            // SwichCase();
            // JämföraSträngar();
            // u1u2u3();
            Uppgifter();
    }

    static void IfElse(){
        // 7.2 Tanka
        System.out.print("hur många liter i tanken? ");
        double etanol = in.nextDouble();
        if (etanol > 10)
            System.out.println("fortsätt köra du bara");
        else{
            System.out.printf(" du bör tanka genast, det kostar %.2f kr per liter och full tank saknar %.2f liter. ", 5.50, 50-etanol);
            System.out.printf("det blir %.2f kr, tack och välkommen åter.", 5.5*(50-etanol));
        }

        // Logiska Operatorer, && ||
        System.out.println("ett tal 0-9 eller 20-29");
        int användarensTal = in.nextInt();
        if(användarensTal >=0 && användarensTal < 10 || användarensTal >=20 && användarensTal < 30){
            System.out.println("korrekt");
        }
        else
            System.out.println("bättre lycka nästa gång");

    } // 7.1, 7.2, 7.3
    static void SwichCase(){
        // fungerar inte för double eller float

        // Miniräkare
        System.out.print("tal 1: ");
        double tal1 = in.nextDouble();
        System.out.print("räknesätt (1=+, 2=-, 3=*, 4=/): ");
        int räknesätt = in.nextInt();
        System.out.print("tal 2: ");
        double tal2 = in.nextDouble();
        switch (räknesätt){
            case 1: // om räknesätt = 1
                System.out.printf("svar: %.1f", tal1+tal2);
                break;
            case 2:
                System.out.printf("svar: %.1f", tal1-tal2);
                break;
            case 3:
                System.out.printf("svar: %.1f", tal1*tal2);
                break;
            case 4:
                System.out.printf("svar: %.1f", tal1/tal2);
                break;
            default:
                System.out.println("ERROR"); }

    } // 7.4
    static void JämföraSträngar(){
        // .compareTo - identiska 0
        // .compareToIgnoreCase - identiska 0
        // .equals - identiska true

        // exempel 7.8 Logga in
        System.out.print("användarnamn: ");
        String användarnamn = in.nextLine();
        System.out.print("lösenord: ");
        String lösenord = in.nextLine();
        if(användarnamn.equalsIgnoreCase("Felix") && lösenord.equals("hemligt"))
            System.out.println("välkommen tillbaka Felix");
        else
            System.out.println("försök igen");

    } // 7.5
    static void u1u2u3 (){
        // 7.9
        System.out.println("j/n?");
        char jaEllerNej = in.nextLine().charAt(0);
        String hej = jaEllerNej == 'j' ? "jajjemen" : "nepp";
        System.out.println(hej);

        // 7.10


    } // 7.6
    static void Uppgifter (){

    } // s100

}
