package dk.easv.mohammadabd.ems.DAL;

import dk.easv.mohammadabd.ems.BE.EventCoordinator;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBEventCoordinator {
    private final DBConnector dbConnector;

    public DBEventCoordinator() {
        dbConnector = new DBConnector();
    }

    // Create a new event coordinator
    public void createEventCoordinator(EventCoordinator ec) throws SQLException {
        String sql = "INSERT INTO event_coordinator (username, password, email, phone_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, ec.getUsername());
            pstmt.setString(2, ec.getPassword());
            pstmt.setString(3, ec.getEmail());
            pstmt.setInt(4, ec.getPhoneNumber());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ec.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read all event coordinators
    public List<EventCoordinator> getAllEventCoordinators() throws SQLException {
        List<EventCoordinator> coordinators = new ArrayList<>();
        String sql = "SELECT * FROM event_coordinator";
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                coordinators.add(new EventCoordinator(
                        rs.getInt("event_coordinator_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("phone_number")
                ));
            }
        }
        return coordinators;
    }

    // Update an event coordinator
    public void updateEventCoordinator(EventCoordinator ec) throws SQLException {
        String sql = "UPDATE event_coordinator SET username = ?, password = ?, email = ?, phone_number = ? WHERE event_coordinator_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ec.getUsername());
            pstmt.setString(2, ec.getPassword());
            pstmt.setString(3, ec.getEmail());
            pstmt.setInt(4, ec.getPhoneNumber());
            pstmt.setInt(5, ec.getId());

            pstmt.executeUpdate();
        }
    }

    // Delete an event coordinator
    public void deleteEventCoordinator(int ecId) throws SQLException {
        String sql = "DELETE FROM event_coordinator WHERE event_coordinator_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ecId);
            pstmt.executeUpdate();
        }
    }
}
