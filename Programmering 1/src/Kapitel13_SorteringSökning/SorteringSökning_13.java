package Kapitel13_SorteringSökning;
import Övrigt.Verktygslåda;

import java.util.Arrays;
import java.util.Scanner;

public class SorteringSökning_13 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Sortering & Sökning
            // bubbelsortering();
            // sekventiellSökning();
            // binärSökning();

        // Classroom Uppgifter
            // statistikSannolikhet();

        // Extra Uppgifter
            talbaser();

    }

    // Sortering & Sökning
    static void bubbelsortering(){

        System.out.println("Bubbelsortering");
        int[] lista = Verktygslåda.intArraySlumpad(0, 100);
        System.out.println( Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", " ") );
        lista = Verktygslåda.bubbelsortera(lista);

        System.out.println( Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", " ") );

    }
    static void sekventiellSökning() {

        System.out.println("Sekventiell Sökning");
        int[] lista = Verktygslåda.intArraySlumpad(0, 100);
        System.out.println( Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", " ") );

        System.out.println("sök efter: "); int sökvärde = in.nextInt();
        int index = Verktygslåda.sökSekventiellt(lista, sökvärde);

        System.out.println("index: " + index);

    }
    static void binärSökning(){
        // listan måste vara sorterad från början

        System.out.println("Binär Sökning");
        int[] lista = Verktygslåda.intArraySlumpad(0, 100);
        System.out.println( Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", " ") );
        lista = Verktygslåda.bubbelsortera(lista);
        System.out.println( Arrays.toString(lista).replaceAll("\\[|\\]|,|\\s", " ") );

        System.out.println("sök efter: "); int sökvärde = in.nextInt();
        int index = Verktygslåda.sökBinärt(lista, sökvärde);

        System.out.println("index: " + index);
    }

    // Uppgifter Classroom
    static void statistikSannolikhet(){

        int[] lista = Verktygslåda.intArraySlumpad(0, 20);
        lista = Verktygslåda.bubbelsortera(lista);
        System.out.println(Verktygslåda.intArraySträngad(lista));
        //if (lista.length < 2) {}

        // Median
        double median;
        if (lista.length % 2 == 0){
            median = (double)( lista[lista.length/2] + lista[lista.length/2-1] ) / 2; }
        else {
            median = lista[lista.length/2]; }
        System.out.println("median: " + median);


        // Medelvärde
        double summa = 0;
        for (int i = 0; i < lista.length; i++){
            summa += lista[i];
        }
        double medelvärde = summa / lista.length;
        System.out.println("medelvärde: " + medelvärde);


        // Variationsbredd
        int min = lista[0];
        int max = lista[0];
        for (int i = 0; i < lista.length; i++){
            if (lista[i] < min) { min = lista[i]; }
            if (lista[i] > max) { max = lista[i]; }
        }
        int variationsbredd = max-min;
        System.out.println("variationsbredd: " + variationsbredd);


        // Nedre & Övre Kvartil
        double nedreKvartil;
        double övreKvartil;
        int nedreK1 = lista.length/4-1;
        int nedreK2 = lista.length/4;
        int övreK1 = lista.length-nedreK2-1;
        int övreK2 = lista.length-nedreK1-1;

        // om jämnt antal värden ex 6, 8, 10
        if (lista.length % 2 == 0){

            // om jämnt antal värden under medianen
            if ((lista.length/2) % 2 == 0){
                nedreKvartil = (double)( lista[nedreK1] + lista[nedreK2] ) / 2;
                övreKvartil = (double)( lista[övreK1] + lista[övreK2] ) / 2; }
            // om ojämnt antal värden under medianen ex 10
            else {
                nedreKvartil = lista[nedreK2];
                övreKvartil = lista[övreK1];}
        }
        // om ojämnt antal värden
        else{

            // om jämnt antal värden under medianen
            if ((lista.length/2) % 2 == 0){
                nedreKvartil = (double)( lista[nedreK1] + lista[nedreK2] ) / 2;
                övreKvartil = (double)( lista[övreK1] + lista[övreK2] ) / 2;}
            // om ojämnt antal värden under medianen
            else{
                nedreKvartil = lista[nedreK2];
                övreKvartil = lista[övreK1];}
        }
        System.out.println("nedre kvartil: " + nedreKvartil);
        System.out.println("övre kvartil: " + övreKvartil);

        // Kvartilavstånd
        double kvartilavstånd = övreKvartil - nedreKvartil;
        System.out.println("kvartilavstånd: " + kvartilavstånd);


        // Standardavvikelse
        double kvadrans = 0;
        double varians;
        double standardavvikelse;

        for (int i = 0; i < lista.length; i++){
            kvadrans += Math.pow(lista[i]-medelvärde, 2);
        }
        varians = kvadrans / (lista.length-1);
        standardavvikelse = Math.sqrt(varians);
        System.out.println("standardavvikelse: " + standardavvikelse);


        // Typvärde
        int talTemp; int tal = -1; // lista >= 0
        int antalTemp; int antal = 1;
        // räkna antal för varje värde
        for (int i = 0; i < lista.length; i++){
            talTemp = lista[i];
            antalTemp = 0;
            // räkna antal i
            for (int j = 0; j < lista.length; j++){
                if (lista[j] == talTemp) { antalTemp++; }
            }
            if (antalTemp > antal) { antal = antalTemp; tal = talTemp; }
        }
        int typvärde = tal;
        System.out.print("typvärde: ");
        if (tal == -1) { System.out.print("null"); } else { System.out.print(typvärde); }

    }
    static void talbaser(){
        // omvandla mellan baser

        System.out.print("talet "); int tal1 = in.nextInt();
        System.out.print("i talbasen "); int talbas1 = in.nextInt();

        // 42 = 4 ⋅ 10^1 + 2 ⋅ 10^0

        int tal2 = 0;
        String tal2s = "";
        String tal1s = Integer.toString(tal1);

        for (int i = 0; i > tal1s.length(); i++){
            tal2s += tal1s.charAt(i);

        }

        System.out.print("är i talbasen "); int talbas2 = in.nextInt();
        System.out.print(tal2);
    }


} //





























