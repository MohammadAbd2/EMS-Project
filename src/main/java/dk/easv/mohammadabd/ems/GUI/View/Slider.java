package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;

public class Slider {

    private static final String SLIDER_FXML = "/dk/easv/mohammadabd/ems/slider.fxml";
    private static final String SLIDER_IMAGE_PATH = "/img/slider_img.png"; // Slider image

    public static Parent loadSlider() throws IOException {
        URL fxmlUrl = Slider.class.getResource(SLIDER_FXML);
        if (fxmlUrl == null) {
            System.err.println("Error: FXML file not found at " + SLIDER_FXML);
            return null;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Parent sliderRoot = fxmlLoader.load();

        // Set slider image
        setImage(sliderRoot, "#slider", SLIDER_IMAGE_PATH);

        return sliderRoot;
    }

    private static void setImage(Parent root, String fxId, String imagePath) {
        URL imgUrl = Slider.class.getResource(imagePath);
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
