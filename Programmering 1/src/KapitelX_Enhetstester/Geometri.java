package KapitelX_Enhetstester;

public class Geometri {

    static double mantelareaKub(double sida){
        double mantelarea = 0; // Startvärde
        double sidoArea = sida*sida; // Arean av en sida

        // For-loop som summerar alla sidors areor
        for(int i = 1; i <= 6; i++){
            // Lägger till en sidas area till mantelarean.
            mantelarea += sidoArea;
        }
        return mantelarea;
    }


}
