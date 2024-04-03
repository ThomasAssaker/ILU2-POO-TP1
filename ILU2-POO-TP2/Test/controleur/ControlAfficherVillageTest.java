package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import villagegaulois.Village;

class ControlAfficherVillageTest {

    private ControlAfficherVillage controlAfficherVillage;
    private Village villageMock;

    @BeforeEach
    void setUp() {
        villageMock = new Village("NomDuVillage", 10, 5); // Cr�e un village avec un maximum de 10 habitants et 5 �tals
        controlAfficherVillage = new ControlAfficherVillage(villageMock);
    }

    @Test
    void testDonnerNomsVillageois() {
        // Arrange
        // Supposons que le village contienne des villageois avec les noms suivants
        String[] nomsAttendus = {"Asterix", "Obelix", "Id�fix"};

        // Act
        String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();

        // Assert
        assertArrayEquals(nomsAttendus, nomsVillageois);
    }

    @Test
    void testDonnerNomVillage() {
        // Arrange
        String nomAttendu = "NomDuVillage"; // Le nom du village tel que d�fini dans le setUp()

        // Act
        String nomVillage = controlAfficherVillage.donnerNomVillage();

        // Assert
        assertEquals(nomAttendu, nomVillage);
    }

    @Test
    void testDonnerNbEtals() {
        // Arrange
        int nbEtalsAttendu = 5; // Le nombre d'�tals tel que d�fini dans le setUp()

        // Act
        int nbEtals = controlAfficherVillage.donnerNbEtals();

        // Assert
        assertEquals(nbEtalsAttendu, nbEtals);
    }
}
