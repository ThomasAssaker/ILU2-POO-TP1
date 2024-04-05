package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import villagegaulois.Village;
import personnages.Chef;

class ControlPrendreEtalTest {
 
    private ControlPrendreEtal controlPrendreEtal;
    private Village villageMock;
    private ControlVerifierIdentite controlVerifierIdentiteMock;

    @BeforeEach
    void setUp() {
        villageMock = new Village("NomDuVillage", 10, 5);
        
        // Créer un chef avec un nom valide pour le village
        Chef chef = new Chef("NomDuChef", 10, villageMock);
        villageMock.setChef(chef);
        
        controlVerifierIdentiteMock = new ControlVerifierIdentite(villageMock);
        controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentiteMock, villageMock);
    }

    // Votre premier test reste tel quel

    @Test
    void testPrendreEtal_AjoutEtalAuVillage() {
        // Arrange
        String nomVendeur = "Asterix";
        String nomProduit = "Potion";
        int nbProduit = 10;

        // Act
        controlPrendreEtal.prendreEtal(nomVendeur, nomProduit, nbProduit);

        // Assert
        assertTrue(villageMock.rechercherEtalVide());
    }

    @Test
    void testVerifierIdentite_VendeurValide() {
        // Arrange
        String nomVendeur = "NomDuChef"; // Nom du chef créé dans setUp()

        // Act
        boolean identiteValide = controlPrendreEtal.verifierIdentite(nomVendeur);

        // Assert
        assertTrue(identiteValide);
    }
}
