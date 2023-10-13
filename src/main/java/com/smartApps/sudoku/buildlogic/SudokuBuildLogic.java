package com.smartApps.sudoku.buildlogic;

import com.smartApps.sudoku.computationlogic.GameLogic;
import com.smartApps.sudoku.persitence.LocalStorage;
import com.smartApps.sudoku.problemdomain.IStorage;
import com.smartApps.sudoku.problemdomain.SudokuGame;
import com.smartApps.sudoku.userinterface.IUUserInterfaceContract;
import com.smartApps.sudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
  public static void build(IUUserInterfaceContract.View userInterface) throws IOException {
    SudokuGame initialState;
    IStorage storage = new LocalStorage();
    try {
      initialState = storage.getGameData();
    } catch (IOException e) {
      initialState = GameLogic.getNewGame();
      storage.updateGameData(initialState);
    }
    IUUserInterfaceContract.EventListener uiLogic =
            new ControlLogic(storage,userInterface);
    userInterface.setListener(uiLogic);
    userInterface.updateBoard(initialState);
  }
}
