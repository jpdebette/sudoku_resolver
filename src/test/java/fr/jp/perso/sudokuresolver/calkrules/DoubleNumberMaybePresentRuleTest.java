package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class DoubleNumberMaybePresentRuleTest {

   @Test
   public void hasToFindDoubleNumber() {
      DoubleNumberMaybePresentRule doubleNumberMaybePresentRule = new DoubleNumberMaybePresentRule(null);
      SudokuGrid sudokuGrid = SudokuGridFactory.createEmptySudokuGrid();
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      sudokuGrid.getSubGrid(5).getSquare(4).addPossibleValue(1);
      sudokuGrid.getSubGrid(5).getSquare(7).addPossibleValue(1);
      sudokuGrid.getSubGrid(6).getSquare(4).addPossibleValue(1);
      sudokuGrid.getSubGrid(6).getSquare(5).addPossibleValue(1);

      doubleNumberMaybePresentRule.applyRule(sudokuGrid, sudokuGridCalk, 1);

      Assert.assertTrue(sudokuGridCalk.equals(createTestSudokuGridCalkFor1()));
   }

   @Test
   public void hasToFindDoubleNumberWithLinkedSquare() {
      DoubleNumberMaybePresentRule doubleNumberMaybePresentRule = new DoubleNumberMaybePresentRule(null);
      SudokuGrid sudokuGrid = SudokuGridFactory.createEmptySudokuGrid();
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      sudokuGrid.getSubGrid(5).getSquare(0).addPossibleValue(1);
      sudokuGrid.getSubGrid(5).getSquare(0).addPossibleValue(4);
      sudokuGrid.getSubGrid(5).getSquare(0).addPossibleValue(6);
      sudokuGrid.getSubGrid(5).getSquare(1).addPossibleValue(1);
      sudokuGrid.getSubGrid(5).getSquare(1).addPossibleValue(4);
      sudokuGrid.getSubGrid(5).getSquare(1).addPossibleValue(6);
      sudokuGrid.getSubGrid(5).getSquare(4).addPossibleValue(1);
      sudokuGrid.getSubGrid(5).getSquare(7).addPossibleValue(1);
      sudokuGrid.getSubGrid(6).getSquare(4).addPossibleValue(1);
      sudokuGrid.getSubGrid(6).getSquare(5).addPossibleValue(1);

      doubleNumberMaybePresentRule.applyRule(sudokuGrid, sudokuGridCalk, 1);

      Assert.assertTrue(sudokuGridCalk.equals(createTestSudokuGridCalkFor1()));
   }

   private SudokuGridCalk createTestSudokuGridCalkFor1() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};

      subGrids[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[7] = new int[]{0, 0, 0, 8, 8, 8, 8, 8, 8};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }
}
