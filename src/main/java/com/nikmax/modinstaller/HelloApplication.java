package com.nikmax.modinstaller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("quest.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("ModInstaller by NikMAX");
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
//        Image image = new Image("file:rangers/cursor.png");
//        scene.setCursor(new ImageCursor(image));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}