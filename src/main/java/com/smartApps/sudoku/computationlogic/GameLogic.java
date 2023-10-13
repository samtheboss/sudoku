package com.smartApps.sudoku.computationlogic;

import com.smartApps.sudoku.constants.GameState;
import com.smartApps.sudoku.constants.Rows;
import com.smartApps.sudoku.problemdomain.SudokuGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.smartApps.sudoku.problemdomain.SudokuGame.Grid_Boundary;

public class GameLogic {
  public static SudokuGame getNewGame() {

    return new SudokuGame(GameState.NEW,
            GameGenerator.getNewGameGrid());
  }

  public static GameState checkForCompletion(int[][] grid) {
    if (sudokuIsInvalid(grid)) return GameState.ACTIVE;
    if (tilesAreNotFilled(grid)) return GameState.ACTIVE;
     return GameState.COMPLETE;
  }

  public static boolean sudokuIsInvalid(int[][] grid) {
    if (rowsAreValid(grid)) return true;
    if (columnsAreValid(grid)) return true;
    if (squaresAreValid(grid)) return true;
    else return false;
  }

  private static boolean rowsAreValid(int[][] grid) {
    for (int yIndex = 0; yIndex < Grid_Boundary; yIndex++) {
      List<Integer> row = new ArrayList<>();
      for (int xIndex = 0; xIndex < Grid_Boundary; xIndex++) {
        row.add(grid[xIndex][yIndex]);
      }
      if (collectionHasRepeats(row)) return true;
    }
    return false;
  }

  public static boolean columnsAreValid(int[][] grid) {
    for (int xIndex = 0; xIndex < Grid_Boundary; xIndex++) {
      List<Integer> row = new ArrayList<>();
      for (int yIndex = 0; yIndex < Grid_Boundary; yIndex++) {
        row.add(grid[xIndex][yIndex]);
      }
      if (collectionHasRepeats(row)) return true;
    }
    return false;
  }

  public static boolean squaresAreValid(int[][] grid) {
    if (rowOfSquareIsInvalid(Rows.TOP, grid)) return true;
    if (rowOfSquareIsInvalid(Rows.MIDDLE, grid)) return true;
    if (rowOfSquareIsInvalid(Rows.BOTTOM, grid)) return true;
    else return false;
  }

  public static boolean rowOfSquareIsInvalid(Rows value, int[][] grid) {
    switch (value) {
      case TOP:
        if (squareIsInvalid(0, 0, grid)) return true;
        if (squareIsInvalid(0, 3, grid)) return true;
        if (squareIsInvalid(0, 6, grid)) return true;
        return false;
      case MIDDLE:
        if (squareIsInvalid(3, 0, grid)) return true;
        if (squareIsInvalid(3, 3, grid)) return true;
        if (squareIsInvalid(3, 6, grid)) return true;
        return false;
      case BOTTOM:
        if (squareIsInvalid(6, 0, grid)) return true;
        if (squareIsInvalid(6, 3, grid)) return true;
        if (squareIsInvalid(6, 6, grid)) return true;
        return false;
      default:
        return false;
    }
  }

  public static boolean squareIsInvalid(int xIndex, int yIndex, int[][] grid) {
    int yIndexEnd = yIndex + 3;
    int xIndexEnd = xIndex + 3;
    List<Integer> square = new ArrayList<>();
    while (yIndex < yIndexEnd) {
      while (xIndex < xIndexEnd) {
        square.add(grid[xIndex][yIndex]);
        xIndex++;
      }
      xIndex -= 3;
      yIndex++;
    }
    if (collectionHasRepeats(square)) return true;
    return false;
  }

  public static boolean collectionHasRepeats(List<Integer> collection) {
    for (int index = 1; index <= Grid_Boundary; index++) {
      if (Collections.frequency(collection, index) > 1) return true;
    }
    return false;
  }

  public static boolean tilesAreNotFilled(int[][] grid) {
    for (int xIndex = 0; xIndex < Grid_Boundary; xIndex++) {
      for (int yIndex = 0; yIndex < Grid_Boundary; yIndex++) {
        if (grid[xIndex][yIndex] == 0) return true;
      }
    }
    return false;
  }
}
