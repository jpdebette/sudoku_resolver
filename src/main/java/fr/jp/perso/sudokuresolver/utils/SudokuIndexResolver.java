package fr.jp.perso.sudokuresolver.utils;

public class SudokuIndexResolver {

   public static int[] getSubGridLineIndexesPerIndex(int subGridIndex) {
      SudokuValidator.validateSubGridIndex(subGridIndex);
      return getLineIndexesPerIndex(subGridIndex);
   }

   public static int[] getSubGridColumnIndexesPerIndex(int subGridIndex) {
      SudokuValidator.validateSubGridIndex(subGridIndex);
      return getColumnIndexPerIndex(subGridIndex);
   }

   public static int[] getSquareLineIndexesPerIndex(int squareIndex) {
      SudokuValidator.validateSquareIndex(squareIndex);
      return getLineIndexesPerIndex(squareIndex);
   }

   public static int[] getSquareColumnIndexesPerIndex(int squareIndex) {
      SudokuValidator.validateSquareIndex(squareIndex);
      return getColumnIndexPerIndex(squareIndex);
   }

   private static int[] getLineIndexesPerIndex(int subGridIndex) {
      if (subGridIndex == 0 || subGridIndex == 1 || subGridIndex == 2) {
         return new int[]{0, 1, 2};
      } else if (subGridIndex == 3 || subGridIndex == 4 || subGridIndex == 5) {
         return new int[]{3, 4, 5};
      } else {
         return new int[]{6, 7, 8};
      }
   }

   private static int[] getColumnIndexPerIndex(int subGridIndex) {
      if (subGridIndex == 0 || subGridIndex == 3 || subGridIndex == 6) {
         return new int[]{0, 3, 6};
      } else if (subGridIndex == 1 || subGridIndex == 4 || subGridIndex == 7) {
         return new int[]{1, 4, 7};
      } else {
         return new int[]{2, 5, 8};
      }
   }
}
