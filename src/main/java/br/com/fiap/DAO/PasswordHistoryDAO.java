package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.PasswordHistory;

public class PasswordHistoryDAO {
    private Connection connection;

    public PasswordHistoryDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(PasswordHistory passwordHistory) throws SQLException {
        String sql = "INSERT INTO password_histories (id, operator_id, change_operator_id, password, password_change_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, passwordHistory.getId());
            stmt.setInt(2, passwordHistory.getOperatorId());
            stmt.setInt(3, passwordHistory.getChangeOperatorId());
            stmt.setString(4, passwordHistory.getPassword());
            stmt.setDate(5, new java.sql.Date(passwordHistory.getPasswordChangeDate().getTime()));
            stmt.executeUpdate();
        }
    }

    public PasswordHistory findById(int id) throws SQLException {
        String sql = "SELECT * FROM password_histories WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PasswordHistory(rs.getInt("id"), rs.getInt("operator_id"), rs.getInt("change_operator_id"), rs.getString("password"), rs.getDate("password_change_date"));
                }
            }
        }
        return null;
    }

    public List<PasswordHistory> findAll() throws SQLException {
        List<PasswordHistory> passwordHistories = new ArrayList<>();
        String sql = "SELECT * FROM password_histories";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                passwordHistories.add(new PasswordHistory(rs.getInt("id"), rs.getInt("operator_id"), rs.getInt("change_operator_id"), rs.getString("password"), rs.getDate("password_change_date")));
            }
        }
        return passwordHistories;
    }

    public void update(PasswordHistory passwordHistory) throws SQLException {
        String sql = "UPDATE password_histories SET operator_id = ?, change_operator_id = ?, password = ?, password_change_date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, passwordHistory.getOperatorId());
            stmt.setInt(2, passwordHistory.getChangeOperatorId());
            stmt.setString(3, passwordHistory.getPassword());
            stmt.setDate(4, new java.sql.Date(passwordHistory.getPasswordChangeDate().getTime()));
            stmt.setInt(5, passwordHistory.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM password_histories WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
