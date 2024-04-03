package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import villagegaulois.Village;

class ControlPrendreEtalTest {

    private ControlPrendreEtal controlPrendreEtal;
    private Village villageMock;
    private ControlVerifierIdentite controlVerifierIdentiteMock;

    @BeforeEach
    void setUp() {
        villageMock = new Village("NomDuVillage", 10, 5);
        controlVerifierIdentiteMock = new ControlVerifierIdentite();
        controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentiteMock, villageMock);
    }

    @Test
    void testResteEtals_EtalsDisponibles() {
        // Arrange
        // On suppose que des étals sont disponibles dans le village

        // Act
        boolean resteEtals = controlPrendreEtal.resteEtals();

        // Assert
        assertTrue(resteEtals);
    }

    @Test
    void testPrendreEtal_AjoutEtalAuVillage() {
        // Arrange
        String nomVendeur = "Asterix";
        String nomProduit = "Potion";
        int nbProduit = 10;

        // Act
        controlPrendreEtal.prendreEtal(nomVendeur, nomProduit, nbProduit);

        // Assert
        // Vérifiez si l'étal a bien été ajouté au village en vérifiant son existence
        assertTrue(villageMock.rechercherEtalVide());
    }

    @Test
    void testVerifierIdentite_VendeurValide() {
        // Arrange
        String nomVendeur = "Obelix";

        // Act
        boolean identiteValide = controlPrendreEtal.verifierIdentite(nomVendeur);

        // Assert
        // Pour ce test, nous supposons que le nom du vendeur est valide
        assertTrue(identiteValide);
    }
}
