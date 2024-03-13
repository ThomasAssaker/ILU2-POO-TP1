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
            // Tester avec une quantit� n�gative
            etal.acheterProduit(-2, new Gaulois("Ast�rix", 30));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }

        try {
            // Tester avec un �tal non occup�
            etal.acheterProduit(5, new Gaulois("Ob�lix", 35));
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("IllegalStateException: " + e.getMessage());
        }
    }
}
