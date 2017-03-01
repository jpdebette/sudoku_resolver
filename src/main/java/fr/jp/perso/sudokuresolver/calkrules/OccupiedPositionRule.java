package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;

public class OccupiedPositionRule extends CalkRule {

   public OccupiedPositionRule(CalkRule nextRule) {
      super(nextRule);
   }

   @Override
   public void applyRule(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int currentNumber) {
      sudokuGridCalk.setUnavailableOccupiedPositions(sudokuGrid);

      if (nextRule != null) {
         nextRule.applyRule(sudokuGrid, sudokuGridCalk, currentNumber);
      }
   }
}
