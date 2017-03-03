package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;

public abstract class CalkRule {

   protected CalkRule nextRule;

   public CalkRule(CalkRule nextRule) {
      this.nextRule = nextRule;
   }

   public void applyRule(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int currentNumber) {
      apply(sudokuGrid, sudokuGridCalk, currentNumber);
      if (nextRule != null) {
         nextRule.applyRule(sudokuGrid, sudokuGridCalk, currentNumber);
      }
   }

   abstract void apply(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int currentNumber);
}
