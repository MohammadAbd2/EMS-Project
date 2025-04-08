package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;

public class EventPage {

    private static final String EVENT_PAGE_FXML = "/dk/easv/mohammadabd/ems/eventPage.fxml";
    private static final String CSS_PATH = "/css/style.css";

    public static Parent loadEventPage() throws IOException {
        URL fxmlUrl = EventPage.class.getResource(EVENT_PAGE_FXML);
        if (fxmlUrl == null) {
            System.err.println("Error: FXML file not found at " + EVENT_PAGE_FXML);
            return null;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Parent root = fxmlLoader.load();

        // CSS
        URL cssUrl = EventPage.class.getResource(CSS_PATH);
        if (cssUrl != null) {
            root.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.err.println("Warning: CSS file not found at " + CSS_PATH);
        }

        // so there's no white background beyond the design
        StackPane wrapper = new StackPane(root);
        wrapper.setStyle("-fx-background-color: #0077DF;");

        return wrapper;
    }
}
