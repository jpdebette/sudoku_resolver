package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;

public abstract class CalkRule {

   protected CalkRule nextRule;

   public CalkRule(CalkRule nextRule) {
      this.nextRule = nextRule;
   }

   public abstract void applyRule(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int currentNumber);
}
