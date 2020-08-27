package gobblets.data;

import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.interaction.Termination;

public class JoueurHumain extends Joueur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4402757012168990580L;

	public JoueurHumain(String nom, Couleur coul) {
		super(nom, coul);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action choisirAction(Plateau plat) {
		// TODO Auto-generated method stub
		SaisieConsole sc = new SaisieConsole();
		ActionType choix=sc.saisirAction(this);
		if(choix==ActionType.PLACER) {
			Taille taille = sc.saisirTaille();
			int[] coord=sc.saisirCoordonnees(choix);
			return new Placement(taille, plat.getPlateau()[coord[0]][coord[1]]);
		}
		else if(choix==ActionType.DEPLACER) {
			int[] coord=sc.saisirCoordonnees(choix);
			return new Deplacement(plat.getPlateau()[coord[2]][coord[3]], plat.getPlateau()[coord[0]][coord[1]]);
		}
		else {
			return new Termination();
		}
	}
	public String toString() {
		return super.toString()+"Il s'agit d'un joueur humain";
	}
}
