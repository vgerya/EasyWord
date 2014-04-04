package com.mype.easyword.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class EasyWordApp extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.messages", Locale.getDefault()));
        Parent root = fxmlLoader.load(getClass().getResource("vocabulary/vocabulary.fxml"));

        stage.setTitle(fxmlLoader.getResources().getString("vocabularyApp.title"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
