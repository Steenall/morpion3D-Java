package gobblets.data;

import java.util.ArrayList;
import gobblets.logic.PiecePasDisponibleException;

public class Plateau implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3600604821107355756L;
	private ArrayList<Piece> maisonJoueur1;
	private ArrayList<Piece> maisonJoueur2;
	private Case[][] plateau;
	private Plateau(){
		maisonJoueur1=new ArrayList<Piece>();
		maisonJoueur2=new ArrayList<Piece>();
		plateau=new Case[3][3];
	}
	public static Plateau initPlateau() {
		Plateau temp=new Plateau();
		for(int i=0;i<2;i++) {
			temp.getMaisonJoueur1().add(new Piece(Taille.PETITE));
			temp.getMaisonJoueur2().add(new Piece(Taille.PETITE));
		}
		for(int i=0;i<2;i++) {
			temp.getMaisonJoueur1().add(new Piece(Taille.MOYENNE));
			temp.getMaisonJoueur2().add(new Piece(Taille.MOYENNE));
		}
		for(int i=0;i<2;i++) {
			temp.getMaisonJoueur1().add(new Piece(Taille.GRANDE));
			temp.getMaisonJoueur2().add(new Piece(Taille.GRANDE));
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				temp.getPlateau()[i][j]=new Case();
			}
		}
		return temp;
	}
	public Case[][] getPlateau(){
		return plateau;
	}
	private Case[] getLigne(int ligne) {
		if(ligne<0||ligne>2)return null;
		return plateau[ligne];
	}
	private Case[] getColonne(int colonne) {
		if(colonne<0||colonne>2)return null;
		Case temp[]= {plateau[0][colonne],plateau[1][colonne],plateau[2][colonne],};
		return temp;
	}
	private Case[] getDiagonalePrincipale() {
		Case temp[]= {plateau[0][0],plateau[1][1],plateau[2][2]};
		return temp;
	}
	private Case[] getDiagonaleSecondaire() {
		Case temp[]= {plateau[0][2],plateau[1][1],plateau[2][0]};
		return temp;
	}
	public ArrayList<Piece> getMaisonJoueur1() {
		return maisonJoueur1;
	}
	public ArrayList<Piece> getMaisonJoueur2() {
		return maisonJoueur2;
	}
	public void placePiece(Piece unePiece, int ligne, int colonne) {
		if(unePiece==null||ligne<0||ligne>2||colonne<0||colonne>2)return;
		plateau[ligne][colonne].placePiece(unePiece);
	}
	public Piece enlevePiece(int ligne,int colonne) throws PiecePasDisponibleException {
		if(ligne<0||ligne>2||colonne<0||colonne>2)return null;
		return plateau[ligne][colonne].enlevePiece();
	}
	public Piece plusGrandePiece(int ligne, int colonne) throws PiecePasDisponibleException {
		if(ligne<0||ligne>2||colonne<0||colonne>2)return null;
		return plateau[ligne][colonne].plusGrandePiece();		
	}
	public Couleur verifierLigne(int ligne) {
		if(ligne<0||ligne>2)return null;
		Case[] temp=getLigne(ligne);
		try {
			if(temp[0].plusGrandePiece().getCouleurPiece().equals(temp[1].plusGrandePiece().getCouleurPiece())&&
					temp[0].plusGrandePiece().getCouleurPiece().equals(temp[2].plusGrandePiece().getCouleurPiece())) {
				return temp[0].plusGrandePiece().getCouleurPiece();
			}
			else{
				return null;
			}
		}catch(PiecePasDisponibleException e) {
			return null;
		}
		
	}
	public Couleur verifierColonne(int colonne) {
		if(colonne<0||colonne>2)return null;
		try {
			Case[] temp=getColonne(colonne);
			if(temp[0].plusGrandePiece().getCouleurPiece().equals(temp[1].plusGrandePiece().getCouleurPiece())&&
					temp[0].plusGrandePiece().getCouleurPiece().equals(temp[2].plusGrandePiece().getCouleurPiece())) {
				return temp[0].plusGrandePiece().getCouleurPiece();
			}
			else{
				return null;
			}
		}catch(PiecePasDisponibleException e) {
			return null;
		}
	}
	public Couleur verifierDiagonale(char uneDiagonale) {
		try {
			Case[] temp;
			if(uneDiagonale=='P')temp=getDiagonalePrincipale();
			else if(uneDiagonale=='S')temp=getDiagonaleSecondaire();
			else return null;
			if(temp[0].plusGrandePiece().getCouleurPiece().equals(temp[1].plusGrandePiece().getCouleurPiece())&&
					temp[0].plusGrandePiece().getCouleurPiece().equals(temp[2].plusGrandePiece().getCouleurPiece())) {
				return temp[0].plusGrandePiece().getCouleurPiece();
			}
			else return null;
		}catch(PiecePasDisponibleException e) {
			return null;
		}
	}
}
