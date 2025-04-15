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
     * Creates a new ticket with a generated UUID and qrcode.
     */
    public Ticket createTicket(String eventName, LocalDateTime start_time, LocalDateTime end_time, String location, String locationGuidance, String notes , String qrcode, String type) throws SQLException {
        UUID uuid = UUID.randomUUID(); // Generate a unique ID for the ticket

        Ticket ticket = new Ticket(uuid, eventName, start_time, end_time, location, locationGuidance, notes, qrcode, type);
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
     * Generates a simple qrcode string from the ticket UUID.
     */
    private String generateQrcode(UUID uuid) {
        return "QR-" + uuid.toString().substring(0, 8).toUpperCase();
    }

    /**
     * Generates a ticket with random data, saves it in the database, and prints its details.
     */
    public Ticket generateRandomData() throws SQLException {
        // Generate random data
        UUID UUserID = UUID.randomUUID();
        String randomEventName = "Event #" + (int) (Math.random() * 200);
        String randomTicketType = "Standard";
        int randomHour = new Random().nextInt(24);
        LocalDateTime randomStartTime = LocalDateTime.now().withHour(randomHour).withMinute(0).withSecond(0).withNano(0);
        // Generate end time, 2 hours after the start time
        LocalDateTime randomEndTime = randomStartTime.plusHours(2);
        // Format for display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        randomStartTime.format(formatter);
        randomEndTime = randomStartTime.plusHours(2); // Example: end time 2 hours after start
        int randomEventNumber = (int) (Math.random() * 200);
        String randomLocation = "Location " + randomEventNumber;
        String randomLocationGuidance = "Guidance for " + randomEventNumber + " you can entire to the bar from the basement";
        String randomNotes = "Notes for the event : Dance, laugh, celebrate, and enjoy great music and friends";
        String randomQrcode = UUID.randomUUID().toString(); // Example qrcode


        // Create and return a Ticket object with the generated data
        return new Ticket(UUserID, randomEventName, randomStartTime, randomEndTime, randomLocation, randomLocationGuidance, randomNotes, randomQrcode, randomTicketType);
    }
}
