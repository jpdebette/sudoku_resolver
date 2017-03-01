package fr.jp.perso.sudokuresolver.utils;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;

import java.util.ArrayList;
import java.util.List;

public class SudokuValidator {
   public static void validateSubGridIndex(int index) {
      if (index < 0 || index > 8) {
         throw new RuntimeException("Index should be between 0 and 8. Received: " + index);
      }
   }

   public static void validateSquareIndex(int squareIndex) {
      if (squareIndex < 0 || squareIndex > 8) {
         throw new RuntimeException("index should be between 0 and 8. Received: " + squareIndex);
      }
   }

   public static void validateSquareValue(int value) {
      if (value < 0 || value > 9) {
         throw new RuntimeException("value has to be between 0 and 9. Received: " + value);
      }
   }

   public static void validateSudokuGrid(SudokuGrid sudokuGrid) {
      if (sudokuGrid == null) {
         throw new RuntimeException("sudokuGrid is null.");
      }
      for (int subGridIndex = 0; subGridIndex <= 8; subGridIndex++) {
         SubGrid subGrid = sudokuGrid.getSubGrid(subGridIndex);
         validateSubGrid(subGrid);
      }
      for (int lineIndex = 0; lineIndex <= 8; lineIndex++) {
         validateLineIndex(sudokuGrid, lineIndex);
      }

      for (int columnIndex = 0; columnIndex <= 8; columnIndex++) {
         validateColumnIndex(sudokuGrid, columnIndex);
      }
   }

   private static void validateSubGrid(SubGrid subGrid) {
      if (subGrid == null) {
         throw new RuntimeException("subGrid is null.");
      }
      for (int number = 1; number <= 9; number++) {
         if (subGrid.getIndexNumber(number) == -1) {
            throw new RuntimeException(String.format("subGrid %s does not contain number: %s", subGrid.getIndex(), number));
         }
      }
   }

   private static void validateLineIndex(SudokuGrid sudokuGrid, int lineIndex) {
      List<Integer> lineValues = new ArrayList<>(9);
      int [] subGridLineIndexes = SudokuIndexResolver.getSubGridLineIndexesPerIndex(lineIndex);
      for (int subGridLineIndex : subGridLineIndexes) {
         int [] squareLineIndexes = SudokuIndexResolver.getSquareLineIndexesPerIndex(lineIndex);
         for (int squareLineIndex : squareLineIndexes) {
            lineValues.add(sudokuGrid.getSubGrid(subGridLineIndex).getSquare(squareLineIndex).getValue());
         }
      }
      for (int number = 1; number <= 9; number++) {
         if (!lineValues.contains(number)) {
            throw new RuntimeException(String.format("Line %s does not contain the value: %s", lineIndex, number));
         }
      }
   }

   private static void validateColumnIndex(SudokuGrid sudokuGrid, int columnIndex) {
      List<Integer> columnValues = new ArrayList<>(9);
      int [] subGridColumnIndexes = SudokuIndexResolver.getSubGridColumnIndexesPerIndex(columnIndex);
      for (int subGridColumnIndex : subGridColumnIndexes) {
         int [] squareColumnIndexes = SudokuIndexResolver.getSquareColumnIndexesPerIndex(columnIndex);
         for (int squareColumnIndex : squareColumnIndexes) {
            columnValues.add(sudokuGrid.getSubGrid(subGridColumnIndex).getSquare(squareColumnIndex).getValue());
         }
      }
      for (int number = 1; number <= 9; number++) {
         if (!columnValues.contains(number)) {
            throw new RuntimeException(String.format("Column %s does not contain the value: %s", columnIndex, number));
         }
      }
   }
}
