package Övrigt;

public class Prototypes {

    public static void main(String[] args) {

        int a = 2;
        int b = 20;
        int σ = 3;
        int μ = 11;
        int[] r = new int[32];

        for (int i = 0; i < 32; i++) {
            r[i] = randomNormal(a, b, μ, σ);
            //System.out.println(r[i]);
        }
        for (int i = a; i <= b; i++){
            int antal = Verktygslåda.intArrayAntal(r, i);
            System.out.println("antal " + i + ":\t" + antal);

        }


    }

    static int randomNormal (int a, int b, int μ, int σ) {

        float min = 0;
        float rand = (float)Math.random();
        float[] p = new float[b-a+1]; // probability
        int result = μ;

        for (int y = a; y <= b; y++){

            // get possibility
            p[y-a] = (float)((1 / (σ * Math.sqrt(2 * Math.PI))) * Math.exp(-(Math.pow(y - μ, 2) / (2 * Math.pow(σ, 2)))));

            // choose int with rand
            if (rand >= min && rand < min + p[y-a]) { result = y; } // körs nästan aldrig
            min += p[y-a];

        }

        return result;
    }



}































