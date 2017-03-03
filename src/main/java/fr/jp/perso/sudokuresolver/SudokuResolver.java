package fr.jp.perso.sudokuresolver;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.calkrules.CalkRule;
import fr.jp.perso.sudokuresolver.calkrules.DoubleNumberMaybePresentRule;
import fr.jp.perso.sudokuresolver.calkrules.NumberPresentRule;
import fr.jp.perso.sudokuresolver.calkrules.OccupiedPositionRule;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import fr.jp.perso.sudokuresolver.utils.SudokuValidator;

import java.util.List;

public class SudokuResolver {

   private CalkRule firstRule;

   public SudokuResolver() {
      DoubleNumberMaybePresentRule doubleNumberMaybePresentRule = new DoubleNumberMaybePresentRule(null);
      NumberPresentRule numberPresentRule = new NumberPresentRule(doubleNumberMaybePresentRule);
      OccupiedPositionRule occupiedPositionRule = new OccupiedPositionRule(numberPresentRule);

      firstRule = occupiedPositionRule;
   }

   public void resolve(SudokuGrid sudokuGrid) {
      boolean sudokuGridChanged = false;
      int attemps = 0;

      do {
         sudokuGrid.display();
         sudokuGridChanged = tryAllNumber(sudokuGrid);
         attemps++;
      } while (sudokuGridChanged || attemps > 100);

      System.out.println(attemps + " attemps.");
      SudokuValidator.validateSudokuGrid(sudokuGrid);
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
            calk = createCalk(sudokuGrid, currentNumber);
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
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      firstRule.applyRule(sudokuGrid, sudokuGridCalk, number);

      return sudokuGridCalk;
   }
}
