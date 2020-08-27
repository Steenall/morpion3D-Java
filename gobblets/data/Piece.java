package gobblets.data;

public class Piece implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3484297600276313312L;
	private Taille taillePiece;
	private Couleur couleurPiece;
	public Piece(Taille taillePiece){
		this.taillePiece=taillePiece;
	}
	public Taille getTaillePiece() {
		return taillePiece;
	}
	public Couleur getCouleurPiece() {
		return couleurPiece;
	}
	public void setCouleurPiece(Couleur couleurPiece) {
		this.couleurPiece = couleurPiece;
	}
	public boolean appartientA(Joueur j) {
		return couleurPiece.equals(j.getCouleur());
	}
	@Override
	public String toString() {
		return "Pièce de taille "+taillePiece.toString()+" de couleur "+couleurPiece.toString();
	}
}
