package com.smartApps.sudoku.persitence;

import com.smartApps.sudoku.problemdomain.IStorage;
import com.smartApps.sudoku.problemdomain.SudokuGame;

import java.io.*;

public class LocalStorage implements IStorage {
  private static final File GAME_DATA = new File(System.getProperty("user.home"), "game-data.txt");

  @Override
  public void updateGameData(SudokuGame game) throws IOException {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(game);
      objectOutputStream.close();
    } catch (IOException e) {
      throw new IOException("unable to access game data");
    }
  }

  @Override
  public SudokuGame getGameData() throws IOException {
    FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    try{
      SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
      objectInputStream.close();
      return gameState;
    }catch (IOException e){} catch (ClassNotFoundException e) {

      e.printStackTrace();
      throw new IOException("file not found");
    }

    return null;
  }
}
