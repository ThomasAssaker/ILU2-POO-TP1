package produit;

public class Poisson extends Produit{
	private String date;
	
	public Poisson(String date) {
		super("poisson", Unite.PAR_PIECE.getUnit());
		this.date = date;
	}
	
	public String getDescription() {
		StringBuilder result = new StringBuilder();
		result.append("poisson pêchés ");
		result.append(date);
		result.append(".");
		return result.toString();
	}

	@Override
	public double calculerPrix(double prix) {
		return prix;
	}
}
