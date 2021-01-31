package ui.download;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalTimeStringConverter;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

public class Download {
    private static Scene scene;

    public void show() throws IOException {
        scene = new Scene(loadFXML("/fxml/download.fxml"));
        Stage downloadStage = new Stage();
        downloadStage.setScene(scene);
        downloadStage.setResizable(false);
        downloadStage.setTitle("Download Options");
        downloadStage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.strings");
        FXMLLoader fxmlLoader = new FXMLLoader(Download.class.getResource(fxml), bundle);
        return fxmlLoader.load();
    }

}
