package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @FXML
    private ScrollPane scrollPane;

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);

        // Create Root Container
        VBox rootContainer = new VBox();

        // Add Custom Title Bar
        CustomTitleBar titleBar = new CustomTitleBar(stage);
        rootContainer.getChildren().add(titleBar);  // ✅ Add the draggable title bar

        // Add Content
        rootContainer.getChildren().add(Navbar.loadNavbar());
        rootContainer.getChildren().add(Slider.loadSlider());
        rootContainer.getChildren().add(SceneManager.loadSceneAsParent("/dk/easv/mohammadabd/ems/loginPage.fxml"));
        rootContainer.getChildren().add(Slider.loadSlider());

        // Create Scene
        Scene scene = new Scene(rootContainer, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

        // Remove Default Window Borders
        stage.initStyle(javafx.stage.StageStyle.UNDECORATED);

        // Set Scene and Show
        stage.setScene(scene);
        stage.setTitle("Easv Ticket Bar System");
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
