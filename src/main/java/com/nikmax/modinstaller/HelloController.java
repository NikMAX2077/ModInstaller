package com.nikmax.modinstaller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloController {
    @FXML
    private Button choiceBtn;
    @FXML
    private TextField pathTfd;

    @FXML
    protected void onChoiceBtn_Click() throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(choiceBtn.getScene().getWindow());
        pathTfd.setText(directory.toString());
        //ModInstaller.Install("ArtiModsPack.zip", directory.toString());
    }

    @FXML
    protected void onNextBtn_Click() throws IOException {
        //передача пути и состояния чекбокса
        //ModlistController modlistController = new ModlistController(pathTfd.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("modlist-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ModlistController modlistController = fxmlLoader.getController();
        modlistController.SetData(pathTfd.getText());
        Stage stage = (Stage) choiceBtn.getScene().getWindow();
        stage.setScene(scene);
        scene.setCursor(new ImageCursor(new Image("cursor.png")));
        stage.show();

    }

    @FXML
    protected void onExitBtn_Click() {
        Platform.exit();
    }


}