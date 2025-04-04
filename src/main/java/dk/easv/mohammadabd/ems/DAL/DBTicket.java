package dk.easv.mohammadabd.ems.DAL;

import dk.easv.mohammadabd.ems.BE.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTicket {
    private final DBConnector dbConnector;

    public DBTicket() {
        dbConnector = new DBConnector();
    }

    // Create a new ticket
    public void createTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO ticket (event_name, start_time, end_time, location, location_guidance, notes) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, ticket.getEventName());
            pstmt.setInt(2, ticket.getStart_time());
            pstmt.setInt(3, ticket.getEnd_time());
            pstmt.setString(4, ticket.getLocation());
            pstmt.setString(5, ticket.getLocationGuidance());
            pstmt.setString(6, ticket.getNotes());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ticket.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read all tickets
    public List<Ticket> getAllTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM ticket";
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getString("event_name"),
                        rs.getInt("start_time"),
                        rs.getInt("end_time"),
                        rs.getString("location"),
                        rs.getString("location_guidance"),
                        rs.getString("notes")
                ));
            }
        }
        return tickets;
    }

    // Update an existing ticket
    public void updateTicket(Ticket ticket) throws SQLException {
        String sql = "UPDATE ticket SET event_name = ?, start_time = ?, end_time = ?, location = ?, location_guidance = ?, notes = ? WHERE ticket_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticket.getEventName());
            pstmt.setInt(2, ticket.getStart_time());
            pstmt.setInt(3, ticket.getEnd_time());
            pstmt.setString(4, ticket.getLocation());
            pstmt.setString(5, ticket.getLocationGuidance());
            pstmt.setString(6, ticket.getNotes());
            pstmt.setInt(7, ticket.getId());

            pstmt.executeUpdate();
        }
    }

    // Delete a ticket
    public void deleteTicket(int ticketId) throws SQLException {
        String sql = "DELETE FROM ticket WHERE ticket_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ticketId);
            pstmt.executeUpdate();
        }
    }
}
