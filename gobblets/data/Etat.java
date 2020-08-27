package gobblets.data;

public enum Etat implements java.io.Serializable{
	JOUEUR1GAGNE,
	JOUEUR2GAGNE,
	JEUENCOURS,
	JEUQUITTE,
	MATCHNUL,
	NONCOMMENCER;
	private Etat(){
		
	}
}
