package com.musictracker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.musictracker.model.CD;
import com.musictracker.model.Database;
public class CreateCDController {
    @FXML private TextField titleField;
    @FXML private TextField artistField;
    @FXML private CheckBox ownCheckBox;
    @FXML private Label playingTimeLabel;
    @FXML private Slider playingTimeSlider;
    @FXML private Label numTracksLabel;
    @FXML private Slider numTracksSlider;
    @FXML private Button cancelButton;
    private Database model;
    public void setModel(Database model) {
        this.model = model;
    }
    @FXML
    private void initialize() { 
        playingTimeSlider.valueProperty().addListener((obs, oldVal, newVal) ->
            playingTimeLabel.setText("Playing time: " + newVal.intValue()));
        numTracksSlider.valueProperty().addListener((obs, oldVal, newVal) ->
            numTracksLabel.setText("Number of tracks: " + newVal.intValue()));
    }
    @FXML
    private void handleCreateButton() {
        String title = titleField.getText();
        String artist = artistField.getText();
        int playingTime = (int) playingTimeSlider.getValue();
        int numTracks = (int) numTracksSlider.getValue();
        boolean own = ownCheckBox.isSelected();
        CD newCD = new CD(title, artist, numTracks, playingTime);
        newCD.setOwn(own);
        model.addItem(newCD);
        Stage stage = (Stage) titleField.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void handleCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}

