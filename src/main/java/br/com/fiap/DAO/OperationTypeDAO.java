package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.OperationType;

public class OperationTypeDAO {
    private Connection connection;

    public OperationTypeDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(OperationType operationType) throws SQLException {
        String sql = "INSERT INTO operations_type (id, code, description, enabled, type_operation) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, operationType.getId());
            stmt.setInt(2, operationType.getCode());
            stmt.setString(3, operationType.getDescription());
            stmt.setInt(4, operationType.getEnabled());
            stmt.setInt(5, operationType.getTypeOperation());
            stmt.executeUpdate();
        }
    }

    public OperationType findById(int id) throws SQLException {
        String sql = "SELECT * FROM operations_type WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new OperationType(rs.getInt("id"), rs.getInt("code"), rs.getString("description"), rs.getInt("enabled"), rs.getInt("type_operation"));
                }
            }
        }
        return null;
    }

    public List<OperationType> findAll() throws SQLException {
        List<OperationType> operationTypes = new ArrayList<>();
        String sql = "SELECT * FROM operations_type";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                operationTypes.add(new OperationType(rs.getInt("id"), rs.getInt("code"), rs.getString("description"), rs.getInt("enabled"), rs.getInt("type_operation")));
            }
        }
        return operationTypes;
    }

    public void update(OperationType operationType) throws SQLException {
        String sql = "UPDATE operations_type SET code = ?, description = ?, enabled = ?, type_operation = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, operationType.getCode());
            stmt.setString(2, operationType.getDescription());
            stmt.setInt(3, operationType.getEnabled());
            stmt.setInt(4, operationType.getTypeOperation());
            stmt.setInt(5, operationType.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM operations_type WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
