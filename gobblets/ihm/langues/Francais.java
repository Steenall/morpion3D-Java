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

public class Francais implements Dictionnaire {
	private HashMap<Couleur,String> couleurs;
	private HashMap<Taille,String> tailles;
	private HashMap<Etat,String> etats;
	private HashMap<ActionType,String> actions;
	private HashMap<Erreur,String> erreurs;
	private HashMap<Avertissement,String> avertissements;
	private HashMap<Menu,String> menu;
	private HashMap<OtherText,String> other;
	public Francais() {
		couleurs=new HashMap<Couleur,String>();
		tailles=new HashMap<Taille,String>();
		etats=new HashMap<Etat,String>();
		actions=new HashMap<ActionType,String>();
		erreurs=new HashMap<Erreur,String>();
		avertissements=new HashMap<Avertissement,String>();
		menu=new HashMap<Menu,String>();
		other=new HashMap<OtherText,String>();
		couleurs.put(Couleur.BLEU,"Bleu");
		couleurs.put(Couleur.JAUNE,"Jaune");
		couleurs.put(Couleur.ROUGE,"Rouge");
		couleurs.put(Couleur.VERT,"Vert");
		couleurs.put(Couleur.WHITE,"Blanc");
		couleurs.put(Couleur.MAGENTA,"Magenta");
		couleurs.put(Couleur.CYAN,"Cyan");
		tailles.put(Taille.GRANDE, "Grande");
		tailles.put(Taille.MOYENNE, "Moyenne");
		tailles.put(Taille.PETITE, "Petite");
		etats.put(Etat.JEUENCOURS, "Jeu en cours");
		etats.put(Etat.JEUQUITTE, "Jeu quitté");
		etats.put(Etat.JOUEUR1GAGNE, "Le joueur 1 a gagné");
		etats.put(Etat.JOUEUR2GAGNE, "Le joueur 2 a gagné");
		etats.put(Etat.MATCHNUL, "Match nul");
		actions.put(ActionType.DEPLACER, "Déplacer");
		actions.put(ActionType.PLACER, "Placer");
		actions.put(ActionType.QUITTER, "Quitter");
		erreurs.put(Erreur.ARGUMENTINCORRECT, "Argument incorrect");
		erreurs.put(Erreur.CASEBLOQUEE, "Case bloquée");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "Diagonale incorrecte");
		erreurs.put(Erreur.ORIGINEVIDE, "Case d'origine vide");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Aucune pièce disponible");
		erreurs.put(Erreur.PASDEPIECEICI, "Aucune pièce ici");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "Cette taille n'est pas disponible");
		erreurs.put(Erreur.PASTAPIECE, "Ce n'est pas ta pièce");
		erreurs.put(Erreur.NOMINVALIDE, "Veuillez rentrez un nom valide et qui n'est pas déjà utilisé");
		erreurs.put(Erreur.COULEURINVALIDE, "Veuillez choisir une couleur valide qui n'est pas déjà utilisée");
		erreurs.put(Erreur.INCONNU, "Erreur inconnu");
		erreurs.put(Erreur.SAVE, "Impossible d'enregistrer");
		avertissements.put(Avertissement.CHOIXACTION, "Voulez vous placer (P) ou déplacer (D) une pièce ? (M pour accéder au menu) ");
		avertissements.put(Avertissement.CHOIXDESTINATION, "Veuillez choisir la destination");
		avertissements.put(Avertissement.CHOIXORIGIN, "Veuillez choisir l'origine");
		avertissements.put(Avertissement.CHOIXTAILLE, "Veuillez choisir une taille");
		avertissements.put(Avertissement.COULEURJOUEUR, "Choisissez votre couleur");
		avertissements.put(Avertissement.NOMJOUEUR, "Entrez votre nom joueur ");
		avertissements.put(Avertissement.TONTOUR, "C'est à ton tour ");
		menu.put(Menu.MENU_AIDE, "Aide");
		menu.put(Menu.MENU_APROPOS, "A propos");
		menu.put(Menu.MENU_ENREGISTRER, "Enregistrer");
		menu.put(Menu.MENU_FICHIER, "Fichier");
		menu.put(Menu.MENU_LANGUE, "Langue");
		menu.put(Menu.MENU_NOUVEAU, "Nouveau");
		menu.put(Menu.MENU_OUVRIR, "Ouvrir");
		menu.put(Menu.MENU_QUITTER, "Quitter");
		menu.put(Menu.MENU_REPRENDRE, "Reprendre");
		other.put(OtherText.Congratulation, "Félications ");
		other.put(OtherText.Jouer, "A toi de joueur joueur ");
		other.put(OtherText.Contenu, "Contenu des maisons :");
		other.put(OtherText.NbJoueurNonIA, "Combien de joueurs (réels) vont jouer ? ");
		other.put(OtherText.Random, "Le hasard a décidé que le joueur qui commence sera ");
		other.put(OtherText.MaisonJoueur1, "Maison joueur 1 :");
		other.put(OtherText.MaisonJoueur2, "Maison joueur 2 :");
		other.put(OtherText.MatchNul, "Match nul, personne n'a gagné");
		other.put(OtherText.Ligne, "Ligne");
		other.put(OtherText.Colonne, "Colonne");
		other.put(OtherText.Save, "Fichier de sauvegarde créé");
		other.put(OtherText.Reprendre, "Une partie est en cours, voulez-vous la reprendre ? (y : oui, n : non) ");
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
