package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlTrouverEtalVendeur {
    private Village village;

    public ControlTrouverEtalVendeur(Village village) {
        this.village = village;
    }

    public Etal trouverEtalVendeur(String nomVendeur) {
        Gaulois vendeur = village.trouverHabitant(nomVendeur);

        if (vendeur != null) {
            return village.rechercherEtal(vendeur);
        } else {
            System.out.println("Le vendeur " + nomVendeur + " n'a pas été trouvé dans le village.");
            return null;
        }
    }
}
