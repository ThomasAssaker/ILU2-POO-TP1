package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
    private ControlLibererEtal controlLibererEtal;

    public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
        this.controlLibererEtal = controlLibererEtal;
    }

    public void libererEtal(String nomVendeur) {
        boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
        if (!vendeurReconnu) {
            System.out.println("Désolé, vous n'êtes pas inscrit sur notre marché aujourd'hui !");
        } else {
            String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
            boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]); 
            if (etalOccupe) {
                int quantiteVendue = Integer.parseInt(donneesEtal[4]); // Convertir la quantité vendue en entier
                String produit = donneesEtal[2];
                String unite = donneesEtal[3];
                
                StringBuilder result = new StringBuilder();
                result.append("Vous avez vendu ").append(quantiteVendue).append(" ");
                result.append(produit).append(" sur ").append(unite).append(" ").append(produit).append(".\n");
                result.append("Au revoir ").append(nomVendeur).append(", passez une bonne journée !");
                System.out.println(result.toString());
            } else {
                throw new IllegalStateException("L'étal n'est pas occupé");
            }
        }
    }
}
