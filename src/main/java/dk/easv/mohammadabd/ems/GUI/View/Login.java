package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class Login {

    private static final String LOGIN_FXML = "/dk/easv/mohammadabd/ems/loginPage.fxml";
    private static final String CSS_PATH = "/css/style.css";

    public static Parent loadLogin() throws IOException {
        URL fxmlUrl = Login.class.getResource(LOGIN_FXML);
        if (fxmlUrl == null) {
            System.err.println("Error: FXML file not found at " + LOGIN_FXML);
            return null;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Parent loginRoot = fxmlLoader.load();

        // Apply CSS
        URL cssUrl = Login.class.getResource(CSS_PATH);
        if (cssUrl != null) {
            loginRoot.getStylesheets().add(cssUrl.toExternalForm());

        } else {
            System.err.println("Warning: CSS file not found at " + CSS_PATH);
        }

        return loginRoot;
    }
}
