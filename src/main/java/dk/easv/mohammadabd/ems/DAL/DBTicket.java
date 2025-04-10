package dk.easv.mohammadabd.ems.DAL;

import dk.easv.mohammadabd.ems.BE.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBTicket {
    private final DBConnector dbConnector;

    public DBTicket() {
        dbConnector = new DBConnector();
    }

    /**
     * Inserts a new ticket into the database.
     *
     * @param ticket the Ticket object to insert
     * @throws SQLException if a database access error occurs
     */
    public void createTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO ticket (ticket_id, event_name, start_time, end_time, location, location_guidance, notes, qrcode) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticket.getId().toString());
            pstmt.setString(2, ticket.getEventName());
            pstmt.setTimestamp(3, Timestamp.valueOf(ticket.getStart_time()));  // Corrected to use Timestamp
            pstmt.setTimestamp(4, Timestamp.valueOf(ticket.getEnd_time()));    // Corrected to use Timestamp
            pstmt.setString(5, ticket.getLocation());
            pstmt.setString(6, ticket.getLocationGuidance());
            pstmt.setString(7, ticket.getNotes());
            pstmt.setString(8, ticket.getQrcode());

            pstmt.executeUpdate();
        }
    }

    /**
     * Retrieves all tickets from the database.
     *
     * @return a list of Ticket objects
     * @throws SQLException if a database access error occurs
     */
    public List<Ticket> getAllTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM ticket";
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ticket ticket = new Ticket(
                        UUID.fromString(rs.getString("ticket_id")),
                        rs.getString("event_name"),
                        rs.getTimestamp("start_time").toLocalDateTime(),  // Corrected to convert Timestamp to LocalDateTime
                        rs.getTimestamp("end_time").toLocalDateTime(),    // Corrected to convert Timestamp to LocalDateTime
                        rs.getString("location"),
                        rs.getString("location_guidance"),
                        rs.getString("notes"),
                        rs.getString("qrcode")
                );
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    /**
     * Updates an existing ticket in the database.
     *
     * @param ticket the Ticket object with updated data
     * @throws SQLException if a database access error occurs
     */
    public void updateTicket(Ticket ticket) throws SQLException {
        String sql = "UPDATE ticket SET event_name = ?, start_time = ?, end_time = ?, location = ?, location_guidance = ?, notes = ?, qrcode = ? " +
                "WHERE ticket_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticket.getEventName());
            pstmt.setTimestamp(2, Timestamp.valueOf(ticket.getStart_time()));  // Corrected to use Timestamp
            pstmt.setTimestamp(3, Timestamp.valueOf(ticket.getEnd_time()));    // Corrected to use Timestamp
            pstmt.setString(4, ticket.getLocation());
            pstmt.setString(5, ticket.getLocationGuidance());
            pstmt.setString(6, ticket.getNotes());
            pstmt.setString(7, ticket.getQrcode());
            pstmt.setString(8, ticket.getId().toString());

            pstmt.executeUpdate();
        }
    }

    /**
     * Deletes a ticket by its UUID.
     *
     * @param ticketId the UUID of the ticket to delete
     * @throws SQLException if a database access error occurs
     */
    public void deleteTicket(UUID ticketId) throws SQLException {
        String sql = "DELETE FROM ticket WHERE ticket_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticketId.toString());
            pstmt.executeUpdate();
        }
    }
}
