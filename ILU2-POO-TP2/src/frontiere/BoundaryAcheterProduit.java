package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
    private Scanner scan = new Scanner(System.in);
    private ControlAcheterProduit controlAcheterProduit;

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);

        if (!nomAcheteurConnu) {
            System.out.println("Je suis d�sol�e " + nomAcheteur +
                    " mais il faut �tre un habitant de notre village pour acheter ici.");
        } else {
            System.out.println("Quel produit voulez-vous acheter ?");
            String produit = scan.nextLine();
            Gaulois[] vendeurs = controlAcheterProduit.produitExiste(produit);
            if (vendeurs == null) {
                System.out.println("D�sol�, personne ne vend ce produit au march�.");
            } else {
                System.out.println("Chez quel commer�ant voulez-vous acheter des " + produit + " ?");
                System.out.println(controlAcheterProduit.afficherVendeurs(vendeurs));
                int numEtal = Clavier.entrerEntier("Entrez le num�ro du commer�ant : ");
                Gaulois vendeur = controlAcheterProduit.trouverGaulois(vendeurs, numEtal);
                if (vendeur == null) {
                    System.out.println("Ce commer�ant n'existe pas!\n");
                } else {
                    acheterProduit(nomAcheteur, vendeur.getNom(), produit);
                }
            }
        }
    }

    public void acheterProduit(String nomAcheteur, String nomVendeur, String produit) {
        StringBuilder message = new StringBuilder();
        message.append(nomAcheteur).append(" se d�place jusqu'� l'�tal du vendeur ").append(nomVendeur).append("\n");
        message.append("Bonjour ").append(nomAcheteur).append("\n");
        message.append("Combien de ").append(produit).append(" voulez-vous acheter ?");
        int nbAchat = Clavier.entrerEntier(message.toString());
        int nbExist = controlAcheterProduit.acheterProduit(nomVendeur, nbAchat);
        produitExist(nbAchat, nbExist, nomVendeur, nomAcheteur, produit);
    }

    public void produitExist(int nbAchat, int nbExist, String nomVendeur, String nomAcheteur, String produit) {
        String result = nomAcheteur;
        result += " veut acheter " + nbAchat + " " + produit + ", ";
        if (nbExist == 0) {
            result += "malheureusement il n'y en a plus !";
        } else if (nbExist == nbAchat) {
            result += "ach�te " + nbAchat + " " + produit + " � " + nomVendeur;
        } else if (nbExist < nbAchat) {
            result += "malheureusement " + nomVendeur + " n'en a plus que " + nbExist + ". ";
            result += nomAcheteur + " ach�te tout le stock de " + nomVendeur + ".";
        }
        System.out.println(result);
    }
}
