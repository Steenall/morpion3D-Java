package gobblets.ihm;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.data.ActionType;

public interface Dictionnaire {
	public abstract String couleur(Couleur coul);
	public abstract String taille(Taille uneTaille);
	public abstract String etat(Etat unEtat);
	public abstract String action(ActionType unTypeAction);
	public abstract String erreur(Erreur uneErreur);
	public abstract String avertissement(Avertissement unAvertissement);
	public abstract String menu(Menu choixMenu);
	/**
	 * Cette énumération a été créer pour ajouter du texte qui n'était pas présent dans le diagramme de classe donné
	 * @param autreTexte
	 * @return la traduction d'une Enumération contenu dans OtherText
	 */
	public abstract String other(OtherText autreTexte);
}
