package produit;

public abstract class Produit implements IProduit {
	
	private String nom;
	protected String unite;
	
	Produit(String nom, String unite) {
		this.nom = nom;
		this.unite = unite;
	}
	
	@Override
	public String getNom() 
	{
		return nom;
	}
	
	

}
