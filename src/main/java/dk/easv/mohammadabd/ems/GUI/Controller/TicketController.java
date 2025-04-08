package dk.easv.mohammadabd.ems.GUI.Controller;

import dk.easv.mohammadabd.ems.BE.Ticket;
import dk.easv.mohammadabd.ems.BLL.TicketBL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.sql.SQLException;
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
        // Initialize the buttons with their actions
        btnCreate.setOnAction(event -> createTicket());
        btnUpdate.setOnAction(event -> updateTicket());
        btnDelete.setOnAction(event -> deleteTicket());
    }

    /**
     * Calls BLL to create a ticket.
     */
    @FXML
    private void createTicket() {
        try {
            String eventName = eventNameField.getText();
            int startTime = Integer.parseInt(startTimeField.getText());
            int endTime = Integer.parseInt(endTimeField.getText());
            String location = locationField.getText();
            String locationGuidance = locationGuidanceField.getText();
            String notes = notesField.getText();

            Ticket ticket = ticketBL.createTicket(eventName, startTime, endTime, location, locationGuidance, notes);

            barcodeField.setText(ticket.getBarcode()); // Display the generated barcode
            clearFields(); // Clear input fields after creation

        } catch (SQLException | NumberFormatException e) {
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
                selectedTicket.setStart_time(Integer.parseInt(startTimeField.getText()));
                selectedTicket.setEnd_time(Integer.parseInt(endTimeField.getText()));
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
    private void generatData(){
        TicketBL ticketBL = new TicketBL();
        ticketBL.generateRandomData();
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
