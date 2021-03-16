package KapitelX_Enhetstester;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// ctrl + shift + T i klass för att skapa klassTest
// skapa i Junit 5.2
// om rött, alt + enter för att importera

class GeometriTest {

    @Test
    void skickaIn0SkaGe0(){
        // om vi skickar in sidan 0 ska mantelarean vara 0

        // Given = Givet
        // Givet att vi har en instans av klassen
        Geometri minKlassSomSkaTestas = new Geometri();

        // When = När
        // Näär vi anropar vår mantelarea-metod med sidan 0
        double mantelarea = minKlassSomSkaTestas.mantelareaKub(0);

        // Then = Då
        // Då ska manteln vara 0
        Assertions.assertEquals(0, mantelarea);

    }
    @Test
    void skickaIn1SkaGe6(){
        // Given
        Geometri minKlassSomSkaTestas = new Geometri();

        // When
        double mantelarea = minKlassSomSkaTestas.mantelareaKub(1);

        // Then
        Assertions.assertEquals(6, mantelarea);

    }
    @Test
    void skickaIn2SkaGe24(){

        Geometri minKlassSomSkaTestas = new Geometri();
        double mantelarea = minKlassSomSkaTestas.mantelareaKub(2);
        Assertions.assertEquals(24, mantelarea);

    }
    @Test
    void skickaInXSkaY(){

        Geometri minKlassSomSkaTestas = new Geometri();
        for (long i = 1; i <= 20000; i++){

            double mantelarea = minKlassSomSkaTestas.mantelareaKub(i);
            Assertions.assertEquals(i*i*6, mantelarea);
            System.out.println(i);

        }


    }

}









































