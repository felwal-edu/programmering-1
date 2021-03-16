package Kapitel14_Samlingar;
import java.util.*;

public class Samlingar_14 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Gemomgångar
            //ArrayList();
            //Stack();
            HashMap();

        // Uppgifter
            betyg();

    }

    static void ArrayList(){

        ArrayList<String> samling = new ArrayList<>();
        samling.add("hej"); // index 0
        samling.add("då"); // index 1
        System.out.println(samling.get(0) + ""  + samling.get(1));

        samling.add(1, "san"); // trycker in mellan index 0 och gamla 1
        System.out.println(samling.get(0) + ""  + samling.get(1));
        System.out.println(samling.get(0) + ""  + samling.get(2));

        // gör om array till arrayList
        List<String> strings = Arrays.asList("hej", "hello", "tjena");

        //strings.stream().forEach(s -> s + "hej");


    }
    static void Stack(){
        // kan bara använda / ta bort / titta på översta
        // lite proccessorkraft

        // push() lägg till
        // pop() ta bort
        // peak() titta

        Stack<String> minStack = new Stack<>();

    }
    static void HashMap(){
        // hashmap är en tabell för en funktion
        // två värden tillsammans
        // parvis kopplad samling
        // saknar ordning
        // f(nyckel) = värde
        // år("Joakim") = 28
        // .put för att lägga till

        HashMap<String, Integer> minHashMap = new HashMap<>();
        minHashMap.put("Joakim", 28);
        minHashMap.put("Nisse", 19);
        int value = minHashMap.get("Joakim"); // hämtar värdet kopplat till Joakim

        // 3D
        HashMap<String, HashMap<String, Integer>> min3DHashMap;


    }

    static void betyg(){

        try{

            boolean enTill = false;
            HashMap<String, Character> ämnenBetyg = new HashMap();
            do {
                System.out.print("vilket ämne? "); String ämne = in.nextLine();
                System.out.print("vilket betyg? "); char betyg = in.nextLine().charAt(0);
                ämnenBetyg.put(ämne, Character.toUpperCase(betyg));

                boolean lyckadJaNej;
                do {
                    System.out.print("en till? (j/n) "); char jaNej = in.nextLine().charAt(0);

                    if (jaNej == 'j') {
                        enTill = true;
                        lyckadJaNej = true;
                    }
                    else if (jaNej == 'n') {
                        enTill = false;
                        lyckadJaNej = true;
                        System.out.println("avslutar...");

                        System.out.println(ämnenBetyg.toString().replace("=", ": ").replace(", ", "\n").replaceAll("[{}]", ""));
                    }
                    else { lyckadJaNej = false; }

                } while (lyckadJaNej == false);

            } while (enTill);

        }
        catch(StringIndexOutOfBoundsException error ){
            System.err.println("vänligen ange minst ett tecken.");
        }


    }

}









