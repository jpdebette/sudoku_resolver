package fr.jp.perso.sudokuresolver.bo;

import fr.jp.perso.sudokuresolver.utils.SudokuValidator;

import java.util.HashSet;
import java.util.Set;

public class Square {
   private int value;
   private Set<Integer> possibleValues = new HashSet<>(0);

   Square(int value) {
      SudokuValidator.validateSquareValue(value);
      setValue(value);
   }

   public int getValue() {
      return value;
   }

   void setValue(int value) {
      SudokuValidator.validateSquareValue(value);
      this.value = value;
   }

   public void addPossibleValue(int possibleValue) {
      if (!isUnknow()) {
         throw new RuntimeException("Cannot add a possible value to a know square.");
      }
      SudokuValidator.validateSquareValue(possibleValue);
      boolean result = possibleValues.add(possibleValue);
      if (!result) {
         throw new RuntimeException("Cannot add possible value: " + possibleValue);
      }
   }

   public void removePossibleValue(int possibleValue) {
      SudokuValidator.validateSquareValue(possibleValue);
      boolean result = possibleValues.remove(possibleValue);
      if (!result) {
         throw new RuntimeException("Cannot remove possible value: " + possibleValue);
      }
   }

   public boolean isPossibleValue(int possibleValue) {
      SudokuValidator.validateSquareValue(possibleValue);
      return possibleValues.contains(possibleValue);
   }

   boolean isUnknow() {
      return value == 0;
   }

   @Override
   public String toString() {
      if (value == 0) {
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
