package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{

	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME.getUnit());
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	public String getDescription() {
		StringBuilder result = new StringBuilder();
		result.append("sanglier de ");
		result.append(String.valueOf(poids));
		result.append(" ");
		result.append(unite);
		result.append(" chassé par ");
		result.append(chasseur.getNom());
		result.append(".");
		return result.toString();
	}

	@Override
	public double calculerPrix(double prix) {
		return ((double)poids/1000)*prix;
	}
}
