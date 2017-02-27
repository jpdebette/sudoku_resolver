package fr.jp.perso.sudokuresolver;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;

public class SudokuResolver {

   /*
   List of rules, applies during creation of a calk for a number:

   Generate a calk of available squares for a number.
      - put the sub grid unavailable if the number already exist in it.
      - put unavailable where there already is a number
      - put unavailable where there is the same number on the same line or same column
      - put unavailable where all the possible positions of a number are on one line or column in a sub grid

   if one square is available for a subGrid, put the number inside, regenerate the calk
   if two square are available for a subGrid, put the number as possible solution, regenerate the calk

    */

   public static void resolve(SudokuGrid sudokuGrid) {
      sudokuGrid.display();

      SudokuGridCalk calk = createCalk(sudokuGrid, 1);
      calk.display();

      /*for (int currentNumber = 1; currentNumber <= 9; currentNumber++) {
      }*/
   }

   private static SudokuGridCalk createCalk(SudokuGrid sudokuGrid, int number) {
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createSudokuGridCalk();

      sudokuGridCalk.setUnavailableOccupiedPositions(sudokuGrid);

      for (int subGridIndex = 0; subGridIndex <= 8; subGridIndex++) {
         SubGrid currentSubGrid = sudokuGrid.getSubGrid(subGridIndex);
         SubGridCalk currentSubGridCalk = sudokuGridCalk.getSubGrid(subGridIndex);
         int squareIndex = currentSubGrid.getIndex(number);
         if (squareIndex != -1) {
            currentSubGridCalk.setEntireSubGridUnavailable();
            sudokuGridCalk.setLineUnavailable(subGridIndex, squareIndex);
            sudokuGridCalk.setColumnUnavailable(subGridIndex, squareIndex);
         }
      }

      return sudokuGridCalk;
   }
}
