package gobblets.ihm.texte;

import gobblets.logic.PiecePasDisponibleException;

public class Case {
	protected gobblets.data.Case destination;
	public Case(gobblets.data.Case destination) {
		this.destination=destination;
	}
	/**
	 * La méthode ne retourne pas de tableaux de String car ce n'est pas très utile
	 * de séparer la représentation textuelle de la couleur et du symbole de la pièce
	 * @return Une chaine de caractère representant une pièce
	 */
	public String getRepresentationTextuelle(){
		try{
			return new Piece(destination.plusGrandePiece()).getRepresentationTextuelle();
			
		}catch (PiecePasDisponibleException e) {
			return " ";
		}
		
	}
}
