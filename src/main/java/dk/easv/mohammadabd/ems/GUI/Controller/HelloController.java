package dk.easv.mohammadabd.ems.GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView profile_pic;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize() {
        // Load profile image
        Image image = new Image(getClass().getResource("/img/logo.png").toExternalForm());
        profile_pic.setImage(image);

        // Apply circular clipping
        Circle clip = new Circle(profile_pic.getFitWidth() / 3, profile_pic.getFitHeight() / 3, Math.min(profile_pic.getFitWidth(), profile_pic.getFitHeight()) / 3);
        profile_pic.setClip(clip);
    }
}