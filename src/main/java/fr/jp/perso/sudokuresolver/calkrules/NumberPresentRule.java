package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;

public class NumberPresentRule extends CalkRule {

   public NumberPresentRule(CalkRule nextRule) {
      super(nextRule);
   }

   @Override
   public void applyRule(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int currentNumber) {
      for (int subGridIndex = 0; subGridIndex <= 8; subGridIndex++) {
         SubGrid currentSubGrid = sudokuGrid.getSubGrid(subGridIndex);
         SubGridCalk currentSubGridCalk = sudokuGridCalk.getSubGrid(subGridIndex);
         int squareIndex = currentSubGrid.getIndexNumber(currentNumber);
         if (squareIndex != -1) {
            currentSubGridCalk.setEntireSubGridUnavailable();
            sudokuGridCalk.setLineUnavailable(subGridIndex, squareIndex);
            sudokuGridCalk.setColumnUnavailable(subGridIndex, squareIndex);
         }
      }

      if (nextRule != null) {
         nextRule.applyRule(sudokuGrid, sudokuGridCalk, currentNumber);
      }
   }
}
