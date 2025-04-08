package dk.easv.mohammadabd.ems.GUI.View;

import dk.easv.mohammadabd.ems.BE.Event;
import dk.easv.mohammadabd.ems.GUI.View.Header.CustomTitleBar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Navbar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Slider;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

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

        // HBox to align SearchFilterBox and Events component side by side
        HBox mainContentBox = new HBox();
        mainContentBox.setSpacing(10); // Set some space between the components

        // Create a VBox for the search and filter section (with fixed width)
        VBox SearchFilterBox = new VBox();
        SearchFilterBox.setPrefWidth(300);
        SearchFilterBox.getChildren().add(Events.loadEventsComponent());

        // Create the FlowPane for events, which is already set in loadEventsComponent
        VBox eventsContainer = Events.loadEventsComponent(); // Use the VBox returned from loadEventsComponent()

        // Allow the events container to grow and fill the remaining space
        HBox.setHgrow(eventsContainer, javafx.scene.layout.Priority.ALWAYS);

        // Add both VBox elements to the HBox
        mainContentBox.getChildren().addAll(SearchFilterBox, eventsContainer);

        // Add the main content box to the root container
        rootContainer.getChildren().add(mainContentBox);

        // Wrap rootContainer inside ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(rootContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Add all the Containers to the Application for loading the scene
        applicationRoot.getChildren().add(windowBarBox);
        applicationRoot.getChildren().add(scrollPane);

        // Now set ScrollPane as the root scene node
        Scene scene = new Scene(applicationRoot, 1200, 800);

        // Add CSS only if not already added
        List<String> stylesheets = scene.getStylesheets();
        if (!stylesheets.contains(getClass().getResource("/css/style.css").toExternalForm())) {
            scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        }

        // Set Stage style before calling show()
        stage.initStyle(StageStyle.UNDECORATED);

        // Set Scene and Show
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
        stage.setTitle("Easv Ticket Bar System");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
