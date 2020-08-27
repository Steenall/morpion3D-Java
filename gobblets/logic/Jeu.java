package gobblets.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gobblets.Gobblets;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.JoueurIA;
import gobblets.data.Piece;
import gobblets.data.Plateau;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.ihm.OtherText;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.interaction.Termination;

/**
 * @author Evan Fregeais
 *
 */
public class Jeu {
	private Etat etat;
	private Joueur joueurActif;
	private Joueur j1;
	private Joueur j2;
	private Plateau plateau;
	private boolean ouvrir;
	private int nbTours;
	private boolean terminer;
	public Jeu() {
		etat=Etat.NONCOMMENCER;
		plateau= Plateau.initPlateau();
		System.out.println();
		IHM.setIHM(new SaisieConsole());
		IHM.getIHM().choisirLangue();
		ouvrir=false;
		terminer=true;
		nbTours=0;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	private Etat unTour(int nbTours) {
		boolean finDuTour=false;
		Action choix = null;
		do {
			try{
				IHM.getIHM().display(plateau,joueurActif);
				choix = joueurActif.choisirAction(plateau);
				if(choix.verifier(joueurActif)) {
					choix.appliquer(joueurActif);
					finDuTour=true;
					if(!(j1 instanceof JoueurIA&&j2 instanceof JoueurIA))IHM.getIHM().videConsole();
					if(choix instanceof Placement) {
						ArrayList<Piece> temp;
						if(joueurActif.equals(j1)) {
							temp = plateau.getMaisonJoueur1();
						}else {
							temp = plateau.getMaisonJoueur2();
						}
						for(Piece i : temp) {
							if(i.getTaillePiece().equals(((Placement) choix).getTaille())){
								temp.remove(i);
								break;
							}
						}
					}
				}
				else {
					IHM.getIHM().videConsole();
					if(choix instanceof Placement) {
						if(!joueurActif.aPieceDeTaille(((Placement) choix).getTaille())) {
							System.out.println(IHM.erreur(Erreur.PASDETAILLEDISPONIBLE));
						}else if(!((Placement) choix).getDestination().acceptePiece(((Placement) choix).getTaille())) {
							System.out.println(IHM.erreur(Erreur.CASEBLOQUEE));
						}
					}
					else if(choix instanceof Deplacement) {
						if(!((Deplacement) choix).getOrigin().plusGrandePiece().appartientA(joueurActif)) {
							System.out.println(IHM.erreur(Erreur.PASTAPIECE));
						}else if(!((Deplacement) choix).getDestination().acceptePiece(((Deplacement) choix).getOrigin().plusGrandePiece().getTaillePiece())) {
							System.out.println(IHM.erreur(Erreur.CASEBLOQUEE));
						}
					}
				}
				
			}catch(PiecePasDisponibleException e){
				IHM.getIHM().videConsole();
				System.out.println(IHM.erreur(e.getErreur()));
			}catch(CaseBloqueeException e){
				IHM.getIHM().videConsole();
				System.out.println(IHM.erreur(e.getErreur()));
			}
		}while(finDuTour!=true);
		if(choix instanceof Termination)return Etat.JEUQUITTE;
		int winJ1=0, winJ2=0;
		for(int i=0;i<3;i++) {
			Couleur tempL = plateau.verifierLigne(i);
			Couleur tempC = plateau.verifierColonne(i);
			Couleur tempDP= plateau.verifierDiagonale('P');
			Couleur tempDS= plateau.verifierDiagonale('S');
			if(tempL!=null) {
				if(j1.getCouleur().equals(tempL))winJ1++;
				else winJ2++;
			}
			if(tempC!=null) {
				if(j1.getCouleur().equals(tempC))winJ1++;
				else winJ2++;
			}
			if(tempDP!=null) {
				if(j1.getCouleur().equals(tempDP))winJ1++;
				else winJ2++;
			}
			if(tempDS!=null) {
				if(j1.getCouleur().equals(tempDS))winJ1++;
				else winJ2++;
			}
		}
		if(winJ1==winJ2&&winJ1>0)return Etat.MATCHNUL;
		else if(winJ1>winJ2)return Etat.JOUEUR1GAGNE;
		else if(winJ2>winJ1)return Etat.JOUEUR2GAGNE;
		else return Etat.JEUENCOURS;
		
	}
	public void changeJoueur() {
		if(joueurActif.equals(j2)) {
			joueurActif=j1;
		}else {
			joueurActif=j2;
		}
	}
	public Etat play() {
		int nbTours =0;
		etat=Etat.JEUENCOURS;
		if(ouvrir==false) {
			terminer=false;
			plateau=Plateau.initPlateau();
			int nbJoueursNonIA = IHM.getIHM().saisirNbJoueurNonIA();
			j1=IHM.getIHM().saisirJoueur(nbJoueursNonIA==0, 1);
			j2=IHM.getIHM().saisirJoueur(nbJoueursNonIA<=1, 2);
			for(int i=0;i<6;i++) {
				j1.ajoutePiece(plateau.getMaisonJoueur1().get(i));
				j2.ajoutePiece(plateau.getMaisonJoueur2().get(i));
				j1.getPieces().get(i).setCouleurPiece(j1.getCouleur());
				j2.getPieces().get(i).setCouleurPiece(j2.getCouleur());
				plateau.getMaisonJoueur1().get(i).setCouleurPiece(j1.getCouleur());
				plateau.getMaisonJoueur2().get(i).setCouleurPiece(j2.getCouleur());
			}
			int quiCommence = 0 + (int)(Math.random() * ((2 - 0)));
			if(quiCommence>=1) {
				joueurActif=j1;
			}else {
				joueurActif=j2;
			}
			System.out.println(IHM.other(OtherText.Random)+joueurActif.getCouleur().getCode()+joueurActif.getNom()+Couleur.WHITE.getCode());
			System.out.println();
		}
		do {
			etat=unTour(nbTours);
			if(nbTours==0&&joueurActif instanceof JoueurIA&&
					(((!j1.equals(joueurActif))&&j1 instanceof JoueurHumain)||
					(((!j2.equals(joueurActif))&&j2 instanceof JoueurHumain)))) {
				System.out.println(IHM.other(OtherText.Random)+joueurActif.getCouleur().getCode()+joueurActif.getNom()+Couleur.WHITE.getCode());
			}
			if(j1 instanceof JoueurIA&&j2 instanceof JoueurIA) {
				IHM.getIHM().attendre();
			}
			changeJoueur();
			nbTours++;
		}while(etat==Etat.JEUENCOURS);
		changeJoueur();
		IHM.getIHM().cleanBlocage();
		return etat;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public Joueur getJ1() {
		return j1;
	}
	public Joueur getJ2() {
		return j2;
	}
	public Joueur getJoueurActif() {
		return joueurActif;
	}
	
	/**
	 * Affiche le menu en boucle tant que le joueur ne quitte pas le jeu
	 * 
	 */
	public void menu() {
		// TODO Auto-generated method stub
		Menu menu=null;
		do {
			menu=IHM.getIHM().afficheMenu(etat);
			switch (menu) {
				case MENU_QUITTER:
					IHM.getIHM().finalize();
					break;
				case MENU_NOUVEAU:
					terminer=false;
					play();
					afficheGagnant();
					break;
				case MENU_OUVRIR:
					IHM.getIHM().videConsole();
					chargement("save_GobbletsGobblers.ser");
					break;
				case MENU_APROPOS:
					aPropos();
					break;
				case MENU_ENREGISTRER:
					IHM.getIHM().videConsole();
					if(!terminer) {
						try{
							sauvegarder();
							System.out.println(Couleur.VERT.getCode()+IHM.other(OtherText.Save)+Couleur.WHITE.getCode());
						}catch(IOException e) {
							System.out.println(IHM.erreur(Erreur.INCONNU));
						}
					}
					else System.out.println(IHM.erreur(Erreur.SAVE));
					break;
				case MENU_LANGUE:
					IHM.getIHM().choisirLangue();
					break;
				case MENU_REPRENDRE:
					ouvrir=true;
					play();
					ouvrir=false;
					afficheGagnant();
				default:
					break;
			}
		}while(menu!=Menu.MENU_QUITTER);
	}
	/**
	 * Charge un fichier de sauvegarde
	 * @param nomFichier
	 */
	public void chargement(String nomFichier) {
		ouvrir=true;
		ObjectInputStream ois = null;
		try {
			final FileInputStream fichier = new FileInputStream(nomFichier);
			ois = new ObjectInputStream(fichier);
			plateau = (Plateau) ois.readObject();
			j1 = (Joueur) ois.readObject();
			j2 = (Joueur) ois.readObject();
			joueurActif = (Joueur) ois.readObject();
			etat = (Etat) ois.readObject();
			ouvrir=true;
			nbTours=(int) ois.readObject();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		play();
		afficheGagnant();
	}
	/**
	 * Sauvegarde la partie dans un fichier save_GobbletsGobblers.ser dans la racine du projet
	 * @throws IOException 
	 */
	public void sauvegarder() throws IOException {
		ObjectOutputStream oos = null;
		final FileOutputStream fichier = new FileOutputStream("save_GobbletsGobblers.ser");
		oos = new ObjectOutputStream(fichier);
		oos.writeObject(plateau);
		oos.writeObject(j1);
		oos.writeObject(j2);
		oos.writeObject(joueurActif);
		oos.writeObject(etat);
		oos.writeObject(nbTours);
		oos.flush();
		if (oos != null) {
			oos.flush();
			oos.close();
		}
		
	}
	/**
	 * Affiche le contenu de readme.md (le fichier est affiché partie par partie, c'est-à-dire qu'il faut appuyer sur entrée pour voir le texte dans une autre langue)
	 * Note: Il y a deux chemins possible pour le fichier, le premier si le projet est éxécuté sous Eclipse, le second dans un .jar
	 */
	public void aPropos() {
		IHM.getIHM().videConsole();
		InputStream inputStream;
		BufferedReader reader=null;
		if((inputStream = Gobblets.class.getResourceAsStream("/gobblets/readme.md"))!=null) {
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputReader);
		}
		else {
			FileReader inputReader=null;
			try {
				inputReader = new FileReader("src/gobblets/readme.md");
				reader = new BufferedReader(inputReader);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		String line=null;
		try {
			while((line=reader.readLine())!=null) {
				if(line.length()<=1) {
					IHM.getIHM().attendre();
					IHM.getIHM().videConsole();
				}else {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IHM.getIHM().attendre();
		IHM.getIHM().videConsole();
	}
	public void afficheGagnant() {
		if(etat!=Etat.JEUQUITTE) {
			terminer=true;
			IHM.getIHM().display(plateau, null);
		}
		if(etat.equals(Etat.JOUEUR1GAGNE)) {
			System.out.println(IHM.other(OtherText.Congratulation)+j1.getCouleur().getCode()+j1.getNom());
		}else if(etat.equals(Etat.JOUEUR2GAGNE)) {
			System.out.println(IHM.other(OtherText.Congratulation)+j2.getCouleur().getCode()+j2.getNom());
		}else if(etat.equals(Etat.MATCHNUL)) {
			System.out.println(IHM.other(OtherText.MatchNul));
		}
		if(etat!=Etat.JEUQUITTE){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		IHM.getIHM().videConsole();
	}
	public void setTerminer(boolean b) {
		// TODO Auto-generated method stub
		terminer=b;
	}
}
