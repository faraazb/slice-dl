package ui.mainwindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowTitleController {

    @FXML
    private Button closeButton;

    @FXML
    private void close() {
        Stage main_window = (Stage) closeButton.getScene().getWindow();
        main_window.close();
    }
}
