package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;

public class Navbar {

    private static final String NAVBAR_FXML = "/dk/easv/mohammadabd/ems/navbar.fxml";
    private static final String CSS_PATH = "/css/style.css";
    private static final String LOGO_PATH = "/img/logo.png"; // Path to the logo
    private static final String PROFILE_PIC_PATH = "/img/profile_picture.png"; // Profile Picture

    public static Parent loadNavbar() throws IOException {
        URL fxmlUrl = Navbar.class.getResource(NAVBAR_FXML);
        if (fxmlUrl == null) {
            System.err.println("Error: FXML file not found at " + NAVBAR_FXML);
            return null;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Parent navbarRoot = fxmlLoader.load();

        // Apply CSS
        URL cssUrl = Navbar.class.getResource(CSS_PATH);
        if (cssUrl != null) {
            navbarRoot.getStylesheets().add(cssUrl.toExternalForm());
        }

        // Set logo
        setImage(navbarRoot, "#logo", LOGO_PATH);
        // Set profile picture
        setImage(navbarRoot, "#profile_pic", PROFILE_PIC_PATH);

        return navbarRoot;
    }

    private static void setImage(Parent root, String fxId, String imagePath) {
        URL imgUrl = Navbar.class.getResource(imagePath);
        if (imgUrl != null) {
            ImageView imageView = (ImageView) root.lookup(fxId);
            if (imageView != null) {
                imageView.setImage(new Image(imgUrl.toExternalForm()));
            } else {
                System.err.println("Warning: ImageView with fx:id='" + fxId + "' not found.");
            }
        } else {
            System.err.println("Warning: Image file not found at " + imagePath);
        }
    }
}
