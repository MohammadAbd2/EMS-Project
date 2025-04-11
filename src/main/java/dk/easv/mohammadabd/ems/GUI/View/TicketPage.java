package dk.easv.mohammadabd.ems.GUI.View;

import dk.easv.mohammadabd.ems.GUI.View.Header.CustomTitleBar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Navbar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Slider;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TicketPage {

    public static Node loadPage(ActionEvent event) {
        try {
            VBox application = new VBox();
            VBox rootContainer = new VBox();
            VBox body = new VBox();

            FXMLLoader loader = new FXMLLoader(TicketPage.class.getResource("/dk/easv/mohammadabd/ems/TicketComponent.fxml"));
            Parent ticketContent = loader.load();


            body.getChildren().add(Ticket.loadPage());
            body.getChildren().getLast().setId("TicketAnchor");
            body.getChildren().add(ticketContent);
            body.setSpacing(5);
            body.getChildren().add(Events.loadEventsComponent());
            body.getChildren().getLast().setId("EventTitle");
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
