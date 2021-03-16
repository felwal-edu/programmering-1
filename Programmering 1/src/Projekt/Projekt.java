package Projekt;
import java.util.*;

public class Projekt {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Projektuppgifter Classroom
        //MatteMeny();

        // Problemlösning KTH


    }

    static void MatteMeny() {

        char val = ' ';

        while (val != 'E') {
            System.out.println("[G] Geometri\n[A] Algebra\n[D] Derivator\n[S] Statistik\n[P] Primtal\n[E] Exit\n");
            val = in.nextLine().charAt(0);

            switch (val) {

                case 'G':
                    System.out.println("[V] Volym\n[A] Area");
                    char val2 = in.nextLine().charAt(0);

                    switch (val2) {
                        case 'V':
                            System.out.println("[C] Cylinder\n[S] Sfär\n[R] Rätblock");
                            char val3 = in.nextLine().charAt(0);

                            switch (val3) {
                                case 'C':
                                    break;
                                case 'S':
                                    break;
                                case 'R':
                                    break;
                            }
                            break;
                        case 'A':

                            break;
                    }
                    break;
                case 'A':
                    break;
                case 'D':
                    break;
                case 'S':
                    break;
                case 'P':
                    break;
                case 'E':
                    System.out.println("avslutar...\nvänligen stäng inte av datorn.");
                    break;
                default:
                    System.out.println("vänligen försök igen");
                    break;
            }


        }


    }

    static void menyDefault(){

        boolean fortsätt = true;
        int val = 0;

        do{
            switch (val){

                case 1:
                    break;
                case 0:
                    fortsätt = false;
                    break;
                default:
                    break;
            }


        } while(fortsätt);

    }

}
































