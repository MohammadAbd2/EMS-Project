package dk.easv.mohammadabd.ems.DAL;

import dk.easv.mohammadabd.ems.BE.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCustomer {
    private final DBConnector dbConnector;

    public DBCustomer() {
        dbConnector = new DBConnector();
    }

    // Create a new customer
    public void createCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (username, password, email, phone_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, customer.getUsername());
            pstmt.setString(2, customer.getPassword());
            pstmt.setString(3, customer.getEmail());
            pstmt.setInt(4, customer.getPhoneNumber());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read all customers
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("phone_number")
                ));
            }
        }
        return customers;
    }

    // Update customer
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET username = ?, password = ?, email = ?, phone_number = ? WHERE customer_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getUsername());
            pstmt.setString(2, customer.getPassword());
            pstmt.setString(3, customer.getEmail());
            pstmt.setInt(4, customer.getPhoneNumber());
            pstmt.setInt(5, customer.getId());

            pstmt.executeUpdate();
        }
    }

    // Delete customer
    public void deleteCustomer(int customerId) throws SQLException {
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            pstmt.executeUpdate();
        }
    }
}