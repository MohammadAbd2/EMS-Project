package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {

    private static Stage primaryStage; // Store the primary stage
    private static final Map<String, Parent> scenes = new HashMap<>(); // Store scenes

    // ✅ Set the primary stage
    public static void setStage(Stage stage) {
        primaryStage = stage;
    }

    public static Stage getStage() {
        return primaryStage;}

    // ✅ Load a scene and store it
    public static void loadScene(String name, String fxmlPath) throws IOException {
        URL fxmlUrl = SceneManager.class.getResource(fxmlPath);
        if (fxmlUrl == null) {
            System.err.println("Error: FXML file not found at " + fxmlPath);
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Parent root = fxmlLoader.load();
        scenes.put(name, root);
    }

    // ✅ Switch to a loaded scene
    public static void switchScene(String name) {
        if (primaryStage == null) {
            System.err.println("Error: Primary stage is not set.");
            return;
        }

        Parent root = scenes.get(name);
        if (root == null) {
            System.err.println("Error: Scene '" + name + "' is not loaded.");
            return;
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // ✅ Load a scene as Parent (for adding inside VBox)
    public static Parent loadSceneAsParent(String fxmlPath) throws IOException {
        URL fxmlUrl = SceneManager.class.getResource(fxmlPath);
        if (fxmlUrl == null) {
            System.err.println("Error: FXML file not found at " + fxmlPath);
            return null;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        return fxmlLoader.load();
    }
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void registerScene(String name, Scene scene) {
        if (primaryStage == null) {
            System.err.println("Primary stage not set.");
            return;
        }
        scenes.put(name, scene.getRoot());
    }


}
