package fr.jp.perso.sudokuresolver.bo;

import java.util.ArrayList;
import java.util.List;

public class Square {
   private int value;
   private List<Integer> possibleValues = new ArrayList<Integer>(0);

   public Square() {
   }

   public Square(int value) {
      validateValue(value);
      this.value = value;
   }

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      validateValue(value);
      this.value = value;
      possibleValues.clear();
   }

   private void validateValue(int value) {
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

   public boolean isPossibleValue(Integer possibleValue) {
      validateValue(possibleValue);
      return possibleValues.contains(possibleValue);
   }

   public boolean isUnknow() {
      return value == 0;
   }

   @Override
   public String toString() {
      if (value == 0) {
         return " ";
      }
      return String.valueOf(value);
   }
}
