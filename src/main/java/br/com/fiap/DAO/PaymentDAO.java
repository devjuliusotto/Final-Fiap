package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.Payment;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (id, code, description, enabled) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, payment.getId());
            stmt.setLong(2, payment.getCode());
            stmt.setString(3, payment.getDescription());
            stmt.setInt(4, payment.getEnabled());
            stmt.executeUpdate();
        }
    }

    public Payment findById(int id) throws SQLException {
        String sql = "SELECT * FROM payments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Payment(rs.getInt("id"), rs.getLong("code"), rs.getString("description"), rs.getInt("enabled"));
                }
            }
        }
        return null;
    }

    public List<Payment> findAll() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                payments.add(new Payment(rs.getInt("id"), rs.getLong("code"), rs.getString("description"), rs.getInt("enabled")));
            }
        }
        return payments;
    }

    public void update(Payment payment) throws SQLException {
        String sql = "UPDATE payments SET code = ?, description = ?, enabled = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, payment.getCode());
            stmt.setString(2, payment.getDescription());
            stmt.setInt(3, payment.getEnabled());
            stmt.setInt(4, payment.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM payments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
