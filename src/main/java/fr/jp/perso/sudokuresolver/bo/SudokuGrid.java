package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.supervisor.StateListener;
import fr.jp.perso.sudokuresolver.utils.SudokuValidator;

import java.util.List;

public class SudokuGrid<T extends SubGrid> {
   protected final List<T> subGrids;

   public SudokuGrid(List<T> subGrids) {
      validateSubGrids(subGrids);
      this.subGrids = subGrids;
   }

   public T getSubGrid(int index) {
      SudokuValidator.validateSubGridIndex(index);
      return subGrids.get(index);
   }

   private void validateSubGrids(List<T> subGrids) {
      if (subGrids == null) {
         throw new RuntimeException("subGrids can not be null.");
      }
      if (subGrids.size() != 9) {
         throw new RuntimeException("subGrids size has to be 9. Current is: " + subGrids.size());
      }
   }

   public void initStateListener(StateListener stateListener) {
      for (SubGrid subGrid : subGrids) {
         subGrid.initStateListener(stateListener);
      }
   }

   public void display() {
      for (int subGridStartIndex = 0; subGridStartIndex <= 6; subGridStartIndex += 3) {
         printSeparatorLine();
         for (int squareStartIndex = 0; squareStartIndex <= 6; squareStartIndex += 3) {
            printLine(subGridStartIndex, squareStartIndex);
         }
      }
      printSeparatorLine();
   }

   private void printSeparatorLine() {
      System.out.println("-------------------");
   }

   private void printLine(int subGridStartIndex, int squareStartIndex) {
      for (int i = subGridStartIndex; i < subGridStartIndex + 3; i++) {
         System.out.print("|");
         System.out.print(subGrids.get(i).getSquare(squareStartIndex) + " ");
         System.out.print(subGrids.get(i).getSquare(squareStartIndex + 1) + " ");
         System.out.print(subGrids.get(i).getSquare(squareStartIndex + 2));
      }
      System.out.println("|");
   }
}
