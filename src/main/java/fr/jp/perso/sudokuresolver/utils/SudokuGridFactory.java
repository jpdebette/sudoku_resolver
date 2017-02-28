package fr.jp.perso.sudokuresolver.utils;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;

import java.util.ArrayList;
import java.util.List;

public class SudokuGridFactory {

   public static SudokuGridCalk createSudokuGridCalk() {
      List<SubGridCalk> subGrids = new ArrayList<>(9);

      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));

      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));

      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));

      return new SudokuGridCalk(subGrids);
   }

   public static SudokuGrid createEasySudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<>(9);

      subGrids.add(new SubGrid(new int[]{2, 0, 0, 0, 0, 6, 0, 7, 4}));
      subGrids.add(new SubGrid(new int[]{8, 0, 4, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(new int[]{0, 0, 6, 5, 0, 0, 9, 2, 0}));

      subGrids.add(new SubGrid(new int[]{3, 0, 0, 0, 0, 0, 4, 0, 0}));
      subGrids.add(new SubGrid(new int[]{0, 4, 0, 3, 0, 5, 0, 6, 0}));
      subGrids.add(new SubGrid(new int[]{0, 0, 7, 0, 0, 0, 0, 0, 9}));

      subGrids.add(new SubGrid(new int[]{0, 1, 9, 0, 0, 8, 5, 0, 0}));
      subGrids.add(new SubGrid(new int[]{0, 0, 0, 0, 0, 0, 6, 0, 8}));
      subGrids.add(new SubGrid(new int[]{7, 4, 0, 2, 0, 0, 0, 0, 1}));

      return new SudokuGrid(subGrids);
   }

   public static SudokuGrid createMediumSudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<>(9);

      subGrids.add(new SubGrid(new int[]{0, 6, 0, 0, 0, 0, 0, 2, 0}));
      subGrids.add(new SubGrid(new int[]{0, 0, 0, 0, 1, 0, 8, 0, 4}));
      subGrids.add(new SubGrid(new int[]{7, 0, 8, 0, 0, 0, 3, 0, 0}));

      subGrids.add(new SubGrid(new int[]{6, 5, 0, 0, 0, 0, 0, 0, 3}));
      subGrids.add(new SubGrid(new int[]{1, 0, 2, 0, 0, 0, 7, 0, 9}));
      subGrids.add(new SubGrid(new int[]{9, 0, 0, 0, 0, 0, 0, 4, 5}));

      subGrids.add(new SubGrid(new int[]{0, 0, 6, 0, 0, 0, 7, 0, 2}));
      subGrids.add(new SubGrid(new int[]{4, 0, 5, 0, 7, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(new int[]{0, 8, 0, 0, 0, 0, 0, 1, 0}));

      return new SudokuGrid(subGrids);
   }
}
