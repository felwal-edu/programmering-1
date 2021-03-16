package Kapitel9_Metoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Metoder_9Test {

    @Test
    void primtal1SkaGeFalse(){

        // Given / skapa instans av klass
        Metoder_9 minKlassSomSkaTestas = new Metoder_9();

        // When / skapa instans av metod
        boolean ärPrimtal = minKlassSomSkaTestas.ärPrimtal(1);

        // Then / kolla vad som förväntades
        Assertions.assertEquals(false, ärPrimtal);

    }
    @Test
    void primtal17SkaGeTrue(){

        Metoder_9 minKlassSomSkaTestas = new Metoder_9();
        boolean ärPrimtal = minKlassSomSkaTestas.ärPrimtal(17);
        Assertions.assertEquals(true, ärPrimtal);

    }
    @Test
    void primtal23SkaGeTrue(){

        Metoder_9 minKlassSomSkaTestas = new Metoder_9();
        boolean ärPrimtal = minKlassSomSkaTestas.ärPrimtal(23);
        Assertions.assertEquals(true, ärPrimtal);

    }



}