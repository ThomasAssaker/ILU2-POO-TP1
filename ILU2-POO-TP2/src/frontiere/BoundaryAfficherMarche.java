package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
    private ControlAfficherMarche controlAfficherMarche;

    public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
        this.controlAfficherMarche = controlAfficherMarche;
    }

    public void afficherMarche(String nomAcheteur) {
        String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
        if (infosMarche.length == 0) {
            System.out.println("Le marché est vide, revenez plus tard.");
        } else {
            StringBuilder result = new StringBuilder();
            result.append(nomAcheteur);
            result.append(", vous trouverez au marché :\n");
            for (int i = 0; i < infosMarche.length; i += 3) {
                result.append("- ").append(infosMarche[i]);
                result.append(" qui vend ").append(infosMarche[i + 1]);
                result.append(" ").append(infosMarche[i + 2]).append("\n");
            }
            System.out.println(result.toString());
        }
    }
}
