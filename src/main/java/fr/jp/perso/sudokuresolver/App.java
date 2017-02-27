package fr.jp.perso.sudokuresolver;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;

public class App {

   public static void main(String[] args) {
      try {
         SudokuGrid sudokuGrid = SudokuGridFactory.createSudokuGrid();
         SudokuResolver.resolve(sudokuGrid);
      } catch (Exception ex) {
         System.out.println("Exception in the application: " + ex);
      }
   }
}
