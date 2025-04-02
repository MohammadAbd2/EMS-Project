package dk.easv.mohammadabd.ems.GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class NavbarController {
    @FXML
    private ImageView profile_pic;

    public void initialize() {
        // Load profile image
        Image image = new Image(getClass().getResource("/img/logo.png").toExternalForm());
        profile_pic.setImage(image);

        // Apply circular clipping
        Circle clip = new Circle(profile_pic.getFitWidth() / 3, profile_pic.getFitHeight() / 3, Math.min(profile_pic.getFitWidth(), profile_pic.getFitHeight()) / 3);
        profile_pic.setClip(clip);
    }
    public void ticketTab(ActionEvent event) {

    }
}
