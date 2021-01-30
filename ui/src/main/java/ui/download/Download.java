package ui.download;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class Download {
    private static Scene scene;

    public void show() throws IOException {
        scene = new Scene(loadFXML("/fxml/download.fxml"));
        Stage downloadStage = new Stage();
        downloadStage.setScene(scene);
        downloadStage.setResizable(false);
        downloadStage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.strings");
        FXMLLoader fxmlLoader = new FXMLLoader(Download.class.getResource(fxml), bundle);
        return fxmlLoader.load();
    }

}
