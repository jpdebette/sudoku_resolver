package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class SubGridCalkTest {

   @Test
   public void hasToSetUnavailableASubGrid() {
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createSudokuGridCalk();
      SubGridCalk emptySubGridCalk = new SubGridCalk(0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
      SubGridCalk fullSubGridCalk = new SubGridCalk(0, new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8});

      sudokuGridCalk.getSubGrid(0).setEntireSubGridUnavailable();

      Assert.assertTrue(fullSubGridCalk.equals(sudokuGridCalk.getSubGrid(0)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(1)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(2)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(3)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(4)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(5)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(6)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(7)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(8)));

      sudokuGridCalk.getSubGrid(4).setEntireSubGridUnavailable();
      Assert.assertTrue(fullSubGridCalk.equals(sudokuGridCalk.getSubGrid(0)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(1)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(2)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(3)));
      Assert.assertTrue(fullSubGridCalk.equals(sudokuGridCalk.getSubGrid(4)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(5)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(6)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(7)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(8)));

      sudokuGridCalk.getSubGrid(8).setEntireSubGridUnavailable();
      Assert.assertTrue(fullSubGridCalk.equals(sudokuGridCalk.getSubGrid(0)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(1)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(2)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(3)));
      Assert.assertTrue(fullSubGridCalk.equals(sudokuGridCalk.getSubGrid(4)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(5)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(6)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(7)));
      Assert.assertTrue(fullSubGridCalk.equals(sudokuGridCalk.getSubGrid(8)));
   }
}
