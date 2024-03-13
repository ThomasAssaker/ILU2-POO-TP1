package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal.EtalNonOccupeException;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtalsMarche) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtalsMarche);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() throws VillageSansChefException {
    if (chef == null) {
        throw new VillageSansChefException("Le village ne peut exister sans chef.");
    }

    StringBuilder chaine = new StringBuilder();
    if (nbVillageois < 1) {
        chaine.append("Il n'y a encore aucun habitant au village du chef "
                + chef.getNom() + ".\n");
    } else {
        chaine.append("Au village du chef " + chef.getNom()
                + " vivent les legendaires gaulois :\n");
        for (int i = 0; i < nbVillageois; i++) {
            chaine.append("- " + villageois[i].getNom() + "\n");
        }
    }
    return chaine.toString();
}

	private static class Marche {
		private Etal[] etals;
		public Marche (int nombreDetals) {
			etals =new Etal[nombreDetals];
			for(int i =0;i<etals.length; i ++) {
				etals[i] = new Etal();
			}
		}
		public void utiliserEtal(int indiceEtal, Gaulois vendeur,String produit, int nbProduit) { 
			if(!etals[indiceEtal].isEtalOccupe()) {
				etals[indiceEtal].occuperEtal(vendeur, produit,nbProduit);
			} else {
				System.out.println("L'etal" + indiceEtal + " est deja occupe par " +etals[indiceEtal].getVendeur().getNom());
		}	
	}
		public int trouverEtalLibre() {
			for (int i=0; i<etals.length; i++) {
				if(!etals[i].isEtalOccupe()) {
					return i;
			}
		}
				return -1;
	}
		public Etal trouverVendeur (Gaulois gaulois) {
			for (int i=0; i<etals.length; i ++ ) {
				Etal etal = etals[i];
				if(etal.isEtalOccupe() && etal.getVendeur() == gaulois) {
					return etal;  
					}
		}
			return null;
		}
		public String afficherMarche () {
			StringBuilder result = new StringBuilder();
			int nbEtalVide = 0;

			for (int i = 0; i < etals.length; i++) {
				Etal etal = etals[i];
				if (etal.isEtalOccupe()) {
					result.append(etal.afficherEtal()).append("\n");
				} else {
					nbEtalVide++;
        }
    }

			if (nbEtalVide > 0) {
				result.append("Il reste ").append(nbEtalVide).append(" etals non utilises dans le marche.\n");
    }

			return result.toString();
			
		}
		public Etal[] getEtals() {
			// TODO Auto-generated method stub
			return etals;
		}
	} 
	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
		int indiceEtalLibre = marche.trouverEtalLibre();
		if (indiceEtalLibre != -1) {
			marche.utiliserEtal(indiceEtalLibre, vendeur, produit, nbProduit);
			return vendeur.getNom() + " vend " + nbProduit + " " + produit + " à l'etal " + indiceEtalLibre + ".";
		} else {
			return "Aucun etal disponible pour installer le vendeur " + vendeur.getNom() + ".";
    }
}
	public String rechercherVendeursProduit(String produit) {
    StringBuilder result = new StringBuilder();
    result.append("Vendeurs de ").append(produit).append(" : ");
    for (Etal etal : marche.getEtals()) {
        if (etal.isEtalOccupe() && etal.contientProduit(produit)) {
            result.append(etal.getVendeur().getNom()).append(", ");
        }
    }
    return result.toString();
}
	public Etal rechercherEtal(Gaulois vendeur) {
		return marche.trouverVendeur(vendeur);
}
	public String partirVendeur(Gaulois vendeur) throws EtalNonOccupeException {
    Etal etal = marche.trouverVendeur(vendeur);
    if (etal != null) {
        etal.libererEtal();
        return vendeur.getNom() + " quitte l etal.";
    } else {
        return vendeur.getNom() + " n'est pas un vendeur dans le marche.";
    }
}
	public String afficherMarche() {
		return marche.afficherMarche();
}

	public class VillageSansChefException extends Exception {
		public VillageSansChefException(String message) {
			super(message);
    }
}
}