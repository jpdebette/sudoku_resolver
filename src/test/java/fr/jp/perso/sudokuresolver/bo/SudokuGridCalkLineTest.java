package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class SudokuGridCalkLineTest {

   @Test
   public void hasToSetUnavailableALine() {
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      sudokuGridCalk.setLineUnavailable(2, 4);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk1()));

      sudokuGridCalk.setLineUnavailable(3, 0);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk2()));

      sudokuGridCalk.setLineUnavailable(8, 8);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk3()));

      sudokuGridCalk.setLineUnavailableForOtherSubGrid(0, 6);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk4()));

      sudokuGridCalk.setLineUnavailableForOtherSubGrid(7, 5);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk5()));

      sudokuGridCalk.setLineUnavailableForOtherSubGrid(5, 8);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk6()));
   }

   private SudokuGridCalk createSudokuGridCalk1() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

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

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk3() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk4() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[2] = new int[]{0, 0, 0, 8, 8, 8, 8, 8, 8};

      subGrids[3] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk5() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[2] = new int[]{0, 0, 0, 8, 8, 8, 8, 8, 8};

      subGrids[3] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{8, 8, 8, 0, 0, 0, 8, 8, 8};
      subGrids[8] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk6() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[2] = new int[]{0, 0, 0, 8, 8, 8, 8, 8, 8};

      subGrids[3] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{8, 8, 8, 8, 8, 8, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{8, 8, 8, 0, 0, 0, 8, 8, 8};
      subGrids[8] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }
}
