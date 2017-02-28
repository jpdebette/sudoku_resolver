package fr.jp.perso.sudokuresolver.bo.calkrules;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.utils.SudokuIndexResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberMaybePresentRule extends CalkRule {

   public NumberMaybePresentRule(CalkRule nextRule) {
      super(nextRule);
   }

   @Override
   public void applyRule(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int number) {
      for (int subGridIndex = 0; subGridIndex <= 8; subGridIndex++) {
         applyRulePerSubGrid(sudokuGridCalk, sudokuGrid.getSubGrid(subGridIndex), subGridIndex, number);
      }

      if (nextRule != null) {
         nextRule.applyRule(sudokuGrid, sudokuGridCalk, number);
      }
   }

   private void applyRulePerSubGrid(SudokuGridCalk sudokuGridCalk, SubGrid subGrid, int subGridIndex, int number) {
      List<Integer> squareIndexWithThisPossibleNumber = findPossiblePositionForNumber(subGrid, number);
      if (squareIndexWithThisPossibleNumber.size() == 2) {
         int index1 = squareIndexWithThisPossibleNumber.get(0);
         int index2 = squareIndexWithThisPossibleNumber.get(1);
         if (areOneTheSameLine(index1, index2)) {
            sudokuGridCalk.setLineUnavailableForOtherSubGrid(subGridIndex, index1);
         } else if (areOneTheSameColumn(index1, index2)) {
            sudokuGridCalk.setColumnUnavailableForOtherSubGrid(subGridIndex, index1);
         }
      }
   }

   private List<Integer> findPossiblePositionForNumber(SubGrid subGrid, int number) {
      List<Integer> squareIndexWithThisPossibleNumber = new ArrayList<>();
      for (int squareIndex : subGrid.getAvailablePositions()) {
         if (subGrid.getSquare(squareIndex).isPossibleValue(number)) {
            squareIndexWithThisPossibleNumber.add(squareIndex);
         }
      }
      return squareIndexWithThisPossibleNumber;
   }

   private boolean areOneTheSameLine(int index1, int index2) {
      int[] squareLine1 = SudokuIndexResolver.getSquareLineIndexPerIndex(index1);
      int[] squareLine2 = SudokuIndexResolver.getSquareLineIndexPerIndex(index2);
      return Arrays.equals(squareLine1, squareLine2);
   }

   private boolean areOneTheSameColumn(int index1, int index2) {
      int[] squareColumn1 = SudokuIndexResolver.getSquareColumnIndexPerIndex(index1);
      int[] squareColumn2 = SudokuIndexResolver.getSquareColumnIndexPerIndex(index2);
      return Arrays.equals(squareColumn1, squareColumn2);
   }
}
