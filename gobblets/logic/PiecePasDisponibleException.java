package gobblets.logic;

import gobblets.ihm.Erreur;

public class PiecePasDisponibleException extends Exception {
	private static final long serialVersionUID = 6866389184971641914L;
	private Erreur erreur;
	public PiecePasDisponibleException() {
		erreur=Erreur.PASDEPIECEDISPONIBLE;
	}
	public PiecePasDisponibleException(String msg) {
		erreur=Erreur.PASDEPIECEDISPONIBLE;
	}
	public PiecePasDisponibleException(Throwable twb) {
		erreur=Erreur.PASDEPIECEDISPONIBLE;
	}
	public PiecePasDisponibleException(String msg, Throwable twb) {
		erreur=Erreur.PASDEPIECEDISPONIBLE;
	}
	public PiecePasDisponibleException(String msg, Throwable twb, boolean bool1, boolean bool2) {
		erreur=Erreur.PASDEPIECEDISPONIBLE;
	}
	public PiecePasDisponibleException(Erreur erreur) {
		this.erreur=erreur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Erreur getErreur(){
		return erreur;
	}
}
