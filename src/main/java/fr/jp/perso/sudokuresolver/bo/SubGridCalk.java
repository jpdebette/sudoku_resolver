package fr.jp.perso.sudokuresolver.bo;

public class SubGridCalk extends SubGrid {

   public SubGridCalk(int index, int[] values) {
      super(index, values);
   }

   public void setEntireSubGridUnavailable() {
      for (Integer index : getAvailablePositions()) {
         setSquareValue(index, SudokuGridCalk.UNAVAILABLE_POSITION);
      }
   }

   public void setUnavailableOccupiedPositions(SubGrid currentSubGrid) {
      for (int squareIndex = 0; squareIndex <= 8; squareIndex++) {
         Square square = currentSubGrid.getSquare(squareIndex);
         if (!square.isUnknow() && getSquare(squareIndex).isUnknow()) {
            setSquareValue(squareIndex, SudokuGridCalk.UNAVAILABLE_POSITION);
         }
      }
   }

   @Override
   protected void validateValues(int[] values) {
      if (values == null) {
         throw new RuntimeException("values cannot be null.");
      }
      if (values.length != 9) {
         throw new RuntimeException("values length has to be 9. Received: " + values.length);
      }

      for (int value : values) {
         if (value != 0 && value != SudokuGridCalk.UNAVAILABLE_POSITION) {
            throw new RuntimeException(String.format("Cannot put %s in a calk sub grid.", value));
         }
      }
   }

   @Override
   public void setSquareValue(int index, int value) {
      if (value != SudokuGridCalk.UNAVAILABLE_POSITION) {
         throw new RuntimeException(String.format("Cannot set %s in calk.", value));
      }
      getSquare(index).setValue(value);
   }
}
