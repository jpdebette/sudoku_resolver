package fr.jp.perso.sudokuresolver.bo;

import java.util.HashSet;
import java.util.Set;

public class Square {
   private int value;
   private Set<Integer> possibleValues = new HashSet<>(0);

   public Square(int value) {
      validateValue(value);
      this.value = value;
   }

   public int getValue() {
      return value;
   }

   void setSquareValue(int value) {
      validateValue(value);
      this.value = value;
      possibleValues.clear();
   }

   public static void validateValue(int value) {
      if (value < 0 || value > 9) {
         throw new RuntimeException("value has to be between 0 and 9. Received: " + value);
      }
   }

   public void addPossibleValue(int possibleValue) {
      validateValue(possibleValue);
      boolean result = possibleValues.add(possibleValue);
      if (!result) {
         throw new RuntimeException("Cannot add possible value: " + possibleValue);
      }
   }

   public void removePossibleValue(int possibleValue) {
      validateValue(possibleValue);
      boolean result = possibleValues.remove(new Integer(possibleValue));
      if (!result) {
         throw new RuntimeException("Cannot remove possible value: " + possibleValue);
      }
   }

   public boolean isPossibleValue(int possibleValue) {
      validateValue(possibleValue);
      return possibleValues.contains(possibleValue);
   }

   public boolean isUnknow() {
      return value == 0;
   }

   @Override
   public String toString() {
      if (value == 0) {
         if (!possibleValues.isEmpty()) {
            return "*";
         }
         return " ";
      }
      return String.valueOf(value);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof Square)) {
         return false;
      }
      Square squareObj = (Square) obj;
      return this.value == squareObj.value;
   }
}
