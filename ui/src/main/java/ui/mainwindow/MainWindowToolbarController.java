package ui.mainwindow;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.common.FontLoader;
import ui.download.Download;

public class MainWindowToolbarController {

    private static final Logger LOG = LoggerFactory.getLogger(FontLoader.class);

    @FXML
    private TextField urlField;

    private final BooleanProperty downloadButtonDisabled = new SimpleBooleanProperty(false);

    @FXML
    public void initialize() {
        downloadButtonDisabled.bind(urlField.textProperty().isEmpty());
    }

    public void download() {
        try {
            Download downloadWindow = new Download();
            downloadWindow.show();
        } catch (Exception e) {
            LOG.debug("Download Options had a problem!");
        }
    }


//    Getter-Setter for downloadButtonDisabled
    public boolean isDownloadButtonDisabled() {
        return downloadButtonDisabled.get();
    }

    public BooleanProperty downloadButtonDisabledProperty() {
        return downloadButtonDisabled;
    }

    public void setDownloadButtonDisabled(boolean downloadButtonDisabled) {
        this.downloadButtonDisabled.set(downloadButtonDisabled);
    }


}
