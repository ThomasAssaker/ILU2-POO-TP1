package histoire;

import personnages.Gaulois;
import villagegaulois.Etal;


public class ScenarioCasDegrade {
    public static void main(String[] args) {
        Etal etal = new Etal();
        try {
            // Tester avec un acheteur null
            etal.acheterProduit(5, null);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }

        try {
            // Tester avec une quantité négative
            etal.acheterProduit(-2, new Gaulois("Astérix", 30));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }

        try {
            // Tester avec un étal non occupé
            etal.acheterProduit(5, new Gaulois("Obélix", 35));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }
    }
}
