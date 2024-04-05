package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlTrouverEtalVendeurTest {
    private Village village;

    @BeforeEach
    public void setUp() {
        village = new Village("NomDuVillage", 10, 5); // Création du village
        Chef chef = new Chef("Asterix", 10, village); // Création du chef du village
        village.setChef(chef); // Définition du chef du village
    }

    @Test
    public void testTrouverEtalVendeur_VendeurExiste() {
        // Arrange
        String nomVendeur = "Asterix"; // Le chef du village est le vendeur

        // Act
        Gaulois vendeur = village.trouverHabitant(nomVendeur);

        // Assert
        assertEquals(nomVendeur, vendeur.getNom());
    }

    @Test
    public void testTrouverEtalVendeur_VendeurInexistant() {
        // Arrange
        String nomVendeur = "Obelix"; // Un habitant qui n'existe pas dans le village

        // Act
        Gaulois vendeur = village.trouverHabitant(nomVendeur);

        // Assert
        assertEquals(null, vendeur); // Aucun habitant trouvé, donc renvoie null
    }
}

