package fr.jp.perso.sudokuresolver.utils;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.supervisor.SudokuSupervisor;

import java.util.ArrayList;
import java.util.List;

public class SudokuGridFactory {

   public static SudokuGridCalk createEmptySudokuGridCalk() {
      List<SubGridCalk> subGrids = new ArrayList<>(9);
      int index = 0;

      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));

      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));

      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(index++, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGridCalk(index, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));

      return new SudokuGridCalk(subGrids);
   }

   private static SudokuGrid createNewSudoku2(List<SubGrid> subGrids) {
      SudokuGrid sudokuGrid = new SudokuGrid(subGrids);
      sudokuGrid.initStateListener(new SudokuSupervisor(sudokuGrid));
      return sudokuGrid;
   }

   public static SudokuGrid createNewSudoku(int[][] lines) {
      List<SubGrid> subGrids = new ArrayList<>(9);
      int index = 0;
      int counter = 0;
      int total = 0;

      int[][] subGrigs = new int[9][];

      for (int lineIndex = 0; lineIndex <= 8; lineIndex++) {
         int[] line = lines[lineIndex];
         for (int i = 0; i <= 2; i++) {
            if (index == 0) {
               subGrigs[i + total] = new int[9];
            }
            for (int j = 0; j <= 2; j++) {
               subGrigs[i + total][j + index] = line[j + counter];
            }
            counter += 3;
         }
         index += 3;
         if (index == 9) {
            total += 3;
            index = 0;
         }
         counter = 0;
      }

      for (int lineIndex = 0; lineIndex <= 8; lineIndex++) {
         subGrids.add(new SubGrid(lineIndex, subGrigs[lineIndex]));
      }

      SudokuGrid sudokuGrid = new SudokuGrid(subGrids);
      sudokuGrid.initStateListener(new SudokuSupervisor(sudokuGrid));
      return sudokuGrid;
   }

   public static SudokuGridCalk createNewSudokuCalk(int[][] lines) {
      List<SubGridCalk> subGrids = new ArrayList<>(9);
      int index = 0;
      int counter = 0;
      int total = 0;

      int[][] subGrigs = new int[9][];

      for (int lineIndex = 0; lineIndex <= 8; lineIndex++) {
         int[] line = lines[lineIndex];
         for (int i = 0; i <= 2; i++) {
            if (index == 0) {
               subGrigs[i + total] = new int[9];
            }
            for (int j = 0; j <= 2; j++) {
               subGrigs[i + total][j + index] = line[j + counter];
            }
            counter += 3;
         }
         index += 3;
         if (index == 9) {
            total += 3;
            index = 0;
         }
         counter = 0;
      }

      for (int lineIndex = 0; lineIndex <= 8; lineIndex++) {
         subGrids.add(new SubGridCalk(lineIndex, subGrigs[lineIndex]));
      }

      return new SudokuGridCalk(subGrids);
   }

   public static SudokuGrid createEasySudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<>(9);
      int index = 0;

      subGrids.add(new SubGrid(index++, new int[]{2, 0, 0, 0, 0, 6, 0, 7, 4}));
      subGrids.add(new SubGrid(index++, new int[]{8, 0, 4, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 6, 5, 0, 0, 9, 2, 0}));

      subGrids.add(new SubGrid(index++, new int[]{3, 0, 0, 0, 0, 0, 4, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 4, 0, 3, 0, 5, 0, 6, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 7, 0, 0, 0, 0, 0, 9}));

      subGrids.add(new SubGrid(index++, new int[]{0, 1, 9, 0, 0, 8, 5, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 0, 0, 6, 0, 8}));
      subGrids.add(new SubGrid(index,   new int[]{7, 4, 0, 2, 0, 0, 0, 0, 1}));

      return createNewSudoku2(subGrids);
   }

   public static SudokuGrid createEasySudoku2Grid() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{2, 0, 0, 8, 0, 4, 0, 0, 6};
      subGrids[1] = new int[]{0, 0, 6, 0, 0, 0, 5, 0, 0};
      subGrids[2] = new int[]{0, 7, 4, 0, 0, 0, 9, 2, 0};

      subGrids[3] = new int[]{3, 0, 0, 0, 4, 0, 0, 0, 7};
      subGrids[4] = new int[]{0, 0, 0, 3, 0, 5, 0, 0, 0};
      subGrids[5] = new int[]{4, 0, 0, 0, 6, 0, 0, 0, 9};

      subGrids[6] = new int[]{0, 1, 9, 0, 0, 0, 7, 4, 0};
      subGrids[7] = new int[]{0, 0, 8, 0, 0, 0, 2, 0, 0};
      subGrids[8] = new int[]{5, 0, 0, 6, 0, 8, 0, 0, 1};

      return createNewSudoku(subGrids);
   }

   public static SudokuGrid createMediumSudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<>(9);
      int index = 0;

      subGrids.add(new SubGrid(index++, new int[]{0, 6, 0, 0, 0, 0, 0, 2, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 1, 0, 8, 0, 4}));
      subGrids.add(new SubGrid(index++, new int[]{7, 0, 8, 0, 0, 0, 3, 0, 0}));

      subGrids.add(new SubGrid(index++, new int[]{6, 5, 0, 0, 0, 0, 0, 0, 3}));
      subGrids.add(new SubGrid(index++, new int[]{1, 0, 2, 0, 0, 0, 7, 0, 9}));
      subGrids.add(new SubGrid(index++, new int[]{9, 0, 0, 0, 0, 0, 0, 4, 5}));

      subGrids.add(new SubGrid(index++, new int[]{0, 0, 6, 0, 0, 0, 7, 0, 2}));
      subGrids.add(new SubGrid(index++, new int[]{4, 0, 5, 0, 7, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index,   new int[]{0, 8, 0, 0, 0, 0, 0, 1, 0}));

      return createNewSudoku2(subGrids);
   }

   public static SudokuGrid createMediumSudoku2Grid() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 6, 0, 0, 0, 0, 7, 0, 8};
      subGrids[1] = new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0};
      subGrids[2] = new int[]{0, 2, 0, 8, 0, 4, 3, 0, 0};

      subGrids[3] = new int[]{6, 5, 0, 1, 0, 2, 9, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 3, 7, 0, 9, 0, 4, 5};

      subGrids[6] = new int[]{0, 0, 6, 4, 0, 5, 0, 8, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 7, 0, 0, 0, 0};
      subGrids[8] = new int[]{7, 0, 2, 0, 0, 0, 0, 1, 0};

      return createNewSudoku(subGrids);
   }

   public static SudokuGrid  createHardSudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<>(9);
      int index = 0;

      subGrids.add(new SubGrid(index++, new int[]{0, 5, 0, 0, 0, 0, 1, 0, 4}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 9, 0, 6, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 8, 5, 9, 0, 2, 0, 0}));

      subGrids.add(new SubGrid(index++, new int[]{0, 7, 2, 0, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{4, 0, 0, 6, 2, 0, 0, 0, 3}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 8, 0, 0, 0, 7}));

      subGrids.add(new SubGrid(index++, new int[]{0, 8, 0, 4, 0, 0, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 9, 0, 0, 0, 1}));
      subGrids.add(new SubGrid(index, new int[]{0, 4, 0, 0, 0, 0, 0, 0, 6}));

      return createNewSudoku2(subGrids);
   }

   public static SudokuGrid  createExpertSudokuGrid() {
      List<SubGrid> subGrids = new ArrayList<>(9);
      int index = 0;

      subGrids.add(new SubGrid(index++, new int[]{0, 0, 1, 0, 0, 7, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{9, 8, 0, 0, 0, 0, 7, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 2, 3, 1, 0, 0, 0}));

      subGrids.add(new SubGrid(index++, new int[]{7, 0, 0, 4, 0, 8, 0, 0, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 2, 0, 0, 7, 0}));
      subGrids.add(new SubGrid(index++, new int[]{0, 0, 0, 0, 0, 0, 1, 4, 3}));

      subGrids.add(new SubGrid(index++, new int[]{0, 3, 0, 5, 0, 0, 0, 4, 0}));
      subGrids.add(new SubGrid(index++, new int[]{4, 0, 0, 0, 0, 3, 0, 0, 5}));
      subGrids.add(new SubGrid(index, new int[]{0, 2, 0, 9, 0, 0, 0, 0, 0}));

      return createNewSudoku2(subGrids);
   }
}
