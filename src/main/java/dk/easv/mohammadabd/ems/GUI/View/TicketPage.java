package dk.easv.mohammadabd.ems.GUI.View;

import dk.easv.mohammadabd.ems.GUI.View.Header.CustomTitleBar;
import dk.easv.mohammadabd.ems.GUI.View.Header.Navbar;
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
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            VBox application = new VBox();
            VBox rootContainer = new VBox();
            VBox body = new VBox();

            FXMLLoader loader = new FXMLLoader(TicketPage.class.getResource("/dk/easv/mohammadabd/ems/TicketComponent.fxml"));
            Parent ticketContent = loader.load();

            body.getChildren().add(ticketContent);

            ScrollPane scrollPane = new ScrollPane(body);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.getStyleClass().add("scroll-pane");

            rootContainer.getChildren().add(scrollPane);
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
