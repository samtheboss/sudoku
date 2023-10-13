package com.smartApps.sudoku;

public class loops {
  public static void main(String[] args) {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println(i + " " + j);
      }
      System.out.println("outer loops");
    }
  }
}
