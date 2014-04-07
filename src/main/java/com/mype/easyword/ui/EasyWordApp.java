package com.mype.easyword.ui;

import com.cathive.fx.guice.GuiceApplication;
import com.cathive.fx.guice.GuiceFXMLLoader;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.mype.easyword.EasyWordModule;
import com.mype.easyword.db.DatabaseDaemon;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class EasyWordApp extends GuiceApplication {
    @Inject
    private GuiceFXMLLoader fxmlLoader;

    @Inject
    private ResourceBundle resources;

    @Inject
    private DatabaseDaemon databaseDaemon;

    @Override
    public void init(List<Module> modules) throws Exception {
        modules.add(new JpaPersistModule("VocabularyUnit"));
        modules.add(new EasyWordModule());
    }

    @Override
    public void start(final Stage stage) throws Exception {
        databaseDaemon.start();
        try {
            Parent root = fxmlLoader.load(EasyWordApp.class.getResource("vocabulary/vocabulary.fxml")).getRoot();
            stage.setTitle(resources.getString("vocabularyApp.title"));
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add("/styles/styles.css");
            stage.setScene(scene);

            stage.show();
        } finally {
            databaseDaemon.stop();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
