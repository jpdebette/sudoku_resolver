package fr.jp.perso.sudokuresolver.calkrules;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OccupiedPositionRuleTest {

   @Test
   public void hasToSetUnavailableOccupiedPosition() {
      OccupiedPositionRule occupiedPositionRule = new OccupiedPositionRule(null);
      SudokuGrid sudokuGrid = createTestSudokuGrid();
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      occupiedPositionRule.applyRule(sudokuGrid, sudokuGridCalk, 0);

      SudokuGridCalk sudokuGridCalkReference = createTestSudokuGridCalk();
      Assert.assertTrue(sudokuGridCalkReference.equals(sudokuGridCalk));
   }

   private SudokuGrid createTestSudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<>(9);
      int index = 0;

      subGrids.add(new SubGrid(index++, new int[]{0, 5, 0, 0, 0, 0, 1, 0, 4}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 9, 0, 6, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 8, 5, 9, 0, 2, 0, 0}));

      subGrids.add(new SubGrid(index++, new int[]{0, 7, 2, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{4, 0, 0, 6, 2, 0, 0, 0, 3}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 8, 0, 0, 0, 7}));

      subGrids.add(new SubGrid(index++, new int[]{0, 8, 0, 4, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 9, 0, 0, 0, 1}));
      subGrids.add(new SubGrid(index, new int[]{0, 4, 0, 0, 0, 0, 0, 0, 6}));

      return new SudokuGrid(subGrids);
   }

   private SudokuGridCalk createTestSudokuGridCalk() {
      List<SubGridCalk> subGridCalks = new ArrayList<>(9);
      int index = 0;

      subGridCalks.add(new SubGridCalk(index++, new int[]{0, 8, 0, 0, 0, 0, 8, 0, 8}));
      subGridCalks.add(new SubGridCalk(index++, new int[]{0, 0, 8, 0, 8, 0, 0, 0, 0}));
      subGridCalks.add(new SubGridCalk(index++, new int[]{0, 0, 8, 8, 8, 0, 8, 0, 0}));

      subGridCalks.add(new SubGridCalk(index++, new int[]{0, 8, 8, 0, 0, 0, 0, 0, 0}));
      subGridCalks.add(new SubGridCalk(index++, new int[]{8, 0, 0, 8, 8, 0, 0, 0, 8}));
      subGridCalks.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 8, 0, 0, 0, 8}));

      subGridCalks.add(new SubGridCalk(index++, new int[]{0, 8, 0, 8, 0, 0, 0, 0, 0}));
      subGridCalks.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 8, 0, 0, 0, 8}));
      subGridCalks.add(new SubGridCalk(index, new int[]{0, 8, 0, 0, 0, 0, 0, 0, 8}));

      return new SudokuGridCalk(subGridCalks);
   }
}
