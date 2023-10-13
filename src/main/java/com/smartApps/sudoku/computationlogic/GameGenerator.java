package com.smartApps.sudoku.computationlogic;

import com.smartApps.sudoku.problemdomain.Coordinates;
import com.smartApps.sudoku.problemdomain.SudokuGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.smartApps.sudoku.problemdomain.SudokuGame.Grid_Boundary;

public class GameGenerator {
  public static int[][] getNewGameGrid() {
    return unsolvedGame(getSolvedGame());
  }

    private static int[][] unsolvedGame(int[][] solvedGame) {
      Random random =new Random(System.currentTimeMillis());
      boolean solvable =false;
      int [][] solvableArray =new int[Grid_Boundary][Grid_Boundary];

      while (solvable ==false){
          SudokuUtilities.copySudokuArrayValues(solvedGame,solvableArray);
          int index =0;
          while (index<40){
              int xCoordinate =random.nextInt(Grid_Boundary);
              int yCoordinate =random.nextInt(Grid_Boundary);
              if (solvableArray[xCoordinate][yCoordinate]!=0){
                  solvableArray[xCoordinate][yCoordinate]=0;
                  index++;
              }
          }
          int[][] toBeSolved = new int[Grid_Boundary][Grid_Boundary];
          SudokuUtilities.copySudokuArrayValues(solvableArray,toBeSolved);
          solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);
      }
        return solvableArray;
    }

    private static int[][] getSolvedGame() {
    Random random = new Random(System.currentTimeMillis());
    int[][] newGrid = new int[Grid_Boundary][Grid_Boundary];

    for (int value = 1; value < Grid_Boundary; value++) {
      int allocation = 0;
      int interrupt = 0;
      List<Coordinates> allocTracker = new ArrayList<>();
      int attempts = 0;
      while (allocation < Grid_Boundary) {
        if (interrupt > 200) {
          allocTracker.forEach(
              c -> {
                newGrid[c.getX()][c.getY()] = 0;
              });
          interrupt = 0;
          allocation = 0;
          allocTracker.clear();
          attempts++;
          if (attempts > 500) {
            clearArray(newGrid);
            attempts = 0;
            value = 1;
          }
        }
        int xCoordinate =random.nextInt(Grid_Boundary);
        int yCoordinate =random.nextInt(Grid_Boundary);
        if (newGrid[xCoordinate][yCoordinate]==0){
            newGrid[xCoordinate][yCoordinate]=value;
            if (GameLogic.sudokuIsInvalid(newGrid)){
                newGrid[xCoordinate][yCoordinate]=0;
                interrupt++;
            }else {
                allocTracker.add(new Coordinates(xCoordinate,yCoordinate));
                allocation++;
            }
        }
      }

    }
        return newGrid;
  }

  private static void clearArray(int[][] newGrid) {
    for (int xIndex = 0; xIndex < Grid_Boundary; xIndex++) {
      for (int yIndex = 0; yIndex < Grid_Boundary; yIndex++) {
        newGrid[xIndex][yIndex] = 0;
      }
    }
  }
}
