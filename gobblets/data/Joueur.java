package gobblets.data;

import java.util.ArrayList;
import gobblets.interaction.Action;
import gobblets.logic.PiecePasDisponibleException;

public abstract class Joueur implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8070772192429842232L;
	private final String nom;
	private Couleur coul;
	private ArrayList<Piece> pieces;
	public Joueur(String nom, Couleur coul) {
		this.nom=nom;
		this.coul=coul;
		pieces= new ArrayList<Piece>();
	}
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	public void ajoutePiece(Piece unePiece) {
		pieces.add(unePiece);
	}
	public boolean aPiece(Piece unePiece) {
		return pieces.contains(unePiece);
	}
	public String getNom() {
		return nom;
	}
	public Couleur getCouleur() {
		return coul;
	}
	public abstract Action choisirAction(Plateau plat);
	public Piece enlevePiece(Taille uneTaille) throws PiecePasDisponibleException {
		boolean end = false;
		if(!(aPieceDeTaille(uneTaille))) {
			throw new PiecePasDisponibleException();
		}
		for(int i=0;i<6||end;i++) {
			if(pieces.get(i).getTaillePiece().equals(uneTaille)) {
				return pieces.remove(i);
			}
		}
		throw new PiecePasDisponibleException();
	}
	public boolean aPieceDeTaille(Taille uneTaille) {
		for(Piece i : pieces) {
			if(i.getTaillePiece().equals(uneTaille)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return coul.getCode()+"joueur nommé "+nom+" qui possède "+pieces.size()+" pièce"+Couleur.WHITE.getCode();
	}
}
