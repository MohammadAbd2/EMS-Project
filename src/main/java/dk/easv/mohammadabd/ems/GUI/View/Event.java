package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Event {
    public static Node loadPage(){
        try {
            VBox application = new VBox();
            VBox rootContainer = new VBox();
            VBox body = new VBox();

            FXMLLoader loader = new FXMLLoader(TicketPage.class.getResource("/dk/easv/mohammadabd/ems/EventPage.fxml"));
            Parent ticketContent = loader.load();

            body.getChildren().add(ticketContent);

            rootContainer.getChildren().add(body);
            application.getChildren().add(rootContainer);

            return application;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
