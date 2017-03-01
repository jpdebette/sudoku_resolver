package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class SudokuGridCalkTest {

   @Test
   public void hasToSetUnavailableOccupiedPositions() {

   }

   @Test
   public void hasToSetUnavailableALine() {
      SudokuGridCalk sudokuGridCalk = SudokuGridFactory.createSudokuGridCalk();

      sudokuGridCalk.setLineUnavailable(2, 4);
      SubGridCalk emptySubGridCalk = new SubGridCalk(0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
      SubGridCalk firstLineUnavailableSubGridCalk = new SubGridCalk(0, new int[]{8, 8, 8, 0, 0, 0, 0, 0, 0});
      SubGridCalk secondLineUnavailableSubGridCalk = new SubGridCalk(0, new int[]{0, 0, 0, 8, 8, 8, 0, 0, 0});
      SubGridCalk thirdLineUnavailableSubGridCalk = new SubGridCalk(0, new int[]{0, 0, 0, 0, 0, 0, 8, 8, 8});
      SubGridCalk firstAndThirdLineUnavailableSubGridCalk = new SubGridCalk(0, new int[]{8, 8, 8, 0, 0, 0, 8, 8, 8});
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(0)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(1)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(2)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(3)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(4)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(5)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(6)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(7)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(8)));

      sudokuGridCalk.setLineUnavailable(3, 0);
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(0)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(1)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(2)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(3)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(4)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(5)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(6)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(7)));
      Assert.assertTrue(emptySubGridCalk.equals(sudokuGridCalk.getSubGrid(8)));

      sudokuGridCalk.setLineUnavailable(8, 8);
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(0)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(1)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(2)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(3)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(4)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(5)));
      Assert.assertTrue(thirdLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(6)));
      Assert.assertTrue(thirdLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(7)));
      Assert.assertTrue(thirdLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(8)));

      sudokuGridCalk.setLineUnavailable(7, 1);
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(0)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(1)));
      Assert.assertTrue(secondLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(2)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(3)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(4)));
      Assert.assertTrue(firstLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(5)));
      Assert.assertTrue(firstAndThirdLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(6)));
      Assert.assertTrue(firstAndThirdLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(7)));
      Assert.assertTrue(firstAndThirdLineUnavailableSubGridCalk.equals(sudokuGridCalk.getSubGrid(8)));
   }
}
