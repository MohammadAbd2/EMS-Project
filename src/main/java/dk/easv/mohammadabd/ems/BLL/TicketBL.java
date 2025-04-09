package dk.easv.mohammadabd.ems.BLL;
import java.time.format.DateTimeFormatter;
import dk.easv.mohammadabd.ems.BE.Ticket;
import dk.easv.mohammadabd.ems.DAL.DBTicket;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TicketBL {
    private final DBTicket dbTicket;

    public TicketBL() {
        dbTicket = new DBTicket();
    }

    /**
     * Creates a new ticket with a generated UUID and barcode.
     */
    public Ticket createTicket(String eventName, LocalDateTime start_time, LocalDateTime end_time, String location, String locationGuidance, String notes) throws SQLException {
        UUID uuid = UUID.randomUUID(); // Generate a unique ID for the ticket
        String barcode = generateBarcode(uuid); // Generate a barcode based on the UUID
        Ticket ticket = new Ticket(uuid, eventName, start_time, end_time, location, locationGuidance, notes, barcode);
        dbTicket.createTicket(ticket); // Persist the ticket in the database
        return ticket;
    }

    /**
     * Retrieves all tickets from the database.
     */
    public List<Ticket> getAllTickets() throws SQLException {
        return dbTicket.getAllTickets();
    }

    /**
     * Updates the given ticket in the database.
     */
    public void updateTicket(Ticket ticket) throws SQLException {
        dbTicket.updateTicket(ticket);
    }

    /**
     * Deletes a ticket from the database by its UUID.
     */
    public void deleteTicket(UUID ticketId) throws SQLException {
        dbTicket.deleteTicket(ticketId);
    }

    /**
     * Generates a simple barcode string from the ticket UUID.
     */
    private String generateBarcode(UUID uuid) {
        return "BAR-" + uuid.toString().substring(0, 8).toUpperCase();
    }

    /**
     * Generates a ticket with random data, saves it in the database, and prints its details.
     */
    public Ticket generateRandomData() throws SQLException {
        // Generate random data
        UUID UUserID = UUID.randomUUID();
        String randomEventName = "Event " + UUID.randomUUID().toString();

        int randomHour = new Random().nextInt(24);
        LocalDateTime randomStartTime = LocalDateTime.now().withHour(randomHour).withMinute(0).withSecond(0).withNano(0);
        // Generate end time, 2 hours after the start time
        LocalDateTime randomEndTime = randomStartTime.plusHours(2);
        // Format for display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        randomStartTime.format(formatter);
        randomEndTime = randomStartTime.plusHours(2); // Example: end time 2 hours after start
        String randomLocation = "Location " + (int) (Math.random() * 100);
        String randomLocationGuidance = "Guidance for " + randomLocation;
        String randomNotes = "Notes for the event.";
        String randomBarcode = UUID.randomUUID().toString(); // Example barcode

        // Create and return a Ticket object with the generated data

        Ticket ticket = new Ticket(UUserID, randomEventName, randomStartTime, randomEndTime, randomLocation, randomLocationGuidance, randomNotes, randomBarcode);
        return ticket;
    }
}
