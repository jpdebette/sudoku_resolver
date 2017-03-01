package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.utils.SudokuIndexResolver;

import java.util.List;

public class SudokuGridCalk extends SudokuGrid<SubGridCalk> {

   protected static final int UNAVAILABLE_POSITION = 8;

   public SudokuGridCalk(List<SubGridCalk> subGrids) {
      super(subGrids);
   }

   public void setUnavailableOccupiedPositions(SudokuGrid sudokuGrid) {
      for (int subGridIndex = 0; subGridIndex <= 8; subGridIndex++) {
         SubGrid currentSubGrid = sudokuGrid.getSubGrid(subGridIndex);
         SubGridCalk currentSubGridCalk = subGrids.get(subGridIndex);
         currentSubGridCalk.setUnavailableOccupiedPositions(currentSubGrid);
      }
   }

   public void setLineUnavailable(int subGridIndex, int squareIndex) {
      int[] subGridsLine = SudokuIndexResolver.getSubGridLineIndexesPerIndex(subGridIndex);
      int[] squaresLine = SudokuIndexResolver.getSquareLineIndexesPerIndex(squareIndex);
      for (int subGridLineIndex : subGridsLine) {
         SubGrid calkSubGrid = subGrids.get(subGridLineIndex);
         for (int squareLineIndex : squaresLine) {
            calkSubGrid.setSquareValue(squareLineIndex, UNAVAILABLE_POSITION);
         }
      }
   }

   public void setLineUnavailableForOtherSubGrid(int subGridIndex, int squareIndex) {
      int[] subGridsLine = SudokuIndexResolver.getSubGridLineIndexesPerIndex(subGridIndex);
      int[] squaresLine = SudokuIndexResolver.getSquareLineIndexesPerIndex(squareIndex);
      for (int subGridLineIndex : subGridsLine) {
         if (subGridLineIndex != subGridIndex) {
            SubGrid calkSubGrid = subGrids.get(subGridLineIndex);
            for (int squareLineIndex : squaresLine) {
               calkSubGrid.setSquareValue(squareLineIndex, UNAVAILABLE_POSITION);
            }
         }
      }
   }

   public void setColumnUnavailable(int subGridIndex, int squareIndex) {
      int[] subGridsColumn = SudokuIndexResolver.getSubGridColumnIndexesPerIndex(subGridIndex);
      int[] squaresColumn = SudokuIndexResolver.getSquareColumnIndexesPerIndex(squareIndex);
      for (int subGridColumnIndex : subGridsColumn) {
         SubGrid calkSubGrid = subGrids.get(subGridColumnIndex);
         for (int squareColumnIndex : squaresColumn) {
            calkSubGrid.setSquareValue(squareColumnIndex, UNAVAILABLE_POSITION);
         }
      }
   }

   public void setColumnUnavailableForOtherSubGrid(int subGridIndex, int squareIndex) {
      int[] subGridsColumn = SudokuIndexResolver.getSubGridColumnIndexesPerIndex(subGridIndex);
      int[] squaresColumn = SudokuIndexResolver.getSquareColumnIndexesPerIndex(squareIndex);
      for (int subGridColumnIndex : subGridsColumn) {
         if (subGridColumnIndex != subGridIndex) {
            SubGrid calkSubGrid = subGrids.get(subGridColumnIndex);
            for (int squareColumnIndex : squaresColumn) {
               calkSubGrid.setSquareValue(squareColumnIndex, UNAVAILABLE_POSITION);
            }
         }
      }
   }
}
