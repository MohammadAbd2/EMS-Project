package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.BE.Ticket;
import dk.easv.mohammadabd.ems.BLL.TicketBL;
import dk.easv.mohammadabd.ems.GUI.Model.TicketML;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TicketController {
    private final TicketBL ticketBL;

    @FXML
    private TextField eventNameField;
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
    private TextField barcodeField;

    @FXML
    private Button btnCreate;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    private Ticket selectedTicket;

    public TicketController() {
        ticketBL = new TicketBL();
    }

    @FXML
    private void initialize() {

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
        ticket.setBarcode(barcodeField.getText());

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

                ticketBL.updateTicket(selectedTicket);
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
        startTimeField.setText(String.valueOf(ticket.getStart_time()));
        endTimeField.setText(String.valueOf(ticket.getEnd_time()));
        locationField.setText(ticket.getLocation());
        locationGuidanceField.setText(ticket.getLocationGuidance());
        notesField.setText(ticket.getNotes());
        barcodeField.setText(ticket.getBarcode());

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

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
