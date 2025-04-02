package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class login {
    @FXML
    private Button ticketButton; // Button to trigger the ticketTab method

    public void start() throws IOException {
        final String FXML_PATH = "/dk/easv/mohammadabd/ems/loginPage.fxml";
        final String CSS_PATH = "/css/style.css";

        // Validate FXML file existence
        URL fxmlUrl = getClass().getResource(FXML_PATH);
        if (fxmlUrl == null) {
            System.err.println("Error: FXML file not found at " + FXML_PATH);
            return;
        }

        // Load FXML
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(fxmlLoader.load());

        // Validate and apply CSS
        URL cssUrl = getClass().getResource(CSS_PATH);
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.err.println("Warning: CSS file not found at " + CSS_PATH);
        }

        // Get the current stage and switch the scene
        Stage stage = (Stage) ticketButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
