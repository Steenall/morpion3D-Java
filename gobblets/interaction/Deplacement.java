package gobblets.interaction;

import gobblets.data.Case;
import gobblets.data.Joueur;
import gobblets.ihm.Erreur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Deplacement extends Action{
	private Case destination;
	private Case origin;
	public Deplacement(Case origin, Case destination) {
		this.origin = origin;
		this.destination = destination;
	}
	public Case getDestination() {
		return destination;
	}
	public Case getOrigin() {
		return origin;
	}
	public boolean verifier(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		try {

			return origin.plusGrandePiece().appartientA(joueur)&&destination.acceptePiece(origin.plusGrandePiece().getTaillePiece());
		}catch(CaseBloqueeException e) {
			throw new CaseBloqueeException(Erreur.CASEBLOQUEE);
		}catch(PiecePasDisponibleException e) {
			try {
				if(!origin.plusGrandePiece().appartientA(joueur)) {
					throw new PiecePasDisponibleException(Erreur.PASTAPIECE);
				}
			}catch(PiecePasDisponibleException f) {
				throw new PiecePasDisponibleException(Erreur.ORIGINEVIDE);
			}
		}
		return false;
	}
	public void appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		if(verifier(joueur)) {
			destination.placePiece(origin.enlevePiece());
		}
	}
	public String toString() {
		return "Case d'origine : "+origin.toString()+", case de destination :"+destination.toString();
	}
}
