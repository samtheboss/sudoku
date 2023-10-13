package com.smartApps.sudoku.computationlogic;

import com.smartApps.sudoku.problemdomain.SudokuGame;

public class SudokuUtilities {
  public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray) {
    for (int xindex = 0; xindex < SudokuGame.Grid_Boundary; xindex++) {
      for (int yIndex = 0; yIndex < SudokuGame.Grid_Boundary; yIndex++) {
        newArray[xindex][yIndex] = oldArray[xindex][yIndex];
      }
    }
  }

  public static int[][] copyToNewArray(int[][] oldArray) {
    int[][] newArray = new int[SudokuGame.Grid_Boundary][SudokuGame.Grid_Boundary];
    for (int xindex = 0; xindex < SudokuGame.Grid_Boundary; xindex++) {
      for (int yIndex = 0; yIndex < SudokuGame.Grid_Boundary; yIndex++) {
        newArray[xindex][yIndex] = oldArray[xindex][yIndex];
      }
    }
    return newArray;
  }
}
