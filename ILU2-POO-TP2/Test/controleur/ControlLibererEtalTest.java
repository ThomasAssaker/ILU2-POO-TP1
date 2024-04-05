package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;

class ControlLibererEtalTest {

    @Test
    void testLibererEtal() {
        // Création du village
        Village village = new Village("NomDuVillage", 10, 5);
        
        // Création d'un Gaulois avec une force quelconque, par exemple 10
        Gaulois gaulois = new Gaulois("Asterix", 10);
        
        // Installation du vendeur à l'étal
        village.installerVendeur(gaulois, "Potion magique", 10);
        
        // Récupération de l'étal du vendeur
        Etal etal = village.rechercherEtal(gaulois);
        
        // Vérification que l'étal est bien occupé
        assertTrue(etal.isEtalOccupe());
        
        // Libération de l'étal par le vendeur
        village.partirVendeur(gaulois);
        
        // Vérification que l'étal est maintenant libre
        assertFalse(etal.isEtalOccupe());
    }
}
