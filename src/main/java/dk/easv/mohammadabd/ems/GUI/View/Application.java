package dk.easv.mohammadabd.ems.GUI.View;

import dk.easv.mohammadabd.ems.BE.Event;
import dk.easv.mohammadabd.ems.GUI.View.Header.CustomTitleBar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Navbar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Slider;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application extends javafx.application.Application {
    @FXML
    private ScrollPane scrollPane;

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        VBox applicationRoot = new VBox();

        // Create TopBar Container
        VBox windowBarBox = new VBox();
        VBox rootContainer = new VBox();
        CustomTitleBar titleBar = new CustomTitleBar(stage);

        windowBarBox.getChildren().add(titleBar); // Add the draggable title bar

        // Add UI components
        rootContainer.getChildren().add(Navbar.loadNavbar());
        rootContainer.getChildren().add(Slider.loadSlider());
        rootContainer.getChildren().add(Events.loadEventsComponent());

        // Wrap rootContainer inside ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(rootContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.getStyleClass().add("scroll-pane"); // Apply CSS styles

        // Add all the Containers to the Application for loading the scene
        applicationRoot.getChildren().add(windowBarBox);
        applicationRoot.getChildren().add(scrollPane);

        // Now set ScrollPane as the root scene node
        Scene scene = new Scene(applicationRoot, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

        // Remove Default Window Borders
        try {
            stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set Application Icon
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));

        // Set Scene and Show
        stage.setScene(scene);
        stage.setTitle("Easv Ticket Bar System");
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
