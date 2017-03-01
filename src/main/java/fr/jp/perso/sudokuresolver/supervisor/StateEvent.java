package fr.jp.perso.sudokuresolver.supervisor;

public class StateEvent {
   private final int subGridIndex;
   private final int squareIndex;
   private final int newValue;

   public StateEvent(int subGridIndex, int squareIndex, int newValue) {
      this.subGridIndex = subGridIndex;
      this.squareIndex = squareIndex;
      this.newValue = newValue;
   }

   public int getSubGridIndex() {
      return subGridIndex;
   }

   public int getSquareIndex() {
      return squareIndex;
   }

   public int getNewValue() {
      return newValue;
   }
}
