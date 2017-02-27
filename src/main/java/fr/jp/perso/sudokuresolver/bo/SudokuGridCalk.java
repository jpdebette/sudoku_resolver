package fr.jp.perso.sudokuresolver.bo;

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
      validateSubGridIndex(subGridIndex);
      int[] subGridsLine = SubGrid.getLineIndexPerIndex(subGridIndex);
      int[] squaresLine = SudokuGrid.getLineIndexPerIndex(squareIndex);
      for (int subGridLineIndex : subGridsLine) {
         SubGrid calkSubGrid = subGrids.get(subGridLineIndex);
         for (int squareLineIndex : squaresLine) {
            calkSubGrid.setSquareValue(squareLineIndex, UNAVAILABLE_POSITION);
         }
      }
   }

   public void setColumnUnavailable(int subGridIndex, int squareIndex) {
      validateSubGridIndex(subGridIndex);
      int[] subGridsColumn = SubGrid.getColumnIndexPerIndex(subGridIndex);
      int[] squaresColumn = SudokuGrid.getColumnIndexPerIndex(squareIndex);
      for (int subGridColumnIndex : subGridsColumn) {
         SubGrid calkSubGrid = subGrids.get(subGridColumnIndex);
         for (int squareColumnIndex : squaresColumn) {
            calkSubGrid.setSquareValue(squareColumnIndex, UNAVAILABLE_POSITION);
         }
      }
   }
}
