package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class SudokuGridCalkColumnTest {

   @Test
   public void hasToSetUnavailableAColumn() {
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createEmptySudokuGridCalk();

      sudokuGridCalk.setColumnUnavailable(2, 4);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk1()));

      sudokuGridCalk.setColumnUnavailable(3, 0);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk2()));

      sudokuGridCalk.setColumnUnavailable(8, 8);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk3()));

      sudokuGridCalk.setColumnUnavailableForOtherSubGrid(0, 4);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk4()));

      sudokuGridCalk.setColumnUnavailableForOtherSubGrid(7, 7);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk5()));

      sudokuGridCalk.setColumnUnavailableForOtherSubGrid(4, 2);
      Assert.assertTrue(sudokuGridCalk.equals(createSudokuGridCalk6()));
   }

   private SudokuGridCalk createSudokuGridCalk1() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};

      subGrids[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk2() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[1] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[2] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};

      subGrids[3] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[4] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[5] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};

      subGrids[6] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[7] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};
      subGrids[8] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 0};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk3() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[1] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[2] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};

      subGrids[3] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[4] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[5] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};

      subGrids[6] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[7] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[8] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk4() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[1] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};
      subGrids[2] = new int[]{8, 0, 0, 0, 0, 0, 0, 8, 8};

      subGrids[3] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};
      subGrids[4] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};
      subGrids[5] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};

      subGrids[6] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};
      subGrids[7] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};
      subGrids[8] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk5() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 0, 0, 0, 8, 0, 0, 8, 8};
      subGrids[1] = new int[]{8, 0, 0, 0, 8, 0, 0, 8, 8};
      subGrids[2] = new int[]{8, 0, 0, 0, 8, 0, 0, 8, 8};

      subGrids[3] = new int[]{8, 8, 0, 0, 8, 0, 0, 8, 8};
      subGrids[4] = new int[]{8, 8, 0, 0, 8, 0, 0, 8, 8};
      subGrids[5] = new int[]{8, 8, 0, 0, 8, 0, 0, 8, 8};

      subGrids[6] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};
      subGrids[7] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};
      subGrids[8] = new int[]{8, 8, 0, 0, 0, 0, 0, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }

   private SudokuGridCalk createSudokuGridCalk6() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{8, 0, 0, 0, 8, 8, 0, 8, 8};
      subGrids[1] = new int[]{8, 0, 0, 0, 8, 8, 0, 8, 8};
      subGrids[2] = new int[]{8, 0, 0, 0, 8, 8, 0, 8, 8};

      subGrids[3] = new int[]{8, 8, 0, 0, 8, 0, 0, 8, 8};
      subGrids[4] = new int[]{8, 8, 0, 0, 8, 0, 0, 8, 8};
      subGrids[5] = new int[]{8, 8, 0, 0, 8, 0, 0, 8, 8};

      subGrids[6] = new int[]{8, 8, 0, 0, 0, 8, 0, 8, 8};
      subGrids[7] = new int[]{8, 8, 0, 0, 0, 8, 0, 8, 8};
      subGrids[8] = new int[]{8, 8, 0, 0, 0, 8, 0, 8, 8};

      return SudokuGridFactory.createNewSudokuCalk(subGrids);
   }
}
