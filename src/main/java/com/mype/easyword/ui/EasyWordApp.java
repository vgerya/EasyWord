package com.mype.easyword.ui;

import com.cathive.fx.guice.GuiceApplication;
import com.cathive.fx.guice.GuiceFXMLLoader;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.mype.easyword.EasyWordModule;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hsqldb.server.Server;

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

    @Override
    public void init(List<Module> modules) throws Exception {
        modules.add(new EasyWordModule());
    }

    @Override
    public void start(final Stage stage) throws Exception {

        // FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.messages", Locale.getDefault()));
        Parent root = fxmlLoader.load(EasyWordApp.class.getResource("vocabulary/vocabulary.fxml")).getRoot();


//        stage.setTitle(fxmlLoader.getResources().getString("vocabularyApp.title"));
        stage.setTitle(resources.getString("vocabularyApp.title"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.setAddress("127.0.0.1");
        server.setPort(9191);
        server.setDatabaseName(0, "vocabulary");
        server.setDatabasePath(0, "db/vocabulary");
        server.start();

        launch(args);

        server.stop();
    }
}
