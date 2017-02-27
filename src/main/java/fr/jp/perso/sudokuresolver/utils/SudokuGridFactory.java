package fr.jp.perso.sudokuresolver.utils;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;

import java.util.ArrayList;
import java.util.List;

public class SudokuGridFactory {

   public static SudokuGrid createSudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<SubGrid>(9);

      subGrids.add(new SubGrid(new Integer[]{0, 6, 0, 0, 0, 0, 0, 2, 0}));
      subGrids.add(new SubGrid(new Integer[]{0, 0, 0, 0, 1, 0, 8, 0, 4}));
      subGrids.add(new SubGrid(new Integer[]{7, 0, 8, 0, 0, 0, 3, 0, 0}));

      subGrids.add(new SubGrid(new Integer[]{6, 5, 0, 0, 0, 0, 0, 0, 3}));
      subGrids.add(new SubGrid(new Integer[]{1, 0, 2, 0, 0, 0, 7, 0, 9}));
      subGrids.add(new SubGrid(new Integer[]{9, 0, 0, 0, 0, 0, 0, 4, 5}));

      subGrids.add(new SubGrid(new Integer[]{0, 0, 6, 0, 0, 0, 7, 0, 2}));
      subGrids.add(new SubGrid(new Integer[]{4, 0, 5, 0, 7, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(new Integer[]{0, 8, 0, 0, 0, 0, 0, 1, 0}));

      return new SudokuGrid(subGrids);
   }
}
