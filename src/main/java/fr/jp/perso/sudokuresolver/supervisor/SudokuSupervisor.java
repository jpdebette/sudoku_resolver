package fr.jp.perso.sudokuresolver.supervisor;

import fr.jp.perso.sudokuresolver.bo.Square;
import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.utils.SudokuIndexResolver;
import fr.jp.perso.sudokuresolver.utils.SudokuValidator;

public class SudokuSupervisor implements StateListener {
   private final SudokuGrid sudokuGrid;

   public SudokuSupervisor(SudokuGrid sudokuGrid) {
      this.sudokuGrid = sudokuGrid;
   }

   @Override
   public void stateChanged(StateEvent event) {
      int subGridIndex = event.getSubGridIndex();
      SudokuValidator.validateSubGridIndex(subGridIndex);
      SubGrid subGrid = sudokuGrid.getSubGrid(subGridIndex);

      int squareIndex = event.getSquareIndex();
      SudokuValidator.validateSquareIndex(squareIndex);
      Square square = subGrid.getSquare(squareIndex);

      int newValue = event.getNewValue();
      SudokuValidator.validateSquareValue(newValue);

      clearAllSquarePossibleValues(square);
      clearSubGridPossibleValue(subGrid, newValue);
      clearSubGridColumnPossibleValue(subGridIndex, squareIndex, newValue);
      clearSubGridLinePossibleValue(subGridIndex, squareIndex, newValue);
   }

   private void clearAllSquarePossibleValues(Square square) {
      for (int possibleValue = 1; possibleValue <= 9; possibleValue++) {
         if (square.isPossibleValue(possibleValue)) {
            clearPossibleValue(square, possibleValue);
         }
      }
   }

   private void clearSubGridPossibleValue(SubGrid subGrid, int value) {
      for (int squareIndex = 0; squareIndex <= 8; squareIndex++) {
         if (subGrid.getSquare(squareIndex).isPossibleValue(value)) {
            clearPossibleValue(subGrid.getSquare(squareIndex), value);
         }
      }
   }

   private void clearSubGridColumnPossibleValue(int subGridIndex, int squareIndex, int value) {
      int[] subGridColumnIndexes = SudokuIndexResolver.getSubGridColumnIndexesPerIndex(subGridIndex);
      int[] squareColumnIndexes = SudokuIndexResolver.getSquareColumnIndexesPerIndex(squareIndex);
      for (int subGridColumnIndex : subGridColumnIndexes) {
         SubGrid subGrid = sudokuGrid.getSubGrid(subGridColumnIndex);
         for (int squareColumnIndex : squareColumnIndexes) {
            Square square = subGrid.getSquare(squareColumnIndex);
            if (square.isPossibleValue(value)) {
               clearPossibleValue(square, value);
            }
         }
      }
   }

   private void clearSubGridLinePossibleValue(int subGridIndex, int squareIndex, int value) {
      int[] subGridLineIndexes = SudokuIndexResolver.getSubGridLineIndexesPerIndex(subGridIndex);
      int[] squareLineIndexes = SudokuIndexResolver.getSquareLineIndexesPerIndex(squareIndex);
      for (int subGridLineIndex : subGridLineIndexes) {
         SubGrid subGrid = sudokuGrid.getSubGrid(subGridLineIndex);
         for (int squareLineIndex : squareLineIndexes) {
            Square square = subGrid.getSquare(squareLineIndex);
            if (square.isPossibleValue(value)) {
               clearPossibleValue(square, value);
            }
         }
      }
   }

   private void clearPossibleValue(Square square, int value) {
      square.removePossibleValue(value);
   }
}
