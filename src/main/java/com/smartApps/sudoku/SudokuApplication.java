package com.smartApps.sudoku;

import com.smartApps.sudoku.buildlogic.SudokuBuildLogic;
import com.smartApps.sudoku.userinterface.IUUserInterfaceContract;
import com.smartApps.sudoku.userinterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUUserInterfaceContract.View uiImp;
    @Override
    public void start(Stage stage) throws IOException {
        uiImp = new UserInterfaceImpl(stage);
      SudokuBuildLogic.build(uiImp);


//        FXMLLoader fxmlLoader = new FXMLLoader(SudokuApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}