package fr.jp.perso.sudokuresolver;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.bo.calkrules.CalkRule;
import fr.jp.perso.sudokuresolver.bo.calkrules.NumberMaybePresentRule;
import fr.jp.perso.sudokuresolver.bo.calkrules.NumberPresentRule;
import fr.jp.perso.sudokuresolver.bo.calkrules.OccupiedPositionRule;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;

import java.util.List;

public class SudokuResolver {

   private CalkRule firstRule;

   public SudokuResolver() {
      NumberMaybePresentRule numberMaybePresentRule = new NumberMaybePresentRule(null);
      NumberPresentRule numberPresentRule = new NumberPresentRule(numberMaybePresentRule);
      OccupiedPositionRule occupiedPositionRule = new OccupiedPositionRule(numberPresentRule);

      firstRule = occupiedPositionRule;
   }

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

   public void resolve(SudokuGrid sudokuGrid) {
      boolean sudokuGridChanged = false;
      int attemps = 0;

      do {
         sudokuGrid.display();
         sudokuGridChanged = tryAllNumber(sudokuGrid);
         attemps++;
      } while (sudokuGridChanged || attemps > 100);

      System.out.println(attemps + " attemps.");
   }

   private boolean tryAllNumber(SudokuGrid sudokuGrid) {
      boolean sudokuGridChanged = false;
      for (int currentNumber = 1; currentNumber <= 9; currentNumber++) {
         sudokuGridChanged |= tryANumber(sudokuGrid, currentNumber);
      }

      return sudokuGridChanged;
   }

   private boolean tryANumber(SudokuGrid sudokuGrid, int currentNumber) {
      boolean sudokuGridChanged = false;
      SudokuGridCalk calk = createCalk(sudokuGrid, currentNumber);

      for (int subGridIndex = 0; subGridIndex <= 8; subGridIndex++) {
         SubGridCalk subGridCalk = calk.getSubGrid(subGridIndex);
         List<Integer> availablePositions = subGridCalk.getAvailablePositions();
         if (availablePositions.size() == 1) {
            sudokuGrid.getSubGrid(subGridIndex).setSquareValue(availablePositions.get(0), currentNumber);
            sudokuGridChanged = true;
         } else if (availablePositions.size() > 1) {
            sudokuGridChanged |= setPossibleValue(sudokuGrid.getSubGrid(subGridIndex), availablePositions, currentNumber);
         }
      }

      return sudokuGridChanged;
   }

   private boolean setPossibleValue(SubGrid subGrid, List<Integer> availablePositions, int currentNumber) {
      boolean sudokuGridChanged = false;
      for (Integer availablePosition : availablePositions) {
         if (!subGrid.getSquare(availablePosition).isPossibleValue(currentNumber)) {
            subGrid.getSquare(availablePosition).addPossibleValue(currentNumber);
            sudokuGridChanged = true;
         }
      }
      return sudokuGridChanged;
   }

   private SudokuGridCalk createCalk(SudokuGrid sudokuGrid, int number) {
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createSudokuGridCalk();

      firstRule.applyRule(sudokuGrid, sudokuGridCalk, number);

      return sudokuGridCalk;
   }
}
