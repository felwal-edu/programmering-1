package Kapitel2_Variabler;
import java.util.Scanner;

public class Variabler_2 {
    public static void main(String[] args){

        // Delkapitel boken
            // Variabelnamn();
            // Inmatning();
            // Typomvandlingar();
            // Tal();
            // Text();
            // Unicode();
            // Uppgifter();
    }

    public static void Variabelnamn(){

        short s = 12345; // 2 byte = 16 bits
        int i = 2147483647; // 4 byte = 32 bits
        long l = 2147483647; // 8 byte = 64 bits ??
        float f = 326666623423428345023489234843243242341.334f; // 4 byte = 32 bits
        double d = 23423423232323232323232323232323232326666666666663232323232323456.22; // 8 byte = 64 bits
        char e = 'h'; // 2 byte ? 16 bits
        boolean b = 3 < 4 && 6 < 8; // 1 byte = 8 bits (hade egentligen fungerat med 1 bit, men datorn arbetar med 8:or)
        String str = "Hej"; // 2 byte per tecken
        byte t = 127; // 8 bits = värde 256 ?

        final double PI = 3.14; // konstant. skrivs helst med stora tecken
        int minInt; // deklaration
        minInt = 3; // tilldelning
        double g = 8d/6; // måste innehålla d,blir annars int
        //1 byte = 8 bits = 01011010

        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(d);
        System.out.println(f);
        System.out.println(e);
        System.out.println(b);
        System.out.println(str);
        System.out.println(t);
        System.out.println(g);

    } // 2.1
    public static void Inmatning(){
        Scanner input = new Scanner(System.in); // scanner-objektet input skapas. System.in är tangentbordet

        // namnÅlderLängd - exempel 2.2
        System.out.println("namn:");
        String namn = input.nextLine();
        System.out.println("ålder");
        int ålder = input.nextInt();
        System.out.println("längd");
        float längd = input.nextFloat();
        System.out.println(namn + " är " + ålder + " år gammal och " + längd + " m lång.");

        // Kvadraten - övning 2.2
        System.out.println("snälla skriv ett tal nedan.");
        float n = input.nextFloat();
        System.out.println(Math.pow(n, 3));

    } // 2.4
    public static void Typomvandlingar(){
        Scanner input = new Scanner(System.in);

        // Tal til strängar
        double sträcka = 5.9;
        String miltal = Double.toString(sträcka);
        String årtal = Integer.toString(1758);
        String f = Float.toString(4.9f);

        // Strängar till tal
        int heltal = Integer.valueOf(årtal);
        double decimaltal = Double.valueOf("5.9");
        // Int feltal = Integer.valueOf("Micke"); // går inte
        double resultat = decimaltal*2;
        System.out.println(resultat);

        // Nollning - övning 2.3
        System.out.println("ålder pls:");
        int ålder = input.nextInt();
        System.out.println("sist du nollade var du " + ålder/10*10 + " år gammal" );
        int tillNästa = (ålder/10*10+10)-ålder;
        System.out.println("du nollar nästa gång om " + tillNästa);

    } // 2.5
    public static void Tal(){
        Scanner input = new Scanner(System.in);

        // Medelvärden - övning 2.4
        System.out.println("tal 1:");
        int tal1 = input.nextInt();
        System.out.println("tal 2:");
        int tal2 = input.nextInt();
        System.out.println("tal 3:");
        int tal3 = input.nextInt();
        System.out.println((double)(tal1 + tal2 + tal3)/3);

    } // 2.6
    public static void Text(){
        Scanner input = new Scanner(System.in);

        // .charAt(), .length(), .indexOf(), .substring()
        String namn = "Maja Gräddnos";
        String nos = namn.substring(5,10);
        char maj = namn.charAt(2);
        System.out.println(nos);
        System.out.println(maj);
        int längd = namn.length();
        int mellanslag = namn.indexOf(' ');
        String efternamn = namn.substring(mellanslag + 1, längd);
        System.out.println(efternamn);

        // för- och efternamn - övning 2.5 + 2.6
        System.out.println("för- och efternamn:");
        namn = input.nextLine();
        int namnLängd = namn.length();
        char förIn = namn.charAt(0);
        char efterIn = namn.charAt((namn.indexOf(' ')+1));
        System.out.println("initialer: " + förIn + "." + efterIn);
        System.out.println("förnamn: " + namn.substring(0, (namn.indexOf(' '))));
        System.out.println("efternamn: " + namn.substring((namn.indexOf(' ')+1), namnLängd));

    } // 2.7
    public static void Unicode(){
        Scanner input = new Scanner(System.in);

        // tecken till värde
        char c = '?';
        int a = 10 + c; // ? har värdet 63
        System.out.println((char)a); // 73 har värdet I
        char tecken1 = 'A';
        System.out.println(tecken1 +  " har koden "+ (int)tecken1);

        // vilken kod har tecknet? - övning 2.7
        System.out.println("ge mig ett tecken");
        String ord = input.nextLine();
        char tecken = ord.charAt(0);
        System.out.println(tecken + " har koden "+ (int)tecken);

        // liten bokstav? - övning 2.8
        System.out.println("stor bokstav: ");
        String ord1 = input.nextLine();
        char bokstav = ord1.charAt(0);
        int bokstavNummer = (int)bokstav + 32;
        char bokstav2 = (char)bokstavNummer;
        System.out.println("stor bokstav: " + bokstav);
        System.out.println("liten bokstav: " + bokstav2);

    } // 2.8
    public static void Uppgifter(){
        Scanner input = new Scanner(System.in);

        // uppgift 2.6a
        System.out.println("belopp?");
        int belopp = input.nextInt();
        int belopp100 = (belopp+99)/100*100;
        System.out.println("uttag i kr i 100-lappar: "+ belopp100);
        //b
        System.out.println("eller");
        int belopp500 = belopp/500*500;
        belopp100 = (belopp%500+99)/100*100;
        System.out.println("uttag i kr i 500-lappar: "+belopp500);
        System.out.println("uttag i kr i 100-lappar: "+belopp100);
        System.out.println("totalt uttag i kr: "+ (belopp500+belopp100));

        // uppgift 2.4
        System.out.println("ge mig en teckenkod");
        int tal = input.nextInt();
        char tecken = (char)tal;
        System.out.println(tal + " har tecknet "+ "\"" + tecken + "\"");

    } // s41

}