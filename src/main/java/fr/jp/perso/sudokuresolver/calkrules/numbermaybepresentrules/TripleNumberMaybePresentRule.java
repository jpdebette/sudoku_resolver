package fr.jp.perso.sudokuresolver.calkrules.numbermaybepresentrules;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.calkrules.CalkRule;
import fr.jp.perso.sudokuresolver.utils.SudokuIndexResolver;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripleNumberMaybePresentRule extends CalkRule {

   public TripleNumberMaybePresentRule(CalkRule nextRule) {
      super(nextRule);
   }

   @Override
   protected void apply(SudokuGrid sudokuGrid, SudokuGridCalk sudokuGridCalk, int number) {
      for (int subGridIndex = 0; subGridIndex <= 8; subGridIndex++) {
         applyRulePerSubGrid(sudokuGridCalk, sudokuGrid.getSubGrid(subGridIndex), subGridIndex, number);
      }
   }

   private void applyRulePerSubGrid(SudokuGridCalk sudokuGridCalk, SubGrid subGrid, int subGridIndex, int number) {
      List<Integer> squareIndexWithThisPossibleNumber = findPossiblePositionForNumber(subGrid, number);
      cleanLinkedSquare(subGrid, squareIndexWithThisPossibleNumber, number);
      if (squareIndexWithThisPossibleNumber.size() == 3) {
         int index1 = squareIndexWithThisPossibleNumber.get(0);
         int index2 = squareIndexWithThisPossibleNumber.get(1);
         int index3 = squareIndexWithThisPossibleNumber.get(2);
         if (areOneTheSameLine(index1, index2) && areOneTheSameLine(index2, index3)) {
            sudokuGridCalk.setLineUnavailableForOtherSubGrid(subGridIndex, index1);
         } else if (areOneTheSameColumn(index1, index2) && areOneTheSameColumn(index2, index3)) {
            sudokuGridCalk.setColumnUnavailableForOtherSubGrid(subGridIndex, index1);
         }
      }
   }

   private void cleanLinkedSquare(SubGrid subGrid, List<Integer> squareIndexWithThisPossibleNumber, int currentNumber) {
      Map<Pair<Integer, Integer>, Integer> possibleDoubles = new HashMap<>();

      for (int number = 1; number <= 9; number++) {
         if (number == currentNumber) {
            continue;
         }
         List<Integer> possiblePositions = subGrid.getPossiblePositions(number);
         if (possiblePositions.size() == 2) {
            Pair<Integer, Integer> pair = new Pair<>(possiblePositions.get(0), possiblePositions.get(1));
            if (possibleDoubles.containsKey(pair)) {
               squareIndexWithThisPossibleNumber.remove(possiblePositions.get(0));
               squareIndexWithThisPossibleNumber.remove(possiblePositions.get(1));
               possibleDoubles.remove(pair);
            } else {
               possibleDoubles.put(pair, number);
            }
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
      int[] squareLine1 = SudokuIndexResolver.getSquareLineIndexesPerIndex(index1);
      int[] squareLine2 = SudokuIndexResolver.getSquareLineIndexesPerIndex(index2);
      return Arrays.equals(squareLine1, squareLine2);
   }

   private boolean areOneTheSameColumn(int index1, int index2) {
      int[] squareColumn1 = SudokuIndexResolver.getSquareColumnIndexesPerIndex(index1);
      int[] squareColumn2 = SudokuIndexResolver.getSquareColumnIndexesPerIndex(index2);
      return Arrays.equals(squareColumn1, squareColumn2);
   }
}
