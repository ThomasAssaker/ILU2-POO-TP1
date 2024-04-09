package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Etal<P extends IProduit> implements IEtal {
    private Gaulois vendeur;
    private P[] produits;
    private int nbProduit;
    private double prix;
    private boolean isEtalOccupe = false;

    public void installerVendeur(Gaulois vendeur, P[] produits, double prix) {
        this.vendeur = vendeur;
        this.produits = produits;
        this.prix = prix;
        this.nbProduit = produits.length;
        this.isEtalOccupe = true;
    }

    @Override
    public Gaulois getVendeur() {
        return vendeur;
    }

    @Override
    public double donnerPrix() {
        return prix;
    }

    @Override
    public int contientProduit(String produit, int quantiteSouhaitee) {
        if (nbProduit > 0 && produits[0].getNom().equals(produit)) {
            return Math.min(nbProduit, quantiteSouhaitee);
        }
        return 0;
    }

    @Override
    public double acheterProduit(int quantiteSouhaitee) {
        int quantiteEffective = Math.min(nbProduit, quantiteSouhaitee);
        double prixPaye = Arrays.stream(produits, 0, quantiteEffective)
                                .mapToDouble(p -> p.calculerPrix(prix))
                                .sum();
        nbProduit -= quantiteEffective;
        return prixPaye;
    }

    @Override
    public String etatEtal() {
        String produitDescriptions = Arrays.stream(produits, 0, nbProduit)
                                            .map(IProduit::getDescription)
                                            .collect(Collectors.joining("\n- ", "\n- ", ""));
        return String.format("%s vend %d produits :%s\n", 
                             vendeur.getNom(), nbProduit, nbProduit > 0 ? produitDescriptions : " n'a plus rien à vendre.");
    }

    public boolean isEtalOccupe() {
        return isEtalOccupe;
    }
}