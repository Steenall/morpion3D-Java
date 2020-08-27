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

public class Allemand implements Dictionnaire {
	private HashMap<Couleur,String> couleurs;
	private HashMap<Taille,String> tailles;
	private HashMap<Etat,String> etats;
	private HashMap<ActionType,String> actions;
	private HashMap<Erreur,String> erreurs;
	private HashMap<Avertissement,String> avertissements;
	private HashMap<Menu,String> menu;
	private HashMap<OtherText,String> other;
	public Allemand() {
		//Merci à Nathalie C. pour m'avoir aidé avec les traductions
		couleurs=new HashMap<Couleur,String>();
		tailles=new HashMap<Taille,String>();
		etats=new HashMap<Etat,String>();
		actions=new HashMap<ActionType,String>();
		erreurs=new HashMap<Erreur,String>();
		avertissements=new HashMap<Avertissement,String>();
		menu=new HashMap<Menu,String>();
		other=new HashMap<OtherText,String>();
		couleurs.put(Couleur.BLEU,"Blau");
		couleurs.put(Couleur.JAUNE,"Gelb");
		couleurs.put(Couleur.ROUGE,"Rot");
		couleurs.put(Couleur.VERT,"Grün");
		couleurs.put(Couleur.WHITE,"Weiß");
		couleurs.put(Couleur.MAGENTA,"Magenta");
		couleurs.put(Couleur.CYAN,"Cyan");
		tailles.put(Taille.GRANDE, "Groß");
		tailles.put(Taille.MOYENNE, "Durchschnittlich");
		tailles.put(Taille.PETITE, "Klein");
		etats.put(Etat.JEUENCOURS, "laufendes Spiel");
		etats.put(Etat.JEUQUITTE, "Spiel über");
		etats.put(Etat.JOUEUR1GAGNE, "Spieler 1 hat gewonnen");
		etats.put(Etat.JOUEUR2GAGNE, "Spieler 2 hat gewonnen");
		etats.put(Etat.MATCHNUL, "Unentschieden");
		actions.put(ActionType.DEPLACER, "Bewegen");
		actions.put(ActionType.PLACER, "Hinstellen");
		actions.put(ActionType.QUITTER, "Verlassen");
		erreurs.put(Erreur.ARGUMENTINCORRECT, "Falsches Argument");
		erreurs.put(Erreur.CASEBLOQUEE, "Blockierte seld");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "Falsche Diagonale");
		erreurs.put(Erreur.ORIGINEVIDE, "Leeres Startfeld");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Keine verfügbare Figur");
		erreurs.put(Erreur.PASDEPIECEICI, "Hier ist keine Figur");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "Diese Größe ist nicht verfügbar");
		erreurs.put(Erreur.PASTAPIECE, "Es ist nicht deine Figur");
		erreurs.put(Erreur.NOMINVALIDE, "Bitte Geben Sie Einen gültigen Spielernamen an ");
		erreurs.put(Erreur.COULEURINVALIDE, "Bitte Geben Sie Einen gültige Farbe an");
		erreurs.put(Erreur.INCONNU, "Unbekannter Fehler");
		erreurs.put(Erreur.SAVE, "Unmöglich zu retten");
		avertissements.put(Avertissement.CHOIXACTION, "Möchten Sie eine Figur setzen (P) oder umsetzen (D) ? (M : Hauptmenü) ");
		avertissements.put(Avertissement.CHOIXDESTINATION, "Bitte wählen Sie das Zielfeld");
		avertissements.put(Avertissement.CHOIXORIGIN, "Bitte wählen Sie das Startfeld");
		avertissements.put(Avertissement.CHOIXTAILLE, "Bitte wählen Sie eine Größe");
		avertissements.put(Avertissement.COULEURJOUEUR, "Wählen Sie Ihre Farbe");
		avertissements.put(Avertissement.NOMJOUEUR, "Geben Sie Ihren Namen ein ");
		avertissements.put(Avertissement.TONTOUR, "Sie sind daran ");
		menu.put(Menu.MENU_AIDE, "Hilfe");
		menu.put(Menu.MENU_APROPOS, "Über");
		menu.put(Menu.MENU_ENREGISTRER, "Aufzeichnen");
		menu.put(Menu.MENU_FICHIER, "Datei");
		menu.put(Menu.MENU_LANGUE, "Sprache");
		menu.put(Menu.MENU_NOUVEAU, "Neu");
		menu.put(Menu.MENU_OUVRIR, "Öffnen");
		menu.put(Menu.MENU_QUITTER, "Verlassen");
		other.put(OtherText.Congratulation, "Wir gratulieren ");
		other.put(OtherText.Jouer, "Du bist dran");
		other.put(OtherText.Contenu, "Inhalt der Häuser :");
		other.put(OtherText.NbJoueurNonIA, "Wie viel (wirkliche) Spieler spielen mit ? ");
		other.put(OtherText.Random, "Der Zufall hat bestimmt dass der Starspieler Ist ");
		other.put(OtherText.MaisonJoueur1, "Spielerhaus 1 :");
		other.put(OtherText.MaisonJoueur2, "Spielerhaus 2 :");
		other.put(OtherText.MatchNul, "Unentschieden, miemand hat gewonnen");
		other.put(OtherText.Ligne, "Reihe");
		other.put(OtherText.Colonne, "Spalte");
		other.put(OtherText.Save, "Sicherungsdatei erstellt");
		other.put(OtherText.Reprendre, "Ein Spiel ist im Gange. Möchten Sie es fortsetzen ? (y : Ja, n : Nein) ");
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
