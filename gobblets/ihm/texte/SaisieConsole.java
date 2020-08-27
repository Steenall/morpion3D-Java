package gobblets.ihm.texte;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.JoueurIA;
import gobblets.data.Plateau;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.ihm.OtherText;
import gobblets.ihm.langues.Allemand;
import gobblets.ihm.langues.Anglais;
import gobblets.ihm.langues.Francais;

public class SaisieConsole extends IHM {
	private static final Scanner sc = new Scanner(System.in);
	/**
	 * ArrayList qui liste les noms qui ne peuvent être utilisé afin d'empécher deux joueurs d'avoir le même nom
	 */
	ArrayList<String> nomBloque;
	/**
	 * ArrayList qui liste les couleurs qui ne peuvent être utilisé afin d'empécher deux joueurs d'avoir la même couleur
	 */
	ArrayList<Integer> couleurBloquee;
	public SaisieConsole() {
		nomBloque=new ArrayList<String>();
		couleurBloquee=new ArrayList<Integer>();
	}
	/**
	 *Permet de supprimer la liste des noms et couleurs bloqués
	 */
	public void cleanBlocage() {
		nomBloque.clear();
		couleurBloquee.clear();
	}
	/**
	 *Permet à l'utilisateur de choisir sa langue
	 */
	public void choisirLangue() {
		boolean end=false;
		do {
			int choix=0;
			do {
				try {
					System.out.println("Choisissez votre langue\n"+"Choose your language\n"+"Wähle deine Sprache\n"+"\nfrench=1, english=2, german=3");
					choix=sc.nextInt();
					if(choix<0||choix>3) {
						System.out.println("Please enter a number between 1 and 3");
					}
				}catch (java.util.InputMismatchException e) {
					System.out.println("Please enter a number");
					sc.nextLine();
				}
			}while(choix<=0||choix>3);
			if(choix==1)setLanguage(new Francais());
			else if(choix==2)setLanguage(new Anglais());
			else setLanguage(new Allemand());
		}while(end);
		videConsole();
	}
	/**
	 * Permet de saisir le nombre de joueurs controllés par l'IA
	 * @return int Le nombre de joueurs controllés par l'IA
	 */
	@Override
	public int saisirNbJoueurNonIA() {
		int choix=0;
		do {
			try {
				System.out.println(other(OtherText.NbJoueurNonIA));
				choix=sc.nextInt();
				if(choix<0||choix>2) {
					System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
				}
			}catch (java.util.InputMismatchException e) {
				System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
				sc.nextLine();
			}
		}while(choix<0||choix>2);
		videConsole();
		return choix;
		
	}
	/**
	 *@param ordi Indique si le joueur qui doit être créer est une IA (le nom et la couleur seront sélectionnés automatiquement au lieu de demander à l'utilisateur de saisir ces informations)
	 */
	@Override
	public Joueur saisirJoueur(boolean ordi, int numjoueur) {
		// TODO Auto-generated method stub
		if(ordi==true) {
			nomBloque.add("Ordinateur "+numjoueur);
			int tempCouleur;
			tempCouleur = 0 + (int)(Math.random() * ((6 - 0)));
			if(couleurBloquee.contains(tempCouleur)) {
				tempCouleur+=1;
			}
			couleurBloquee.add(tempCouleur);
			switch (tempCouleur) {
				case 0:
					return new JoueurIA("Ordinateur "+numjoueur,Couleur.BLEU);
				case 1:
					return new JoueurIA("Ordinateur "+numjoueur,Couleur.JAUNE);
				case 2:
					return new JoueurIA("Ordinateur "+numjoueur,Couleur.ROUGE);
				case 3:
					return new JoueurIA("Ordinateur "+numjoueur,Couleur.VERT);
				case 4:
					return new JoueurIA("Ordinateur "+numjoueur,Couleur.MAGENTA);
				default:
					return new JoueurIA("Ordinateur "+numjoueur,Couleur.CYAN);
			}
		}else {
			String name=null;
			do {
				if(name!=null) {
					System.out.println(erreur(Erreur.NOMINVALIDE));
					System.out.println();
				}
				System.out.println(avertissement(Avertissement.NOMJOUEUR)+numjoueur);
				name=sc.next();
			}while(nomBloque.contains(name)||name.isEmpty());
			nomBloque.add(name);
			int tempCouleur=0;
			do {
				try {
					System.out.println();
					System.out.println(avertissement(Avertissement.COULEURJOUEUR));
					System.out.println("1 :  "+Couleur.BLEU.getCode()+couleur(Couleur.BLEU)+Couleur.WHITE.getCode()+
							"  2 : "+Couleur.JAUNE.getCode()+couleur(Couleur.JAUNE)+Couleur.WHITE.getCode()+
							"  3 : "+Couleur.ROUGE.getCode()+couleur(Couleur.ROUGE)+"\n"+Couleur.WHITE.getCode()+
							"4 : "+Couleur.VERT.getCode()+couleur(Couleur.VERT)+Couleur.WHITE.getCode()+
							"  5 : "+Couleur.MAGENTA.getCode()+couleur(Couleur.MAGENTA)+Couleur.WHITE.getCode()+
							"  6 : "+Couleur.CYAN.getCode()+couleur(Couleur.CYAN)+Couleur.WHITE.getCode());
					tempCouleur=sc.nextInt();
					if(tempCouleur<1||tempCouleur>6||couleurBloquee.contains(tempCouleur)) {
						System.out.println();
						System.out.println(erreur(Erreur.COULEURINVALIDE));
					}
				}catch(java.util.InputMismatchException e) {
					sc.nextLine();
					System.out.println(erreur(Erreur.COULEURINVALIDE));
				}
			}while(tempCouleur<1||tempCouleur>6||(couleurBloquee.contains(tempCouleur)));
			couleurBloquee.add(tempCouleur);
			videConsole();
			switch (tempCouleur) {
				case 1:
					return new JoueurHumain(name,Couleur.BLEU);
				case 2:
					return new JoueurHumain(name,Couleur.JAUNE);
				case 3:
					return new JoueurHumain(name,Couleur.ROUGE);
				case 4:
					return new JoueurHumain(name,Couleur.VERT);
				case 5:
					return new JoueurHumain(name, Couleur.MAGENTA);
				default:
					return new JoueurHumain(name,Couleur.CYAN);
			}
		}
	}
	@Override
	public ActionType saisirAction(Joueur unJoueur) {
		// TODO Auto-generated method stub
		String choix="";
		boolean end=false;
		sc.nextLine();
		do {
			System.out.print(avertissement(Avertissement.CHOIXACTION));
			try {
				choix=sc.nextLine();
				System.out.println();
				if(!(choix.equals("p")||choix.equals("P")||choix.equals("d")||choix.equals("D")||choix.equals("M")||choix.equals("m"))) {
					System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
				}else {
					if((choix.equals("p")||choix.equals("P"))&&unJoueur.getPieces().isEmpty()) {
						choix="";
						System.out.println(erreur(Erreur.PASDETAILLEDISPONIBLE));
					}else {
						if((choix.equals("d")||choix.equals("D"))&&unJoueur.getPieces().size()==6) {
							choix="";
							System.out.println(erreur(Erreur.PASDEPIECEDISPONIBLE));
						}else{
							end=true;
						}
					}
				}
			}catch(java.util.InputMismatchException e) {
				sc.nextLine();
				System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
			}
		}while(!end);
		if(choix.equals("p")||choix.equals("P"))return ActionType.PLACER;
		else if(choix.equals("d")||choix.equals("D"))return ActionType.DEPLACER;
		else return ActionType.QUITTER;
	}
	@Override
	public Taille saisirTaille() {
		// TODO Auto-generated method stub
		int temp=0;
		do {
			System.out.println(avertissement(Avertissement.CHOIXTAILLE)+"\n"+
					"1 : "+taille(Taille.PETITE)+" "+
					"2 : "+taille(Taille.MOYENNE)+" "+
					"3 : "+taille(Taille.GRANDE));
			try {
				temp=sc.nextInt();
				if(temp<1||temp>3) {
					System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
				}
			}catch(java.util.InputMismatchException e) {
				sc.nextLine();
				System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
			}
		}while(temp<1||temp>3);
		System.out.println();
		switch (temp) {
			case 1:
				return Taille.PETITE;
			case 2:
				return Taille.MOYENNE;
			default:
				return Taille.GRANDE;
		}
	}
	@Override
	public int[] saisirCoordonnees(ActionType uneActionType) {
		// TODO Auto-generated method stub
		int[] tab=new int[4];
		if(uneActionType==ActionType.QUITTER)return null;
		else if(uneActionType==ActionType.DEPLACER) {
			System.out.println(avertissement(Avertissement.CHOIXORIGIN));
			tab[2]=saisirLigne();
			tab[3]=saisirColonne();
			System.out.println();
		}
		System.out.println(avertissement(Avertissement.CHOIXDESTINATION));
		tab[0]=saisirLigne();
		tab[1]=saisirColonne();
		return tab;
	}
	/**
	 * Permet de saisir une ligne
	 * @return int
	 */
	private int saisirLigne() {
		int temp=0;
		do {
			System.out.print(other(OtherText.Ligne)+" ");
			try {
				temp=sc.nextInt();
				if(temp<1||temp>3) {
					System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
				}
			}catch(java.util.InputMismatchException e) {
				sc.nextLine();
				System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
			}
		}while(temp<1||temp>3);
		return temp-1;
	}
	/**
	 * Permet de saisir une colonne
	 * @return int
	 */
	private int saisirColonne() {
		String tempC="";
		do {
			System.out.print(other(OtherText.Colonne)+" ");
			try {
				tempC=sc.next();
				if(!(tempC.equals("A")||tempC.equals("B")||tempC.equals("C")||tempC.equals("a")||tempC.equals("b")||tempC.equals("c"))) {
					System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
				}
			}catch(java.util.InputMismatchException e) {
				sc.nextLine();
				System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
			}
		}while(!(tempC.equals("A")||tempC.equals("B")||tempC.equals("C")||tempC.equals("a")||tempC.equals("b")||tempC.equals("c")));
		if(tempC.equals("A")||tempC.equals("a"))return 0;
		else if(tempC.equals("B")||tempC.equals("b"))return 1;
		else if(tempC.equals("C")||tempC.equals("c"))return 2;
		else return -1;
	}
	@Override
	public void display(Plateau unPlateau, Joueur joueurActif) {
		// TODO Auto-generated method stub
		if(joueurActif!=null)System.out.println(avertissement(Avertissement.TONTOUR)+joueurActif.getCouleur().getCode()+joueurActif.getNom()+Couleur.WHITE.getCode());
		gobblets.ihm.texte.Plateau plateauAffichable = new gobblets.ihm.texte.Plateau(unPlateau);
		System.out.println("     A   B   C");
		System.out.println("   ┌───┬───┬───┐");
		displayLine(unPlateau, 1, plateauAffichable.getRepresentationTextuelle()[0]);
		System.out.println(super.other(OtherText.Contenu));
		System.out.println("   ├───┼───┼───┤      "+super.other(OtherText.MaisonJoueur1));
		displayLine(unPlateau, 2, plateauAffichable.getRepresentationTextuelle()[1]);
		afficheMaison(plateauAffichable.getMaison(1));
		System.out.println("   ├───┼───┼───┤      "+super.other(OtherText.MaisonJoueur2));
		displayLine(unPlateau, 3, plateauAffichable.getRepresentationTextuelle()[2]);
		afficheMaison(plateauAffichable.getMaison(2));
		System.out.println("   └───┴───┴───┘");
	}
	/**
	 * Cette méthode permet d'afficher une ligne du jeu et affiche "Contenu des maisons" si il s'
	 * @param unPlateau
	 * @param line
	 * @param string 
	 */
	private void displayLine(Plateau unPlateau, int line, String[] ligne) {
		if(line<1||line>3)return;
		System.out.print(" "+line+" | "+ligne[0]+" | "+ligne[1]+" | "+ligne[2]+" |    ");
	}
	/**
	 * Cette méthode permet d'afficher la maison qui lui est assigné en paramètre
	 * @param maison
	 */
	private void afficheMaison(String[] maison) {
		for(String i : maison) {
			System.out.print(i+" ");
		}
		System.out.println("\033[39m");
	}
	public void finalize() {
		sc.close();
	}
	/**
	 *Affiche le menu et permet corriger les éléments de décoration selon la langue 
	 */
	@Override
	public Menu afficheMenu(Etat etat) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("\033[36;01m  ________      ___.  ___.   .__          __\r\n" + 
					" /  _____/  ____\\_ |__\\_ |__ |  |   _____/  |_  ______\r\n" + 
					"/   \\  ___ /  _ \\| __ \\| __ \\|  | _/ __ \\   __\\/  ___/\r\n" + 
					"\\    \\_\\  (  <_> ) \\_\\ \\ \\_\\ \\  |_\\  ___/|  |  \\___ \\\r\n" + 
					" \\______  /\\____/|___  /___  /____/\\___  >__| /____  >\r\n" + 
					"        \\/           \\/    \\/          \\/          \\/\r\n" + 
					"  ________      ___.  ___.   .__\r\n" + 
					" /  _____/  ____\\_ |__\\_ |__ |  |   ___________  ______\r\n" + 
					"/   \\  ___ /  _ \\| __ \\| __ \\|  | _/ __ \\_  __ \\/  ___/\r\n" + 
					"\\    \\_\\  (  <_> ) \\_\\ \\ \\_\\ \\  |_\\  ___/|  | \\/\\___ \\\r\n" + 
					" \\______  /\\____/|___  /___  /____/\\___  >__|  /____  >\r\n" + 
					"        \\/           \\/    \\/          \\/           \\/\033[39m");
			System.out.println();
			String texte1;
			int longueur;
			if(("│"+menu(Menu.MENU_FICHIER)+" :").length()<=8) {
				if(("│"+menu(Menu.MENU_FICHIER)+" :").length()>=8) {
					texte1 = "│"+menu(Menu.MENU_FICHIER)+
							" :\t"+menu(Menu.MENU_NOUVEAU)+
							" (1)\t\t"+menu(Menu.MENU_OUVRIR)+
							" (2)\t"+menu(Menu.MENU_ENREGISTRER)+
							" (3)│";
					longueur=texte1.length()+11+
							(menu(Menu.MENU_FICHIER)+" :").length()%8+
							(menu(Menu.MENU_NOUVEAU)+" (1) ").length()%8+
							(menu(Menu.MENU_OUVRIR)+" (2)").length()%8;
				}
				else {
					texte1 = "│"+menu(Menu.MENU_FICHIER)+
							" :\t\t"+menu(Menu.MENU_NOUVEAU)+
							" (1)\t\t"+menu(Menu.MENU_OUVRIR)+
							" (2)\t"+menu(Menu.MENU_ENREGISTRER)+
							" (3)│";
					longueur=texte1.length()+16+
							(menu(Menu.MENU_FICHIER)+" :").length()%8+
							(menu(Menu.MENU_NOUVEAU)+" (1) ").length()%8+
							(menu(Menu.MENU_OUVRIR)+" (2)").length()%8;
				}
				
			}else {
				texte1 = "│"+menu(Menu.MENU_FICHIER)+
						" :\t"+menu(Menu.MENU_NOUVEAU)+
						" (1)\t"+menu(Menu.MENU_OUVRIR)+
						" (2)\t"+menu(Menu.MENU_ENREGISTRER)+
						" (3)│";
				longueur=texte1.length()+8+
						(menu(Menu.MENU_FICHIER)+" :").length()%8+
						(menu(Menu.MENU_NOUVEAU)+" (1) ").length()%8+
						(menu(Menu.MENU_OUVRIR)+" (2)").length()%8;
			}
			System.out.print("┌");
			for(int i=0;i<longueur-3;i++) {
				System.out.print("─");
			}
			System.out.print("┐\n");
			System.out.println(texte1);
			System.out.print("├");
			for(int i=0;i<longueur-3;i++) {
				if(i==(menu(Menu.MENU_LANGUE)+" (4)").length()) {
					System.out.print("┬");
				}
				else {
					System.out.print("─");
				}
			}
			System.out.print("┘\n");
			System.out.println("│"+menu(Menu.MENU_LANGUE)+" (4)│");
			String texte2;
			int longueur2;
			if(("│"+menu(Menu.MENU_AIDE)+" :").length()>=8) {
				texte2="\n│"+menu(Menu.MENU_AIDE)+" :\t"+menu(Menu.MENU_APROPOS)+" (5)│";
				longueur2=texte2.length()+
						(menu(Menu.MENU_AIDE)).length()%8-1;
			}else {
				texte2="\n│"+menu(Menu.MENU_AIDE)+" :\t\t"+menu(Menu.MENU_APROPOS)+" (5)│";
				longueur2=texte2.length()+
						(menu(Menu.MENU_AIDE)).length()%8;
			}
			System.out.print("├");
			for(int i=0;i<longueur2;i++) {
				if(i==(menu(Menu.MENU_LANGUE)+" (4)").length()) {
					System.out.print("┴");
				}
				else {
					System.out.print("─");
				}
			}
			System.out.print("┐");
			System.out.println(texte2);
			int longueur3=("│"+menu(Menu.MENU_QUITTER)+" (6)│").length();
			System.out.print("├");
			for(int i=0;i<longueur2;i++) {
				if(i==longueur3-2) {
					System.out.print("┬");
				}
				else{
					System.out.print("─");
				}
			}
			System.out.println("┘");
			System.out.println("│"+menu(Menu.MENU_QUITTER)+" (6)│");
			System.out.print("└");
			for(int i=0;i<longueur3-2;i++) {
				System.out.print("─");
			}
			System.out.println("┘");
			try {
				int choix=sc.nextInt();
				switch(choix) {
					case 1:
						if(etat.equals(Etat.JEUQUITTE)) {
							if(saisirReprendre()) {
								videConsole();
								return Menu.MENU_REPRENDRE;
							}
						}
						videConsole();
						return Menu.MENU_NOUVEAU;
					case 2:
						if(etat.equals(Etat.JEUQUITTE)) {
							if(saisirReprendre()) {
								return Menu.MENU_REPRENDRE;
							}
						}
						return Menu.MENU_OUVRIR;
					case 3:
						return Menu.MENU_ENREGISTRER;
					case 4:
						return Menu.MENU_LANGUE;
					case 5:
						sc.nextLine();
						return Menu.MENU_APROPOS;
					case 6:
						videConsole();
						return Menu.MENU_QUITTER;
					case 42:
						videConsole();
						System.out.println("\033[107;01m\033[30;01m_________▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▄_____\n" + 
								"_______█░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░█_____\n" + 
								"_______█░▒▒▒▒▒▒▒▒▒▒▄▀▀▄▒▒▒░░█▄▀▀▄_\n" + 
								"__▄▄___█░▒▒▒▒▒▒▒▒▒▒█▓▓▓▀▄▄▄▄▀▓▓▓█_\n" + 
								"█▓▓█▄▄█░▒▒▒▒▒▒▒▒▒▄▀▓▓▓▓▓▓▓▓▓▓▓▓▀▄_\n" + 
								"_▀▄▄▓▓█░▒▒▒▒▒▒▒▒▒█▓▓▓▄█▓▓▓▄▓▄█▓▓█_\n" + 
								"_____▀▀█░▒▒▒▒▒▒▒▒▒█▓▒▒▓▄▓▓▄▓▓▄▓▒▒█\n" + 
								"______▄█░░▒▒▒▒▒▒▒▒▒▀▄▓▓▀▀▀▀▀▀▀▓▄▀_\n" + 
								"____▄▀▓▀█▄▄▄▄▄▄▄▄▄▄▄▄██████▀█▀▀___\n" + 
								"____█▄▄▀_█▄▄▀_______█▄▄▀_▀▄▄█_____\033[97;01m\033[49;01m");
						System.exit(0);
					default:
						System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
						videConsole();
				}
			}catch(InputMismatchException e) {
				System.out.println(Erreur.ARGUMENTINCORRECT);
				videConsole();
			}
		}
	}
	/**
	 * Permet de savoir si l'utilisateur veut reprendre la partie qui était en cours
	 */
	private boolean saisirReprendre() {
		String choix2="";
		do {
			System.out.println(other(OtherText.Reprendre));
			choix2=sc.next();
			if(!(choix2.equals("y")||choix2.equals("Y")||choix2.equals("n")||choix2.equals("N"))) {
				System.out.println(erreur(Erreur.ARGUMENTINCORRECT));
			}
		}while(!(choix2.equals("y")||choix2.equals("Y")||choix2.equals("n")||choix2.equals("N")));
		if(choix2.equals("y")||choix2.equals("Y")) {
			videConsole();
			return true;
		}
		else return false;
				
	}
	@Override
	public void videConsole() {
		System.out.print("\033[2J\033[;H");
	}
	
	/**
	 *Permet d'afficher un texte qui demande d'appuyer sur entrée pour continuer
	 */
	public void attendre() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.print("-press Enter-");
		sc.nextLine();
		videConsole();
	}
}
