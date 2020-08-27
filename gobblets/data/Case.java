package gobblets.data;

import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Case implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7830130998865817858L;
	private Piece petite;
	private Piece moyenne;
	private Piece grande;
	public Case() {
		this.petite=null;
		this.moyenne=null;
		this.grande=null;
	}
	public boolean acceptePiece(Taille uneTaille) throws CaseBloqueeException {
		if(grande != null)throw new CaseBloqueeException();
		else if(moyenne!=null&&uneTaille.recouvre(Taille.MOYENNE))return true;
		else if(petite!=null&&uneTaille.recouvre(Taille.PETITE))return true;
		else if(grande==null&&moyenne==null&&petite==null)return true;
		else return false;
	}
	public Piece enlevePiece() throws PiecePasDisponibleException {
		Piece temp;
		if(grande!=null) {
			temp=new Piece(Taille.GRANDE);
			temp.setCouleurPiece(grande.getCouleurPiece());
			grande =null;
			return temp;
		}
		else if(moyenne!=null) {
			temp = new Piece(Taille.MOYENNE);
			temp.setCouleurPiece(moyenne.getCouleurPiece());
			moyenne =null;
			return temp;
		}
		else if(petite!=null) {
			temp = new Piece(Taille.PETITE);
			temp.setCouleurPiece(petite.getCouleurPiece());
			petite =null;
			return temp;
		}
		else {
			throw new PiecePasDisponibleException();
		}
	}
	public void placePiece(Piece unePiece) {
		Taille temp=unePiece.getTaillePiece();
		switch(temp) {
			case GRANDE:
				grande=unePiece;
				break;
			case MOYENNE:
				moyenne=unePiece;
				break;
			case PETITE:
				petite=unePiece;
				break;
		}
	}
	public Piece plusGrandePiece() throws PiecePasDisponibleException {
		if(grande!=null)return grande;
		else if(moyenne!=null)return moyenne;
		else if(petite!=null)return petite;
		else throw new PiecePasDisponibleException();
	}
	public String toString() {
		String msg="Case contenant";
		if(petite!=null)msg+="Petite pièce de couleur "+petite.getCouleurPiece().toString()+"\n";
		if(moyenne!=null)msg+="Moyenne pièce de couleur "+moyenne.getCouleurPiece().toString()+"\n";
		if(grande!=null)msg+="Grande pièce de couleur "+grande.getCouleurPiece().toString()+"\n";
		return msg;
	}
}
