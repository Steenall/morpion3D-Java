package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Termination extends Action{
	public Termination(){
		
	}
	@Override
	public boolean verifier(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		return true;
		// TODO Auto-generated method stub
	}

	@Override
	public void appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		// TODO Auto-generated method stub
		
	}
}
