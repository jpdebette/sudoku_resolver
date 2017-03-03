package fr.jp.perso.sudokuresolver;

import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.supervisor.StateEvent;
import fr.jp.perso.sudokuresolver.supervisor.SudokuSupervisor;
import fr.jp.perso.sudokuresolver.utils.SudokuGridFactory;
import org.junit.Assert;
import org.junit.Test;

public class SudokuSupervisorTest {

   @Test
   public void test() {
      SudokuGrid sudokuGrid = SudokuGridFactory.createEmptySudokuGrid();
      sudokuGrid.getSubGrid(0).getSquare(8).addPossibleValue(3);
      sudokuGrid.getSubGrid(0).getSquare(8).addPossibleValue(9);
      sudokuGrid.getSubGrid(3).getSquare(1).addPossibleValue(4);
      sudokuGrid.getSubGrid(3).getSquare(1).addPossibleValue(7);
      sudokuGrid.getSubGrid(4).getSquare(0).addPossibleValue(7);
      sudokuGrid.getSubGrid(4).getSquare(0).addPossibleValue(8);
      sudokuGrid.getSubGrid(4).getSquare(7).addPossibleValue(4);
      sudokuGrid.getSubGrid(4).getSquare(7).addPossibleValue(7);
      sudokuGrid.getSubGrid(7).getSquare(0).addPossibleValue(4);
      sudokuGrid.getSubGrid(7).getSquare(0).addPossibleValue(7);
      sudokuGrid.getSubGrid(7).getSquare(1).addPossibleValue(4);
      sudokuGrid.getSubGrid(8).getSquare(1).addPossibleValue(4);
      sudokuGrid.getSubGrid(8).getSquare(1).addPossibleValue(7);

      SudokuSupervisor sudokuSupervisor = new SudokuSupervisor(sudokuGrid);
      StateEvent stateEvent = new StateEvent(4, 0, 7);
      sudokuSupervisor.stateChanged(stateEvent);

      Assert.assertTrue(sudokuGrid.getSubGrid(0).getSquare(8).isPossibleValue(3));
      Assert.assertTrue(sudokuGrid.getSubGrid(0).getSquare(8).isPossibleValue(9));
      Assert.assertTrue(sudokuGrid.getSubGrid(3).getSquare(1).isPossibleValue(4));
      Assert.assertTrue(!sudokuGrid.getSubGrid(3).getSquare(1).isPossibleValue(7));
      Assert.assertTrue(!sudokuGrid.getSubGrid(4).getSquare(0).isPossibleValue(7));
      Assert.assertTrue(!sudokuGrid.getSubGrid(4).getSquare(0).isPossibleValue(8));
      Assert.assertTrue(sudokuGrid.getSubGrid(4).getSquare(7).isPossibleValue(4));
      Assert.assertTrue(!sudokuGrid.getSubGrid(4).getSquare(7).isPossibleValue(7));
      Assert.assertTrue(sudokuGrid.getSubGrid(7).getSquare(0).isPossibleValue(4));
      Assert.assertTrue(!sudokuGrid.getSubGrid(7).getSquare(0).isPossibleValue(7));
      Assert.assertTrue(sudokuGrid.getSubGrid(7).getSquare(1).isPossibleValue(4));
      Assert.assertTrue(sudokuGrid.getSubGrid(8).getSquare(1).isPossibleValue(4));
      Assert.assertTrue(sudokuGrid.getSubGrid(8).getSquare(1).isPossibleValue(7));
   }

   /*private static int[][] createEmptyGrid() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[2] = new int[]{0, 0, X, 0, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{0, X, 0, 7, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, X, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, X, X, 0, 0, X, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      return subGrids;
   }*/
}
