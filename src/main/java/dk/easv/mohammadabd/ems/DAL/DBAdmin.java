package dk.easv.mohammadabd.ems.DAL;

import dk.easv.mohammadabd.ems.BE.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAdmin {
    private final DBConnector dbConnector;

    public DBAdmin() {
        dbConnector = new DBConnector();
    }

    // Create a new admin
    public void createAdmin(Admin admin) throws SQLException {
        String sql = "INSERT INTO admin (username, password, email, phone_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, admin.getUsername());
            pstmt.setString(2, admin.getPassword());
            pstmt.setString(3, admin.getEmail());
            pstmt.setInt(4, admin.getPhoneNumber());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    admin.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read all admins
    public List<Admin> getAllAdmins() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM EMSDatabase.EMS_schema.Admin";
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                admins.add(new Admin(
                        rs.getInt("admin_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("phone_number")
                ));
            }
        }
        return admins;
    }

    // Update an existing admin
    public void updateAdmin(Admin admin) throws SQLException {
        String sql = "UPDATE admin SET username = ?, password = ?, email = ?, phone_number = ? WHERE admin_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, admin.getUsername());
            pstmt.setString(2, admin.getPassword());
            pstmt.setString(3, admin.getEmail());
            pstmt.setInt(4, admin.getPhoneNumber());
            pstmt.setInt(5, admin.getId());

            pstmt.executeUpdate();
        }
    }

    // Delete an admin
    public void deleteAdmin(int adminId) throws SQLException {
        String sql = "DELETE FROM admin WHERE admin_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, adminId);
            pstmt.executeUpdate();
        }
    }
}
