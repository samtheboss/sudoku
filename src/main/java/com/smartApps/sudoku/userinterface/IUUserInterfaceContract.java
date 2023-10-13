package com.smartApps.sudoku.userinterface;

import com.smartApps.sudoku.problemdomain.SudokuGame;

public interface IUUserInterfaceContract {
    interface  EventListener{
        void onSudokuInput(int x,int y, int input);
        void onDialogClick();
    }
    interface View{
        void setListener(IUUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String msg);
        void showError(String msg);

    }
}
