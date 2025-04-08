package dk.easv.mohammadabd.ems.BLL;

import dk.easv.mohammadabd.ems.BE.Ticket;
import dk.easv.mohammadabd.ems.DAL.DBTicket;

import java.sql.SQLException;
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
    public Ticket createTicket(String eventName, int start_time, int end_time, String location, String locationGuidance, String notes) throws SQLException {
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
    public void generateRandomData() {
        try {
            Random random = new Random();
            String eventName = "Event #" + random.nextInt(1000);
            int startTime = 1600 + random.nextInt(100);  // e.g., 1600 to 1699
            int endTime = startTime + random.nextInt(100);
            String location = "Location " + (char)(65 + random.nextInt(26));
            String guidance = "Follow signs to gate " + random.nextInt(10);
            String notes = "This is a randomly generated ticket.";

            Ticket ticket = createTicket(eventName, startTime, endTime, location, guidance, notes);

            // Print ticket information
            System.out.println("Ticket created successfully:");
            System.out.println("UUID: " + ticket.getId());
            System.out.println("Barcode: " + ticket.getBarcode());
            System.out.println("Event Name: " + ticket.getEventName());
            System.out.println("Start Time: " + ticket.getStart_time());
            System.out.println("End Time: " + ticket.getEnd_time());
            System.out.println("Location: " + ticket.getLocation());
            System.out.println("Location Guidance: " + ticket.getLocationGuidance());
            System.out.println("Notes: " + ticket.getNotes());

        } catch (SQLException e) {
            System.err.println("Error creating random ticket: " + e.getMessage());
        }
    }
}
