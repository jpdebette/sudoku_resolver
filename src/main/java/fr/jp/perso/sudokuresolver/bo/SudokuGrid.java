package fr.jp.perso.sudokuresolver.bo;

import java.util.List;

public class SudokuGrid {
   private final List<SubGrid> subGrids;

   public SudokuGrid(List<SubGrid> subGrids) {
      validateSubGrids(subGrids);
      this.subGrids = subGrids;
   }

   public SubGrid getSubGrid(int index) {
      if(index < 0 || index > 8) {
         throw new RuntimeException("Index should be between 0 and 8. Received: " + index);
      }
      return subGrids.get(index);
   }

   private void validateSubGrids(List<SubGrid> subGrids) {
      if (subGrids == null) {
         throw new RuntimeException("subGrids can not be null.");
      }
      if (subGrids.size() != 9) {
         throw new RuntimeException("subGrids size has to be 9. Current is: " + subGrids.size());
      }
   }

   public void display() {
      for (int subGridStartIndex = 0; subGridStartIndex <= 6; subGridStartIndex += 3) {
         printSeparatorLine();
         for (int squareStartIndex = 0; squareStartIndex <= 6; squareStartIndex +=3) {
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
