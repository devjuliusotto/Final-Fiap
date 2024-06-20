package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.Operation;

public class OperationDAO {
    private Connection connection;

    public OperationDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Operation operation) throws SQLException {
        String sql = "INSERT INTO operations (id, description, type) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, operation.getId());
            stmt.setString(2, operation.getDescription());
            stmt.setInt(3, operation.getType());
            stmt.executeUpdate();
        }
    }

    public Operation findById(int id) throws SQLException {
        String sql = "SELECT * FROM operations WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Operation(rs.getInt("id"), rs.getString("description"), rs.getInt("type"));
                }
            }
        }
        return null;
    }

    public List<Operation> findAll() throws SQLException {
        List<Operation> operations = new ArrayList<>();
        String sql = "SELECT * FROM operations";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                operations.add(new Operation(rs.getInt("id"), rs.getString("description"), rs.getInt("type")));
            }
        }
        return operations;
    }

    public void update(Operation operation) throws SQLException {
        String sql = "UPDATE operations SET description = ?, type = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operation.getDescription());
            stmt.setInt(2, operation.getType());
            stmt.setInt(3, operation.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM operations WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
