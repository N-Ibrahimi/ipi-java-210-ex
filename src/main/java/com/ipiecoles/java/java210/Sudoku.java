package com.ipiecoles.java.java210;

import java.util.Scanner;

public class Sudoku {

	public static final String FIN_SAISIE = "FIN";
	public static boolean resolu = false;
	public static short sudokuAResoudre[][];
	private static Scanner entered;

	public short[][] getSudokuAResoudre() {
		return sudokuAResoudre;
	}

	public void setSudokuAResoudre(short[][] entry) {
		sudokuAResoudre = entry;
	}

	public Sudoku() {
		sudokuAResoudre = new short[9][9];
	}

	public static boolean ligneSaisieEstCoherente(String ligneSaisie) {
		if (ligneSaisie == null || ligneSaisie.trim().isEmpty()) {
			System.out.println(
					"Les coordonnées du chiffre et/ou sa valeur ne peuvent pas être nulles, vides ou remplies avec des espaces");
			return false;
		}
		if (ligneSaisie.length() != 3) {
			System.out.println("Les coordonnées du chiffre et/ou sa valeur doit faire 3 caractères");
			return false;
		}
		if (!ligneSaisie.substring(0, 1).matches("[0-8]") || !ligneSaisie.substring(1, 2).matches("[0-8]")
				|| !ligneSaisie.substring(2, 3).matches("[1-9]")) {
			// if(!ligneSaisie.matches("[0-8][0-8][19]" on peut faire ensemble
			System.out.println("L'abscisse et l'ordonnée doivent être compris entre 0 et 8, la valeur entre 1 et 9");
			return false;
		}
		return true;
	}

	public static String[] demandeCoordonneesSudoku() {
		entered = new Scanner(System.in);
		String[] tableauCoordonnees = new String[81];
		int indiceTableauCoordonnees = 0;
		String ligneSaisie = null;
		do {
			System.out.println("Entrez les numéros (XYZ): ");
			ligneSaisie = entered.nextLine();
			if (ligneSaisie.equals(FIN_SAISIE)) {
				break;
			} else if (ligneSaisieEstCoherente(ligneSaisie)) {
				tableauCoordonnees[indiceTableauCoordonnees++] = ligneSaisie;
			} else {
				System.out.println(
						"Les coordonnées du chiffre et/ou sa valeur ne sont pas cohérents. Merci de réessayer");
			}
		} while (!ligneSaisie.equals(FIN_SAISIE) && indiceTableauCoordonnees < 81);
		System.out.println("Merci, au revoir");
		entered.close();
		return tableauCoordonnees;
	}

	public void remplitSudokuATrous(String[] tableauCoordonnees) {
		for (String coordonne : tableauCoordonnees) {
			if (coordonne == null) {
				break;
			}
			short ligne = (short) stringToInt(coordonne.substring(0, 1));
			short colonne = (short) stringToInt(coordonne.substring(1, 2));
			short valeur = (short) stringToInt(coordonne.substring(2, 3));
			sudokuAResoudre[ligne][colonne] = valeur;
		}
	}

	private int stringToInt(String s) {
		return Integer.parseInt(s);
	}

	public void ecrireSudoku(short[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + sudoku[i][j] + " ");
			}
			System.out.println(" ");
		}

	}

	public static boolean estAutorise(int abscisse, int ordonnee, short chiffre, short[][] sudoku) {
		for (int j = 0; j < 9; j++) {
			if (chiffre == sudoku[abscisse][j]) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (chiffre == sudoku[i][ordonnee]) {
				return false;
			}
		}

		int decI = (abscisse / 3) * 3;
		int decJ = (ordonnee / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (chiffre == sudoku[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean resoudre(int abscisse, int ordonnee, short[][] sudoku) {
		
	}
}