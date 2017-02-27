package fr.jp.perso.sudokuresolver.bo;

import java.util.List;

public class SudokuGrid<T extends SubGrid> {
   protected final List<T> subGrids;

   public SudokuGrid(List<T> subGrids) {
      validateSubGrids(subGrids);
      this.subGrids = subGrids;
   }

   public T getSubGrid(int index) {
      validateSubGridIndex(index);
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

   protected static void validateSubGridIndex(int index) {
      if (index < 0 || index > 8) {
         throw new RuntimeException("Index should be between 0 and 8. Received: " + index);
      }
   }

   protected static int[] getLineIndexPerIndex(int subGridIndex) {
      validateSubGridIndex(subGridIndex);
      if (subGridIndex == 0 || subGridIndex == 1 || subGridIndex == 2) {
         return new int[]{0, 1, 2};
      } else if (subGridIndex == 3 || subGridIndex == 4 || subGridIndex == 5) {
         return new int[]{3, 4, 5};
      } else {
         return new int[]{6, 7, 8};
      }
   }

   protected static int[] getColumnIndexPerIndex(int subGridIndex) {
      validateSubGridIndex(subGridIndex);
      if (subGridIndex == 0 || subGridIndex == 3 || subGridIndex == 6) {
         return new int[]{0, 3, 6};
      } else if (subGridIndex == 1 || subGridIndex == 4 || subGridIndex == 7) {
         return new int[]{1, 4, 7};
      } else {
         return new int[]{2, 5, 8};
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
