package fr.jp.perso.sudokuresolver.calkrules.numbermaybepresentrules;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.calkrules.CalkRule;

public class NumberMaybePresentRules extends CalkRule {

   public NumberMaybePresentRules(CalkRule nextRule) {
      super(null);
      TripleNumberMaybePresentRule tripleNumberMaybePresentRule = new TripleNumberMaybePresentRule(nextRule);
      DoubleNumberMaybePresentRule doubleNumberMaybePresentRule = new DoubleNumberMaybePresentRule(tripleNumberMaybePresentRule);

   }

   @Override
   protected void apply(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int currentNumber) {

   }
}
