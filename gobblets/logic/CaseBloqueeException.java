package gobblets.logic;

import gobblets.ihm.Erreur;

public class CaseBloqueeException extends Exception{
	private static final long serialVersionUID = 2772183532565171485L;
	private Erreur erreur;
	public CaseBloqueeException() {
		erreur=Erreur.CASEBLOQUEE;
	}
	public CaseBloqueeException(String msg) {
		erreur=Erreur.CASEBLOQUEE;
	}
	public CaseBloqueeException(Throwable twb) {
		erreur=Erreur.CASEBLOQUEE;
	}
	public CaseBloqueeException(String msg, Throwable twb) {
		erreur=Erreur.CASEBLOQUEE;
	}
	public CaseBloqueeException(String msg, Throwable twb, boolean bool1, boolean bool2) {
		erreur=Erreur.CASEBLOQUEE;
	}
	public CaseBloqueeException(Erreur erreur) {
		this.erreur=erreur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Erreur getErreur(){
		return erreur;
	}
}
