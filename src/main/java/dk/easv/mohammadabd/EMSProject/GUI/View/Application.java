package dk.easv.mohammadabd.EMSProject.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {

    private static final String FXML_PATH = "/dk/easv/mohammadabd/EMSProject/hello-view.fxml";
    private static final String CSS_PATH = "/css/style.css";
    private static final String LOGO_PATH = "/img/logo.png"; // Path to the logo
    private static final String ProfilePic_PATH = "/img/logo.png";
    @Override
    public void start(Stage stage) throws IOException {
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

        // Load the logo and set it in the FXML controller
        URL logoUrl = getClass().getResource(LOGO_PATH);
        if (logoUrl != null) {
            ImageView logoView = (ImageView) scene.lookup("#logo"); // Get ImageView from FXML
            if (logoView != null) {
                logoView.setImage(new Image(logoUrl.toExternalForm()));
            } else {
                System.err.println("Warning: ImageView with fx:id='logo' not found in FXML.");
            }
        } else {
            System.err.println("Warning: Logo file not found at " + LOGO_PATH);
        }


        // Load the picture in the FXML controller
        URL profilePic_url = getClass().getResource(ProfilePic_PATH);
        if (profilePic_url != null) {
            ImageView logoView = (ImageView) scene.lookup("#profile_pic"); // Get ImageView from FXML
            if (logoView != null) {
                logoView.setImage(new Image(logoUrl.toExternalForm()));
            } else {
                System.err.println("Warning: ImageView with fx:id='logo' not found in FXML.");
            }
        } else {
            System.err.println("Warning: Logo file not found at " + ProfilePic_PATH);
        }

        // Configure and show the stage
        stage.setTitle("Easv Ticket Bar System");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
