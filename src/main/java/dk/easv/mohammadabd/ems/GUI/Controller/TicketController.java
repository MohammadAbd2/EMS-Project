package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.BE.Ticket;
import dk.easv.mohammadabd.ems.BLL.TicketBL;
import dk.easv.mohammadabd.ems.GUI.Model.TicketML;
import dk.easv.mohammadabd.ems.GUI.View.Event;
import dk.easv.mohammadabd.ems.GUI.View.EventPage;
import dk.easv.mohammadabd.ems.GUI.View.Events;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TicketController {
    Ticket ticket = new Ticket();
    private final TicketBL ticketBL;
    private TicketBillController ticketBillController;


    @FXML
    private TextField eventNameField;
    @FXML
    private TextField ticketTypeField;
    @FXML
    private TextField startTimeField;
    @FXML
    private TextField endTimeField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField locationGuidanceField;
    @FXML
    private TextField notesField;
    @FXML
    private TextField qrcode;

    @FXML
    public Label ticketNameLabel;
    @FXML
    private Label ticketNotes;
    @FXML
    private Label ticketDateTime;
    @FXML
    private Label ticketLocation;
    @FXML
    private Label ticketLocationGuidance;

    @FXML
    public StackPane mainContainer;





    @FXML
    private Button btnCreate;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    private Ticket selectedTicket;

    @FXML
    private VBox container;


    public TicketController() {
        ticketBL = new TicketBL();
    }




    @FXML
    private void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/dk/easv/mohammadabd/ems/ticket.fxml"));
            Node ticketNode = loader.load();

            // Get controller from loader
            ticketBillController = loader.getController();

            // Add ticket UI to container
            mainContainer.getChildren().add(ticketNode);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    private void updateTicketOnTyping() {
        if (ticketBillController != null && eventNameField.getText() != null) {
            ticket.setEventName(eventNameField.getText());
            ticketBillController.updateTicket(ticket);
        }
        if (ticketBillController != null && ticketTypeField.getText() != null) {
            ticket.setType(ticketTypeField.getText());
            ticketBillController.updateTicket(ticket);
        }
        if (ticketBillController != null && startTimeField.getText() != null) {
            ticket.setStart_time(LocalDateTime.parse(startTimeField.getText()));
            ticketBillController.updateTicket(ticket);
        }
        if (ticketBillController != null && endTimeField.getText() != null) {
            ticket.setEnd_time(LocalDateTime.parse(endTimeField.getText()));
            ticketBillController.updateTicket(ticket);
        }
        if (ticketBillController != null && locationField.getText() != null) {
            ticket.setLocation(locationField.getText());
            ticketBillController.updateTicket(ticket);
        }
        if (ticketBillController != null && locationGuidanceField.getText() != null) {
            ticket.setLocationGuidance(locationGuidanceField.getText());
            ticketBillController.updateTicket(ticket);
        }
        if (ticketBillController != null && notesField.getText() != null) {
            ticket.setNotes(notesField.getText());
            ticketBillController.updateTicket(ticket);
        }
        if (ticketBillController != null && qrcode.getText() != null) {
            ticket.setQrcode(qrcode.getText());
            ticketBillController.updateTicket(ticket);
        }

    }


    /**
     * Calls BLL to create a ticket.
     */
    @FXML
    private void createTicket() {
        Ticket ticket = new Ticket();
        ticket.setEventName(eventNameField.getText());
        ticket.setEnd_time(LocalDateTime.parse(endTimeField.getText()));
        ticket.setStart_time(LocalDateTime.parse(startTimeField.getText()));
        ticket.setLocation(locationField.getText());
        ticket.setLocationGuidance(locationGuidanceField.getText());
        ticket.setNotes(notesField.getText());
        ticket.setQrcode(qrcode.getText());
        ticket.setType(ticketTypeField.getText());

        try {
            // Ensure start_time and end_time are not null and properly formatted
            if (ticket.getStart_time() != null && ticket.getEnd_time() != null) {
                Timestamp startTime = Timestamp.valueOf(ticket.getStart_time().toLocalDate().atTime(ticket.getStart_time().toLocalTime().getHour(), ticket.getStart_time().toLocalTime().getMinute(), ticket.getStart_time().toLocalTime().getSecond()));
                Timestamp endTime = Timestamp.valueOf(ticket.getEnd_time().toLocalDate().atTime(ticket.getEnd_time().toLocalTime().getHour(), ticket.getEnd_time().toLocalTime().getMinute(), ticket.getEnd_time().toLocalTime().getSecond()));

                System.out.println(startTime + " " + endTime);
            } else {
                throw new IllegalArgumentException("Start time or end time is null");
            }
        }  catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the selected ticket.
     */
    @FXML
    private void updateTicket() {
        if (selectedTicket != null) {
            try {
                selectedTicket.setEventName(eventNameField.getText());
                selectedTicket.setStart_time(Timestamp.valueOf(startTimeField.getText()).toLocalDateTime());
                selectedTicket.setEnd_time(Timestamp.valueOf(endTimeField.getText()).toLocalDateTime());
                selectedTicket.setLocation(locationField.getText());
                selectedTicket.setLocationGuidance(locationGuidanceField.getText());
                selectedTicket.setNotes(notesField.getText());
                selectedTicket.setQrcode(qrcode.getText());
                ticketBL.updateTicket(selectedTicket);
                System.out.println(ticketBL);
                clearFields(); // Clear input fields after update

            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Deletes the selected ticket.
     */
    @FXML
    private void deleteTicket() {
        if (selectedTicket != null) {
            try {
                ticketBL.deleteTicket(selectedTicket.getId());
                clearFields(); // Clear input fields after deletion
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void generatData() throws SQLException {
        TicketML ticketML = new TicketML();
        Ticket ticket = ticketML.generateTicket();
        eventNameField.setText(ticket.getEventName());
        ticketTypeField.setText(ticket.getType());
        startTimeField.setText(String.valueOf(ticket.getStart_time()));
        endTimeField.setText(String.valueOf(ticket.getEnd_time()));
        locationField.setText(ticket.getLocation());
        locationGuidanceField.setText(ticket.getLocationGuidance());
        notesField.setText(ticket.getNotes());
        qrcode.setText(ticket.getQrcode());
        updateTicketOnTyping();
    }

    /**
     * Clears the input fields after operation.
     */
    @FXML
    private void clearFields() {
        try {
            if (eventNameField != null && eventNameField.getText() != null) {
                eventNameField.clear();
            }

            if (startTimeField != null && startTimeField.getText() != null) {
                startTimeField.clear();
            }

            if (endTimeField != null && endTimeField.getText() != null) {
                endTimeField.clear();
            }

            if (locationField != null && locationField.getText() != null) {
                locationField.clear();
            }

            if (locationGuidanceField != null && locationGuidanceField.getText() != null) {
                locationGuidanceField.clear();
            }

            if (notesField != null && notesField.getText() != null) {
                notesField.clear();
            }

            if (qrcode != null && qrcode.getText() != null) {
                qrcode.clear();
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public void printTicket(ActionEvent event) {
    }

    public void EmailTicket(ActionEvent event) {
    }
}
