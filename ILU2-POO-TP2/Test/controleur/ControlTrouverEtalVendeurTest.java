package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

class ControlTrouverEtalVendeurTest {

    @Test
    void testTrouverEtalVendeur_VendeurExiste() {
        // Arrange
        Village village = new Village("NomDuVillage", 10, 5); // Crée un village avec un maximum de 10 habitants et 5 étals
        Gaulois vendeur = new Gaulois("Asterix", 10); // Crée un Gaulois vendeur avec une force de 10
        village.ajouterHabitant(vendeur); // Ajoute le Gaulois vendeur au village
        Etal etalAttendu = new Etal(); // Crée un nouvel étal
        village.installerVendeur(vendeur, "Baguette", 5); // Installe le vendeur à l'étal avec 5 baguettes à vendre

        ControlTrouverEtalVendeur controleur = new ControlTrouverEtalVendeur(village);

        // Act
        Etal etalTrouve = controleur.trouverEtalVendeur("Asterix");

        // Assert
        assertNotNull(etalTrouve);
        assertEquals(etalAttendu, etalTrouve);
    }

    @Test
    void testTrouverEtalVendeur_VendeurInexistant() {
        // Arrange
        Village village = new Village("NomDuVillage", 10, 5); // Crée un village avec un maximum de 10 habitants et 5 étals

        ControlTrouverEtalVendeur controleur = new ControlTrouverEtalVendeur(village);

        // Act
        Etal etalTrouve = controleur.trouverEtalVendeur("Obelix");

        // Assert
        assertNull(etalTrouve);
    }
}
