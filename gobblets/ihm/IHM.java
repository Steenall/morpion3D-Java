package gobblets.ihm;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.Plateau;
import gobblets.data.Taille;

public abstract class IHM{
	private static IHM courante;
	private static Dictionnaire language;
	public IHM() {
	}
	public static IHM getIHM() {
		return courante;
	}
	public static void setIHM(IHM courante) {
		IHM.courante = courante;
	}
	/**
	 * Le parametre a été remplacé car cela permet d'avoir une méthode plus rapide (car on utilise des numéros dans choisirLangue())
	 * @param language
	 */
	public static void setLanguage(Dictionnaire language) {
		IHM.language = language;
	}
	public static String couleur(Couleur coul) {
		return language.couleur(coul);
	}
	public static String taille(Taille uneTaille) {
		return language.taille(uneTaille);
	}
	public static String etat(Etat unEtat) {
		return language.etat(unEtat);
	}
	public static String action(ActionType unTypeAction) {
		return language.action(unTypeAction);
	}
	public static String erreur(Erreur uneErreur) {
		return language.erreur(uneErreur);
	}
	public static String avertissement(Avertissement unAvertissement) {
		return language.avertissement(unAvertissement);
	}
	public static String menu(Menu unMenu) {
		return language.menu(unMenu);
	}
	public static String other(OtherText autreTxte) {
		return language.other(autreTxte);
	}
	public abstract void choisirLangue();
	public abstract Joueur saisirJoueur(boolean ordi, int numjoueur);
	public abstract ActionType saisirAction(Joueur unJoueur);
	public abstract Taille saisirTaille();
	public abstract int[] saisirCoordonnees(ActionType unActionType);
	public abstract Menu afficheMenu(Etat etat);
	public abstract void display(Plateau unPlateau, Joueur joueurActif);
	public abstract void finalize();
	/**
	 *Vide ce qui est affiché dans la console
	 */
	public abstract void videConsole();
	/**
	 *Vide la liste des couleurs et des noms bloqués (pour empécher un joueur d'avoir deux fois le même nom/couleur)
	 */
	public abstract void cleanBlocage();
	public abstract void attendre();
	/**
	 * Permet de saisir le nombre de joueurs controllés par l'IA
	 * @return int Le nombre de joueurs controllés par l'IA
	 */
	public abstract int saisirNbJoueurNonIA();
}
