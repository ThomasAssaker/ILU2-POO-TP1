package frontiere;

import personnages.Gaulois;
import java.util.Scanner;
import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenu villageois"+ nomVisiteur + "Quelle est votre force ?");
					Scanner sc=new Scanner(System.in);
					int force = sc.nextInt();
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					new Gaulois("Blablacar", force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
	    System.out.println("Bienvenu, druide " + nomVisiteur + ". Veuillez entrer les informations nécessaires.");

	    Scanner sc = new Scanner(System.in);

	    System.out.print("Entrez la force du druide : ");
	    int forceDruide = sc.nextInt();

	    System.out.print("Entrez l'effet minimum de la potion : ");
	    int effetMinPotion = sc.nextInt();

	    System.out.print("Entrez l'effet maximum de la potion : ");
	    int effetMaxPotion = sc.nextInt();

	    controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetMinPotion, effetMaxPotion);

	    System.out.println("Bienvenue, druide " + nomVisiteur + "! Vous avez emménagé dans le village.");
	    
	}
	}

