package fr.jp.perso.sudokuresolver.utils;

import fr.jp.perso.sudokuresolver.bo.SubGrid;
import fr.jp.perso.sudokuresolver.bo.SubGridCalk;
import fr.jp.perso.sudokuresolver.bo.SudokuGrid;
import fr.jp.perso.sudokuresolver.bo.SudokuGridCalk;
import fr.jp.perso.sudokuresolver.supervisor.SudokuSupervisor;

import java.util.ArrayList;
import java.util.List;

public class SudokuGridFactory {

   public static SudokuGrid createEmptySudokuGrid() {
      return createNewSudoku(createEmptyGrid());
   }

   public static SudokuGridCalk createEmptySudokuGridCalk() {
      return createNewSudokuCalk(createEmptyGrid());
   }

   public static SudokuGrid createNewSudoku(int[][] subGridTab) {
      List<SubGrid> subGrids = new ArrayList<>(9);
      int index = 0;
      int counter = 0;
      int total = 0;

      int[][] lines = new int[9][];

      for (int lineIndex = 0; lineIndex <= 8; lineIndex++) {
         int[] line = subGridTab[lineIndex];
         for (int i = 0; i <= 2; i++) {
            if (index == 0) {
               lines[i + total] = new int[9];
            }
            for (int j = 0; j <= 2; j++) {
               lines[i + total][j + index] = line[j + counter];
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
         subGrids.add(new SubGrid(lineIndex, lines[lineIndex]));
      }

      SudokuGrid sudokuGrid = new SudokuGrid(subGrids);
      sudokuGrid.initStateListener(new SudokuSupervisor(sudokuGrid));
      return sudokuGrid;
   }

   public static SudokuGridCalk createNewSudokuCalk(int[][] subGridTab) {
      List<SubGridCalk> subGrids = new ArrayList<>(9);
      int index = 0;
      int counter = 0;
      int total = 0;

      int[][] lines = new int[9][];

      for (int lineIndex = 0; lineIndex <= 8; lineIndex++) {
         int[] line = subGridTab[lineIndex];
         for (int i = 0; i <= 2; i++) {
            if (index == 0) {
               lines[i + total] = new int[9];
            }
            for (int j = 0; j <= 2; j++) {
               lines[i + total][j + index] = line[j + counter];
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
         subGrids.add(new SubGridCalk(lineIndex, lines[lineIndex]));
      }

      return new SudokuGridCalk(subGrids);
   }

   private static int[][] createEmptyGrid() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      subGrids[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

      return subGrids;
   }

   public static SudokuGrid createEasySudokuGrid() {
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

   public static SudokuGrid createHardSudokuGrid() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 5, 0, 0, 0, 9, 0, 0, 8};
      subGrids[1] = new int[]{0, 0, 0, 0, 6, 0, 5, 9, 0};
      subGrids[2] = new int[]{1, 0, 4, 0, 0, 0, 2, 0, 0};

      subGrids[3] = new int[]{0, 7, 2, 4, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{0, 0, 0, 6, 2, 0, 0, 8, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 0, 3, 0, 0, 7};

      subGrids[6] = new int[]{0, 8, 0, 0, 0, 0, 0, 4, 0};
      subGrids[7] = new int[]{4, 0, 0, 0, 9, 0, 0, 0, 0};
      subGrids[8] = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 6};

      return createNewSudoku(subGrids);
   }

   public static SudokuGrid  createExpertSudokuGrid() {
      int[][] subGrids = new int[9][];

      subGrids[0] = new int[]{0, 0, 1, 9, 8, 0, 0, 0, 0};
      subGrids[1] = new int[]{0, 0, 7, 0, 0, 0, 2, 3, 1};
      subGrids[2] = new int[]{0, 0, 0, 7, 0, 0, 0, 0, 0};

      subGrids[3] = new int[]{7, 0, 0, 0, 0, 0, 0, 0, 0};
      subGrids[4] = new int[]{4, 0, 8, 0, 2, 0, 0, 0, 0};
      subGrids[5] = new int[]{0, 0, 0, 0, 7, 0, 1, 4, 3};

      subGrids[6] = new int[]{0, 3, 0, 4, 0, 0, 0, 2, 0};
      subGrids[7] = new int[]{5, 0, 0, 0, 0, 3, 9, 0, 0};
      subGrids[8] = new int[]{0, 4, 0, 0, 0, 5, 0, 0, 0};

      return createNewSudoku(subGrids);
   }
}
