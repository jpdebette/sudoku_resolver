package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import org.junit.Test;
import org.mockito.Mockito;

public class CalkRuleTest {

   @Test
   public void hasToCallNextRule() {
      CalkRule nextCalkRule = Mockito.mock(CalkRule.class);

      CalkRule firstCalkRule = Mockito.spy(new CalkRule(nextCalkRule) {
         @Override
         void apply(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int currentNumber) {

         }
      });

      SudokuGrid sudokuGrid = Mockito.mock(SudokuGrid.class);
      SudokuGridCalk sudokuGridCalk = Mockito.mock(SudokuGridCalk.class);

      firstCalkRule.applyRule(sudokuGrid, sudokuGridCalk, 6);

      Mockito.verify(nextCalkRule, Mockito.times(1)).applyRule(sudokuGrid, sudokuGridCalk, 6);
   }
}
