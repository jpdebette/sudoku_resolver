package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.supervisor.StateEvent;
import fr.jp.perso.sudokuresolver.supervisor.StateListener;
import fr.jp.perso.sudokuresolver.utils.SudokuValidator;

import java.util.*;

public class SubGrid {
   private final int index;
   private StateListener stateListener;
   private List<Square> squares = Arrays.asList(new Square[9]);

   public SubGrid(int index, int[] values) {
      SudokuValidator.validateSubGridIndex(index);
      this.index = index;

      validateValues(values);
      for (int i = 0; i < values.length; i++) {
         squares.set(i, new Square(values[i]));
      }
   }

   public int getIndex() {
      return index;
   }

   protected void validateValues(int[] values) {
      if (values == null) {
         throw new RuntimeException("values cannot be null.");
      }
      if (values.length != 9) {
         throw new RuntimeException("values length has to be 9. Received: " + values.length);
      }

      Set<Integer> testDuplicateValues = new HashSet<>(9);
      for (int value : values) {
         if (value == 0) {
            continue;
         }
         if (!testDuplicateValues.add(value)) {
            throw new RuntimeException("Cannot add twice the same value: " + value);
         }
      }
   }

   public Square getSquare(int squareIndex) {
      SudokuValidator.validateSquareIndex(squareIndex);
      return squares.get(squareIndex);
   }

   public void setSquareValue(int squareIndex, int value) {
      SudokuValidator.validateSquareIndex(squareIndex);
      squares.get(squareIndex).setValue(value);

      if (stateListener != null) {
         StateEvent stateEvent = new StateEvent(this.index, squareIndex, value);
         stateListener.stateChanged(stateEvent);
      }
   }

   public int getIndexNumber(int number) {
      for (int index = 0; index <= 8; index++) {
         Square square = squares.get(index);
         if (square.getValue() == number) {
            return index;
         }
      }
      return -1;
   }

   public List<Integer> getAvailablePositions() {
      List<Integer> availablePositions = new ArrayList<>();

      for (int squareIndex = 0; squareIndex <= 8; squareIndex++) {
         Square square = squares.get(squareIndex);
         if (square.isUnknow()) {
            availablePositions.add(squareIndex);
         }
      }
      return availablePositions;
   }

   public List<Integer> getPossiblePositions(int number) {
      List<Integer> possiblePositions = new ArrayList<>();

      for (int squareIndex = 0; squareIndex <= 8; squareIndex++) {
         Square square = squares.get(squareIndex);
         if (square.isPossibleValue(number)) {
            possiblePositions.add(squareIndex);
         }
      }
      return possiblePositions;
   }

   public void initStateListener(StateListener stateListener) {
      this.stateListener = stateListener;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof SubGrid)) {
         return false;
      }
      SubGrid subGridObj = (SubGrid) obj;
      for (int index = 0; index <= 8; index++) {
         if (!this.squares.get(index).equals(subGridObj.squares.get(index))) {
            return false;
         }
      }
      return true;
   }
}
