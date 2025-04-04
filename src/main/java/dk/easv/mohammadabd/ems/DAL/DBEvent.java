package dk.easv.mohammadabd.ems.DAL;

import dk.easv.mohammadabd.ems.BE.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBEvent {
    private final DBConnector dbConnector;

    public DBEvent() {
        dbConnector = new DBConnector();
    }

    // Create a new event
    public void createEvent(Event event) throws SQLException {
        String sql = "INSERT INTO event (event_name, start_time, end_time, location, location_guidance, notes) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, event.getStart_time());
            pstmt.setDate(3, event.getEnd_time());
            pstmt.setString(4, event.getLocation());
            pstmt.setString(5, event.getLocationGuidance());
            pstmt.setString(6, event.getNotes());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    event.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read all events
    public List<Event> getAllEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event";
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                events.add(new Event(
                        rs.getInt("event_id"),
                        rs.getString("event_name"),
                        rs.getDate("start_time"),
                        rs.getDate("end_time"),
                        rs.getString("location"),
                        rs.getString("location_guidance"),
                        rs.getString("notes")
                ));
            }
        }
        return events;
    }

    // Update an existing event
    public void updateEvent(Event event) throws SQLException {
        String sql = "UPDATE event SET event_name = ?, start_time = ?, end_time = ?, location = ?, location_guidance = ?, notes = ? WHERE event_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setDate(2, event.getStart_time());
            pstmt.setDate(3, event.getEnd_time());
            pstmt.setString(4, event.getLocation());
            pstmt.setString(5, event.getLocationGuidance());
            pstmt.setString(6, event.getNotes());
            pstmt.setInt(7, event.getId());

            pstmt.executeUpdate();
        }
    }

    // Delete an event
    public void deleteEvent(int eventId) throws SQLException {
        String sql = "DELETE FROM event WHERE event_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }
}
