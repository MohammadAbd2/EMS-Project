package dk.easv.mohammadabd.ems.GUI.View;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;


import java.io.IOException;

public class TicketPage {

    public static Node loadPage(ActionEvent event) {
        try {
            VBox application = new VBox();
            VBox rootContainer = new VBox();
            VBox body = new VBox();

            FXMLLoader loader = new FXMLLoader(TicketPage.class.getResource("/dk/easv/mohammadabd/ems/TicketPage.fxml"));
            Parent ticketContent = loader.load();


            //body.getChildren().add(Ticket.loadPage());
            //body.getChildren().getLast().setId("TicketAnchor");
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
