package com.smartApps.sudoku.problemdomain;

import com.smartApps.sudoku.computationlogic.SudokuUtilities;
import com.smartApps.sudoku.constants.GameState;

public class SudokuGame {
    private final GameState gameState;
    private final  int[][] gridState;
    public static final int Grid_Boundary =9;

    public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }
}
