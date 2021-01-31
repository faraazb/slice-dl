package ui.download;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import ui.common.TimeSpinner;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DownloadController {
//    @FXML
//    private Spinner<LocalTime> startTime;
    private final BooleanProperty downloadButtonDisabled = new SimpleBooleanProperty();
    private final BooleanProperty startEndInvalid = new SimpleBooleanProperty();
//
//    private final BooleanBinding disabler;
    @FXML
    private TextField url;

    @FXML
    private TextField filename;

    @FXML
    private Text directory;
    private String defaultSaveDirectory;

    @FXML
    private TimeSpinner start;

    @FXML
    private TimeSpinner end;

    @FXML
    public void initialize() {
        downloadButtonDisabled.bind(url.textProperty().isEmpty().or(startEndInvalid));

        directory.getStyleClass().clear();
        defaultSaveDirectory = System.getProperty("user.home")+"\\Downloads";
        directory.textProperty().setValue(defaultSaveDirectory);

        DateTimeFormatter filedate = DateTimeFormatter.ofPattern("yyyyMMdd_HH-mm-ss");
        filename.textProperty().setValue("Video_"+ LocalDateTime.now().format(filedate));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        start.setMode(TimeSpinner.Mode.MINUTES);
        start.valueProperty().addListener((observableValue, localTime, t1) -> isStartEndInvalid());

        end.setMode(TimeSpinner.Mode.MINUTES);
        end.valueProperty().addListener((obs, oldTime, newTime) -> isStartEndInvalid());

        start.setTime("00:00:00");
        end.setTime("00:00:00");
        isStartEndInvalid();
    }

    public void isStartEndInvalid() {
        int totalStartSeconds = (start.valueProperty().getValue().getHour() * 60 +
                start.valueProperty().getValue().getMinute()) * 60 + start.valueProperty().getValue().getSecond();
        int totalEndSeconds = (end.valueProperty().getValue().getHour() * 60 +
                end.valueProperty().getValue().getMinute()) * 60 + end.valueProperty().getValue().getSecond();
        startEndInvalid.set(totalStartSeconds >= totalEndSeconds);
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

    public void chooseDirectory() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Where to save?");
        chooser.setInitialDirectory(new File(defaultSaveDirectory));
        Stage download = (Stage) directory.getScene().getWindow();
        File folder = chooser.showDialog(download);
        directory.textProperty().setValue(folder.getAbsolutePath());
    }
}
