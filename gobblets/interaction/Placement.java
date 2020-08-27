package gobblets.interaction;

import gobblets.data.Case;
import gobblets.data.Taille;
import gobblets.ihm.Erreur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;
import gobblets.data.Joueur;

public class Placement extends Action{
	private Case destination;
	private Taille taille;
	public Placement(Taille taille, Case destination) {
		this.taille = taille;
		this.destination = destination;
	}
	public Case getDestination() {
		return destination;
	}
	public Taille getTaille() {
		return taille;
	}
	public boolean verifier(Joueur joueur) throws CaseBloqueeException {
		try {
			return joueur.aPieceDeTaille(taille)&&destination.acceptePiece(taille);
		}catch(CaseBloqueeException e) {
			throw new CaseBloqueeException(Erreur.CASEBLOQUEE);
		}
	}
	public void appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		if(verifier(joueur)) {
			destination.placePiece(joueur.enlevePiece(taille));
		}
	}
	public String toString() {
		return "Case de destination : "+destination.toString()+", taille de la pièce :"+taille.toString();
	}
}
