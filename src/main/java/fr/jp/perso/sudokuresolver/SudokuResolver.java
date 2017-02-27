package fr.jp.perso.sudokuresolver;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;

public class SudokuResolver {

   /*
   List of rules, applies during creation of a calk for a number:

   Generate a calk of available squares for a number.
      - put unavailable where there already is a number
      - put unavailable where there is the same number on the same line or same column
      - put unavailable where all the possible positions of a number are on one line or column in a sub grid

   if one square is available for a subGrid, put the number inside, regenerate the calk
   if two square are available for a subGrid, put the number as possible solution, regenerate the calk



    */

   public static void resolve(SudokuGrid sudokuGrid) {
      sudokuGrid.display();

      for (int currentNumber = 1; currentNumber <= 9; currentNumber++) {
         for (int currentSubGrid = 0; currentSubGrid <= 8; currentSubGrid++) {

         }
      }
   }
}
