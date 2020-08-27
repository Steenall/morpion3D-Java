package gobblets;

import gobblets.logic.Jeu;

public class Gobblets {
	public void gobbletsGobblers(String[] args) {
		Jeu jeu =new Jeu();
		if(args.length!=0) {
			if(args[0].equals("-o")) {
				if(args.length==2) {
					jeu.chargement(args[1]);
				}else {
					jeu.chargement("save_GobbletsGobblers.ser");
				}
			}else if(args[0].equals("-q")) {
				jeu.setTerminer(false);
				jeu.play();
				jeu.menu();
			}
		}
		else jeu.menu();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("\033[2J\033[;H\033[;01m");
		new Gobblets().gobbletsGobblers(args);
		System.out.println("\033[36;01m  _______      ___      .___  ___.  _______ \r\n" + 
				" /  _____|    /   \\     |   \\/   | |   ____|\r\n" + 
				"|  |  __     /  ^  \\    |  \\  /  | |  |__   \r\n" + 
				"|  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|  \r\n" + 
				"|  |__| |  /  _____  \\  |  |  |  | |  |____ \r\n" + 
				" \\______| /__/     \\__\\ |__|  |__| |_______|\r\n" + 
				"                                            \r\n" + 
				"  ______   ____    ____  _______ .______      \r\n" + 
				" /  __  \\  \\   \\  /   / |   ____||   _  \\     \r\n" + 
				"|  |  |  |  \\   \\/   /  |  |__   |  |_)  |    \r\n" + 
				"|  |  |  |   \\      /   |   __|  |      /     \r\n" + 
				"|  `--'  |    \\    /    |  |____ |  |\\  \\----.\r\n" + 
				" \\______/      \\__/     |_______|| _| `._____|\r\n\033[39m");
	}

}
