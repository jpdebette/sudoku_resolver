package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class NumberPresentRuleTest {

   @Test
   public void hasToSetUnavailableSubGrid1() {
      NumberPresentRule numberPresentRule = new NumberPresentRule(null);
      SudokuGrid sudokuGrid = createTestSudokuGrid();
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      numberPresentRule.applyRule(sudokuGrid, sudokuGridCalk, 5);

      SudokuGridCalk sudokuGridCalkReference = createTestSudokuGridCalkForNumber5();
      Assert.assertTrue(sudokuGridCalkReference.equals(sudokuGridCalk));
   }

   @Test
   public void hasToSetUnavailableSubGrid2() {
      NumberPresentRule numberPresentRule = new NumberPresentRule(null);
      SudokuGrid sudokuGrid = createTestSudokuGrid();
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      numberPresentRule.applyRule(sudokuGrid, sudokuGridCalk, 2);

      SudokuGridCalk sudokuGridCalkReference = createTestSudokuGridCalkForNumber2();
      Assert.assertTrue(sudokuGridCalkReference.equals(sudokuGridCalk));
   }

   private SudokuGrid createTestSudokuGrid() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 5, 0, 0, 0, 0, 1, 0, 4};
      subGrids[1] = new int[]{0, 0, 9, 0, 6, 0, 0, 0, 0};
      subGrids[2] = new int[]{0, 0, 8, 5, 9, 0, 2, 0, 0};

      subGrids[3] = new int[]{0, 7, 2, 0, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{4, 0, 0, 6, 2, 0, 0, 0, 3};
      subGrids[5] = new int[]{0, 0, 0, 0, 8, 0, 0, 0, 7};

      subGrids[6] = new int[]{0, 8, 0, 4, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 9, 0, 0, 0, 1};
      subGrids[8] = new int[]{0, 4, 0, 0, 0, 0, 0, 0, 6};

      return SudokuGridFactory.createNewSudoku(subGrids);
   }

   private SudokuGridCalk createTestSudokuGridCalkForNumber5() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[1] = new int[]{8, 8, 8, 8, 8, 8, 0, 0, 0};
      subGrids[2] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};

      subGrids[3] = new int[]{0, 8, 0, 8, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{0, 8, 0, 8, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 8, 0, 8, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 8, 0, 8, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 8, 0, 8, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{0, 8, 0, 8, 0, 0, 0, 0, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createTestSudokuGridCalkForNumber2() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 8, 0, 8, 0, 8, 8, 8};
      subGrids[1] = new int[]{0, 0, 8, 0, 8, 0, 8, 8, 8};
      subGrids[2] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};

      subGrids[3] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[4] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[5] = new int[]{8, 8, 8, 8, 8, 8, 8, 0, 0};

      subGrids[6] = new int[]{0, 0, 8, 0, 8, 0, 8, 0, 0};
      subGrids[7] = new int[]{0, 0, 8, 0, 8, 0, 8, 0, 0};
      subGrids[8] = new int[]{0, 0, 8, 0, 8, 0, 8, 0, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }
}
