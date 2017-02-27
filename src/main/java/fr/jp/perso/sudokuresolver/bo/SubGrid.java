package fr.jp.perso.sudokuresolver.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubGrid {
   List<Square> squares = Arrays.asList(new Square[9]);

   public SubGrid(Integer[] values) {
      validateValues(values);

      for (int i = 0; i < values.length; i++) {
         setSquare(i, new Square(values[i]));
      }
   }

   public void setSquare(int index, Square square) {
      validateIndex(index);
      squares.set(index, square);
   }

   public Square getSquare(int index) {
      validateIndex(index);
      return squares.get(index);
   }

   public boolean hasValue(Integer value) {
      if (value == null) {
         throw new RuntimeException("value cannot be null.");
      }
      for (Square square : squares) {
         if (value.equals(square.getValue())) {
            return true;
         }
      }
      return false;
   }

   public List<Integer> getAvailablePositions() {
      List<Integer> availablePositions = new ArrayList<>();

      for (int index = 0; index <= 8; index++) {
         Square square = squares.get(index);
         if (square.isUnknow()) {
            availablePositions.add(index);
         }
      }
      return availablePositions;
   }

   private static void validateValues(Integer[] values) {
      if (values == null) {
         throw new RuntimeException("values cannot be null.");
      }
      if (values.length != 9) {
         throw new RuntimeException("values length has to be 9. Received: " + values.length);
      }
   }

   private void validateIndex(int index) {
      if (index < 0 || index > 8) {
         throw new RuntimeException("index should be between 0 and 8. Received: " + index);
      }
   }
}
