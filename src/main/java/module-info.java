module com.example.sudoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.smartApps.sudoku to javafx.fxml;
    exports com.smartApps.sudoku;
}