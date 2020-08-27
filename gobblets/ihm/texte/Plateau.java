package gobblets.ihm.texte;

public class Plateau {
	private gobblets.data.Plateau plateau;
	private Case[][] plateauAffichable;
	public Plateau(gobblets.data.Plateau plateau) {
		this.plateau=plateau;
		plateauAffichable =new Case[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				plateauAffichable[i][j]= new Case(this.plateau.getPlateau()[i][j]);
			}
		}
	}
	public String[][] getRepresentationTextuelle() {
		String[][] temp = new String[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				temp[i][j]=plateauAffichable[i][j].getRepresentationTextuelle();
			}
		}
		return temp;
	}
	public String[] getMaison(int joueur) {
		String[] temp;
		if(joueur==1) {
			int max=plateau.getMaisonJoueur1().size();
			temp = new String[max];
			for(int i=0;i<max;i++) {
				temp[i] = plateau.getMaisonJoueur1().get(i).getCouleurPiece().getCode()+String.valueOf(plateau.getMaisonJoueur1().get(i).getTaillePiece().getSymbole());
			}
		}else {
			int max=plateau.getMaisonJoueur2().size();
			temp = new String[max];
			for(int i=0;i<max;i++) {
				temp[i] = plateau.getMaisonJoueur2().get(i).getCouleurPiece().getCode()+String.valueOf(plateau.getMaisonJoueur2().get(i).getTaillePiece().getSymbole());
			}
		}
		return temp;
	}
}
