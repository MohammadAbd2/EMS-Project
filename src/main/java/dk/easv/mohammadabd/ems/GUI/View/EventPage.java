package dk.easv.mohammadabd.ems.GUI.View;

import dk.easv.mohammadabd.ems.GUI.View.Header.Slider;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class EventPage {
    public static Node loadPage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(EventPage.class.getResource("/dk/easv/mohammadabd/ems/EventPage.fxml"));
        try {
            VBox Body = new VBox();
            //add the new component here bellow
            Body.getChildren().add(Slider.loadSlider("/img/slider_img.png"));
            // add the fxml to the body
            Body.getChildren().add(loader.load());

            return Body;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
