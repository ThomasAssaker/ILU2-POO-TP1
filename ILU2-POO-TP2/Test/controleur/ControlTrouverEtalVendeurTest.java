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
        Village village = new Village("NomDuVillage", 10, 5); // Cr�e un village avec un maximum de 10 habitants et 5 �tals
        Gaulois vendeur = new Gaulois("Asterix", 10); // Cr�e un Gaulois vendeur avec une force de 10
        village.ajouterHabitant(vendeur); // Ajoute le Gaulois vendeur au village
        Etal etalAttendu = new Etal(); // Cr�e un nouvel �tal
        village.installerVendeur(vendeur, "Baguette", 5); // Installe le vendeur � l'�tal avec 5 baguettes � vendre

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
        Village village = new Village("NomDuVillage", 10, 5); // Cr�e un village avec un maximum de 10 habitants et 5 �tals

        ControlTrouverEtalVendeur controleur = new ControlTrouverEtalVendeur(village);

        // Act
        Etal etalTrouve = controleur.trouverEtalVendeur("Obelix");

        // Assert
        assertNull(etalTrouve);
    }
}
