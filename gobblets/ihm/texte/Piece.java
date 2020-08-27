package gobblets.ihm.texte;

import gobblets.data.Couleur;

public class Piece {
	protected gobblets.data.Piece contenu;

	public Piece(gobblets.data.Piece contenu) {
		this.contenu = contenu;
	}
	/**
	 * La méthode ne retourne pas de tableaux de String car ce n'est pas très utile
	 * de séparer la représentation textuelle de la couleur et du symbole de la pièce
	 * @return Une chaine de caractère representant une pièce
	 */
	public String getRepresentationTextuelle() {
		if(contenu==null)return " ";
		return contenu.getCouleurPiece().getCode()+contenu.getTaillePiece().getSymbole()+Couleur.WHITE.getCode();
	}
}
