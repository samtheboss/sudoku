package com.smartApps.sudoku.userinterface.logic;

import com.smartApps.sudoku.computationlogic.GameLogic;
import com.smartApps.sudoku.constants.GameState;
import com.smartApps.sudoku.constants.Messages;
import com.smartApps.sudoku.problemdomain.IStorage;
import com.smartApps.sudoku.problemdomain.SudokuGame;
import com.smartApps.sudoku.userinterface.IUUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUUserInterfaceContract.EventListener {
  private IStorage storage;
  private IUUserInterfaceContract.View view;

  public ControlLogic(IStorage storage, IUUserInterfaceContract.View view) {
    this.storage = storage;
    this.view = view;
  }

  @Override
  public void onSudokuInput(int x, int y, int input) {
    try {
      SudokuGame gameData = storage.getGameData();
      int[][] newGridState = gameData.getCopyOfGridState();
      newGridState[x][y] = input;
      gameData = new SudokuGame(GameLogic.checkForCompletion(newGridState), newGridState);
      storage.updateGameData(gameData);
      view.updateSquare(x, y, input);
      if (gameData.getGameState() == GameState.COMPLETE) {
        view.showDialog(Messages.GAME_COMPLETE);
      } else {

      }
    } catch (IOException e) {
      e.printStackTrace();
      view.showError(Messages.Error);
    }
  }

  @Override
  public void onDialogClick() {
    try {
      storage.updateGameData(GameLogic.getNewGame());
      view.updateBoard(storage.getGameData());
    } catch (IOException e) {
      view.showError(Messages.Error);
    }
  }
}
