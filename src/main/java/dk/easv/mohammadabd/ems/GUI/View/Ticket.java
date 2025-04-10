package dk.easv.mohammadabd.ems.GUI.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Ticket {
    public static Node loadPage() {
        try {
            StackPane ticketContainer = new StackPane(); // Changed from VBox to StackPane

            FXMLLoader loader = new FXMLLoader(TicketPage.class.getResource("/dk/easv/mohammadabd/ems/Ticket.fxml"));
            Parent ticket = loader.load();

            ticketContainer.getChildren().add(ticket);
            return ticketContainer;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
