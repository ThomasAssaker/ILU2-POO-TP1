package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		Etal[] marche = new Etal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson;
		
		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 8);
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);
		
		for(int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etatEtal());
		}
		
		int nbSangliers = 0;
		int nbSouhaite = 3;
		double prixPaye = 0;
		int quantiteDispo = 0;
		StringBuilder affichage = new StringBuilder();
		
		for(int i = 0; i < marche.length && nbSangliers != nbSouhaite; i++) {
			quantiteDispo = marche[i].contientProduit("sanglier", nbSouhaite - nbSangliers);
			prixPaye += marche[i].acheterProduit(quantiteDispo);
			nbSangliers += quantiteDispo;
			affichage.append("À l'étal ");
			affichage.append(i);
			affichage.append(" je paye ");
			affichage.append(prixPaye);
			affichage.append(" sous.\n");
			prixPaye = 0;
		}
		affichage.append("Je voulais ");
		affichage.append(nbSouhaite);
		affichage.append(" sangliers, j'en ai acheté ");
		affichage.append(nbSangliers);
		affichage.append(".\n");
		System.out.println(affichage.toString());
		
		for(int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etatEtal());
		}
		
	}
	
}
