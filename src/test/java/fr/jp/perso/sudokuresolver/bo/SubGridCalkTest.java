package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class SubGridCalkTest {

   @Test
   public void hasToSetUnavailableASubGrid() {
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      sudokuGridCalk.getSubGrid(0).setEntireSubGridUnavailable();
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk1()));

      sudokuGridCalk.getSubGrid(4).setEntireSubGridUnavailable();
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk2()));

      sudokuGridCalk.getSubGrid(8).setEntireSubGridUnavailable();
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk3()));
   }

   private SudokuGridCalk createSudokuGridCalk1() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};
      subGrids[2] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk2() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};
      subGrids[2] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{0, 0, 0, 8, 8, 8, 0, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 8, 8, 8, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 8, 8, 8, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk3() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};
      subGrids[2] = new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{0, 0, 0, 8, 8, 8, 0, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 8, 8, 8, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 8, 8, 8, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 8, 8, 8};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 8, 8, 8};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 8, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }
}
