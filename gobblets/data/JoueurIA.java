package gobblets.data;

import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class JoueurIA extends Joueur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4465824186026219572L;

	public JoueurIA(String nom, Couleur coul) {
		super(nom, coul);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action choisirAction(Plateau plat) {
		// TODO Auto-generated method stub
		Action uneAction;
		int typeAction;
		boolean end=false;
		do {
			typeAction = 0 + (int)(Math.random() * ((2 - 0)));
			if(getPieces().size()==6||(typeAction<1&&!(getPieces().isEmpty()))) {
				Taille uneTaille;
				int taille = 0 + (int)(Math.random() * ((3 - 0)));
				switch (taille) {
					case 0: 
						uneTaille= Taille.PETITE;
						break;
					case 1: 
						uneTaille= Taille.MOYENNE;
						break;
					case 2:
						uneTaille= Taille.GRANDE;
						break;
					default :
						uneTaille= Taille.GRANDE;
						break;
				}
				int coordLigne = 0 + (int)(Math.random() * ((3 - 0)));
				int coordColonne = 0 + (int)(Math.random() * ((3 - 0)));
				uneAction = new Placement(uneTaille,plat.getPlateau()[coordLigne][coordColonne]);
			}else {
				int coordLigne = 0 + (int)(Math.random() * ((3 - 0)));
				int coordColonne = 0 + (int)(Math.random() * ((3 - 0)));
				int coordLigne2 = 0 + (int)(Math.random() * ((3 - 0)));
				int coordColonne2 = 0 + (int)(Math.random() * ((3 - 0)));
				uneAction = new Deplacement(plat.getPlateau()[coordLigne][coordColonne],plat.getPlateau()[coordLigne2][coordColonne2]);
			}
			try {
				if((uneAction.verifier(this))) {
					end=true;
				}
			} catch (CaseBloqueeException e) {
			} catch (PiecePasDisponibleException e) {
			}
		}while(!end);
		return uneAction;
	}
	public String toString() {
		return super.toString()+"Il s'agit d'un joueur controllés par une IA";
	}

}
