package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import villagegaulois.Village;
import personnages.Gaulois;
import personnages.Chef; // Ajout de l'import pour la classe Chef

class ControlVerifierIdentiteTest {

    private ControlVerifierIdentite controlVerifierIdentite;
    private Village villageMock;

    @BeforeEach
    void setUp() {
        villageMock = new Village("NomDuVillage", 10, 5); // Crée un village avec un maximum de 10 habitants et 5 étals
        // Ajout d'un chef au village
        Chef chef = new Chef("Abraracourcix", 20, villageMock);
        villageMock.setChef(chef);
        controlVerifierIdentite = new ControlVerifierIdentite(villageMock);
    }

    @Test
    void testVerifierIdentite_VendeurExiste() {
        // Arrange
        String nomVendeur = "Asterix";
        // Ajoute un Gaulois vendeur au village
        villageMock.ajouterHabitant(new Gaulois(nomVendeur, 10));

        // Act
        boolean identiteValide = controlVerifierIdentite.verifierIdentite(nomVendeur);

        // Assert
        assertTrue(identiteValide);
    }

    @Test
    void testVerifierIdentite_VendeurInexistant() {
        // Arrange
        String nomVendeur = "Obelix";

        // Act
        boolean identiteValide = controlVerifierIdentite.verifierIdentite(nomVendeur);

        // Assert
        assertFalse(identiteValide);
    }
}
