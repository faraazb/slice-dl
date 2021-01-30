package ui.mainwindow;


import javafx.css.Style;
import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.StageStyle;
//import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
//        scene = new Scene(loadFXML("/fxml/main_window.fxml"), 640, 480);
        scene = new Scene(loadFXML("/fxml/main_window.fxml"), 650, 440);
//        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
//        StyleManager.getInstance().addUserAgentStylesheet(getClass().getResource("/light_theme.css").toString());
//        Application.setUserAgentStylesheet(getClass().getResource("/css/light_theme.css").toExternalForm());
        stage.setMinWidth(650);
        stage.setMinHeight(440);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(700);
        stage.setTitle("Slice-dl");
        scene.getStylesheets().add(App.class.getResource("/css/light_theme.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.strings");
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml), bundle);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Application.launch();
    }


}