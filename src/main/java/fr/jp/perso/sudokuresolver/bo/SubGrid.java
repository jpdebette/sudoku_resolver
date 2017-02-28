package fr.jp.perso.sudokuresolver.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubGrid {
   protected List<Square> squares = Arrays.asList(new Square[9]);

   public SubGrid(int[] values) {
      validateValues(values);

      for (int i = 0; i < values.length; i++) {
         setSquare(i, new Square(values[i]));
      }
   }

   public void setSquare(int squareIndex, Square square) {
      validateSquareIndex(squareIndex);
      squares.set(squareIndex, square);
   }

   public Square getSquare(int squareIndex) {
      validateSquareIndex(squareIndex);
      return squares.get(squareIndex);
   }

   public void setSquareValue(int squareIndex, int value) {
      Square.validateValue(value);
      validateSquareIndex(squareIndex);
      squares.get(squareIndex).setSquareValue(value);
   }

   public int getIndex(int value) {
      for (int index = 0; index <= 8; index++) {
         Square square = squares.get(index);
         if (square.getValue() == value) {
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

   public static void validateSquareIndex(int squareIndex) {
      if (squareIndex < 0 || squareIndex > 8) {
         throw new RuntimeException("index should be between 0 and 8. Received: " + squareIndex);
      }
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
