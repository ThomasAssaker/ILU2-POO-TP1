package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;

class ControlLibererEtalTest {

    @Test
    void testLibererEtal() {
        // Cr�ation du village
        Village village = new Village("NomDuVillage", 10, 5);
        
        // Cr�ation d'un Gaulois avec une force quelconque, par exemple 10
        Gaulois gaulois = new Gaulois("Asterix", 10);
        
        // Installation du vendeur � l'�tal
        village.installerVendeur(gaulois, "Potion magique", 10);
        
        // R�cup�ration de l'�tal du vendeur
        Etal etal = village.rechercherEtal(gaulois);
        
        // V�rification que l'�tal est bien occup�
        assertTrue(etal.isEtalOccupe());
        
        // Lib�ration de l'�tal par le vendeur
        village.partirVendeur(gaulois);
        
        // V�rification que l'�tal est maintenant libre
        assertFalse(etal.isEtalOccupe());
    }
}
