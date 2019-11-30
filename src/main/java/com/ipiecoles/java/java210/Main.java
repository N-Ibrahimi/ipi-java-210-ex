package com.ipiecoles.java.java210;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Sudoku new_table = new Sudoku();
		
		String[] tabCoordonnees= Sudoku.demandeCoordonneesSudoku();
		new_table.remplitSudokuATrous(tableauCoordonnees);
		new_table.ecrireSudoku(new_table.getSudokuAResoudre());
		if (new_table.resoudre(0, 0, new_table.SudokuAResoudre) {
			System.out.println("résou");
			new_table.ecrireSudoku(new_table.SudokuAResoudre);
			
		} else {
			System.out.println("Pas de solution...");
		}

	}
}
