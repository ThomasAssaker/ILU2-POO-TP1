package produit;

public enum Unite {
	LITRE, GRAMME, KILOGRAMME, CENTILITRE, MILILITRE, PAR_PIECE;
	
	public String getUnit()
	{
		switch(this) {
			case LITRE:
				return "l";
			case GRAMME:
				return "g";
			case KILOGRAMME:
				return "kg";
			case CENTILITRE:
				return "cl";
			case MILILITRE:
				return "ml";
			default:
				return "pièces";
		}
	}
}
