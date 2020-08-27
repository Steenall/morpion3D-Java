package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;
import gobblets.ihm.OtherText;

public class Anglais implements Dictionnaire {
	private HashMap<Couleur,String> couleurs;
	private HashMap<Taille,String> tailles;
	private HashMap<Etat,String> etats;
	private HashMap<ActionType,String> actions;
	private HashMap<Erreur,String> erreurs;
	private HashMap<Avertissement,String> avertissements;
	private HashMap<Menu,String> menu;
	private HashMap<OtherText,String> other;
	public Anglais() {
		couleurs=new HashMap<Couleur,String>();
		tailles=new HashMap<Taille,String>();
		etats=new HashMap<Etat,String>();
		actions=new HashMap<ActionType,String>();
		erreurs=new HashMap<Erreur,String>();
		avertissements=new HashMap<Avertissement,String>();
		menu=new HashMap<Menu,String>();
		other=new HashMap<OtherText,String>();
		couleurs.put(Couleur.BLEU,"Blue");
		couleurs.put(Couleur.JAUNE,"White");
		couleurs.put(Couleur.ROUGE,"Red");
		couleurs.put(Couleur.VERT,"Green");
		couleurs.put(Couleur.WHITE,"White");
		couleurs.put(Couleur.MAGENTA,"Magenta");
		couleurs.put(Couleur.CYAN,"Cyan");
		tailles.put(Taille.GRANDE, "Large");
		tailles.put(Taille.MOYENNE, "Medium");
		tailles.put(Taille.PETITE, "Small");
		etats.put(Etat.JEUENCOURS, "Game still running");
		etats.put(Etat.JEUQUITTE, "Game left");
		etats.put(Etat.JOUEUR1GAGNE, "Player one win");
		etats.put(Etat.JOUEUR2GAGNE, "Player two win");
		etats.put(Etat.MATCHNUL, "Draw");
		actions.put(ActionType.DEPLACER, "Move");
		actions.put(ActionType.PLACER, "Place");
		actions.put(ActionType.QUITTER, "Leave");
		erreurs.put(Erreur.ARGUMENTINCORRECT, "Incorrect argument");
		erreurs.put(Erreur.CASEBLOQUEE, "Blocked box");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "Incorrect diagonal");
		erreurs.put(Erreur.ORIGINEVIDE, "Original box empty");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "No pieces available");
		erreurs.put(Erreur.PASDEPIECEICI, "No piece available here");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "This size isn't available");
		erreurs.put(Erreur.PASTAPIECE, "This is not your piece");
		erreurs.put(Erreur.NOMINVALIDE, "Please enter a valid name which isn't used");
		erreurs.put(Erreur.COULEURINVALIDE, "Please choose a correct color number which isn't used");
		erreurs.put(Erreur.INCONNU, "Unknown error");
		erreurs.put(Erreur.SAVE, "Impossible to save");
		avertissements.put(Avertissement.CHOIXACTION, "Do you want to placer (P) or move (D) a piece ? (M to access the main menu) ");
		avertissements.put(Avertissement.CHOIXDESTINATION, "Choose a destination");
		avertissements.put(Avertissement.CHOIXORIGIN, "Choose an origin");
		avertissements.put(Avertissement.CHOIXTAILLE, "Select a size");
		avertissements.put(Avertissement.COULEURJOUEUR, "Choose your color");
		avertissements.put(Avertissement.NOMJOUEUR, "Enter your name player ");
		avertissements.put(Avertissement.TONTOUR, "It's your turn ");
		menu.put(Menu.MENU_AIDE, "Help");
		menu.put(Menu.MENU_APROPOS, "About");
		menu.put(Menu.MENU_ENREGISTRER, "Save");
		menu.put(Menu.MENU_FICHIER, "File");
		menu.put(Menu.MENU_LANGUE, "Language");
		menu.put(Menu.MENU_NOUVEAU, "New");
		menu.put(Menu.MENU_OUVRIR, "Open");
		menu.put(Menu.MENU_QUITTER, "Exit");
		other.put(OtherText.Congratulation, "Congratulation ");
		other.put(OtherText.Jouer, "It's your turn player ");
		other.put(OtherText.Contenu, "Houses content");
		other.put(OtherText.NbJoueurNonIA, "How many (real) player(s) will play ?");
		other.put(OtherText.Random, "Chance has decided that the starting player will be ");
		other.put(OtherText.MaisonJoueur1, "Player 1 House :");
		other.put(OtherText.MaisonJoueur2, "Player 2 House :");
		other.put(OtherText.Ligne, "Line");
		other.put(OtherText.Colonne, "column");
		other.put(OtherText.Save, "Backup file created");
		other.put(OtherText.Reprendre, "A game is still in progress, do you want to resume it ? (y : yes, n : no) ");
	}
	@Override
	public String couleur(Couleur coul) {
		// TODO Auto-generated method stub
		return couleurs.get(coul);
	}

	@Override
	public String taille(Taille uneTaille) {
		// TODO Auto-generated method stub
		return tailles.get(uneTaille);
	}

	@Override
	public String etat(Etat unEtat) {
		// TODO Auto-generated method stub
		return etats.get(unEtat);
	}

	@Override
	public String action(ActionType unTypeAction) {
		// TODO Auto-generated method stub
		return actions.get(unTypeAction);
	}

	@Override
	public String erreur(Erreur uneErreur) {
		// TODO Auto-generated method stub
		return "\033[31m"+erreurs.get(uneErreur)+"\033[39m";
	}

	@Override
	public String avertissement(Avertissement unAvertissement) {
		// TODO Auto-generated method stub
		return avertissements.get(unAvertissement);
	}

	@Override
	public String menu(Menu choixMenu) {
		// TODO Auto-generated method stub
		return menu.get(choixMenu);
	}
	@Override
	public String other(OtherText autreTexte) {
		// TODO Auto-generated method stub
		return other.get(autreTexte);
	}
}
