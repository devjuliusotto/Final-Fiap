package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.Operator;

public class OperatorDAO {
    private Connection connection;

    public OperatorDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Operator operator) throws SQLException {
        String sql = "INSERT INTO operators (id, first_name, last_name, email, password, passcode_expiry_date, passwd_failure_retry, last_passwd_failure_date, permission_profile_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, operator.getId());
            stmt.setString(2, operator.getFirstName());
            stmt.setString(3, operator.getLastName());
            stmt.setString(4, operator.getEmail());
            stmt.setString(5, operator.getPassword());
            stmt.setDate(6, new java.sql.Date(operator.getPasscodeExpiryDate().getTime()));
            stmt.setInt(7, operator.getPasswdFailureRetry());
            stmt.setDate(8, operator.getLastPasswdFailureDate() != null ? new java.sql.Date(operator.getLastPasswdFailureDate().getTime()) : null);
            stmt.setInt(9, operator.getPermissionProfileId());
            stmt.executeUpdate();
        }
    }

    public Operator findById(int id) throws SQLException {
        String sql = "SELECT * FROM operators WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Operator(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"), rs.getDate("passcode_expiry_date"), rs.getInt("passwd_failure_retry"), rs.getDate("last_passwd_failure_date"), rs.getInt("permission_profile_id"));
                }
            }
        }
        return null;
    }

    public List<Operator> findAll() throws SQLException {
        List<Operator> operators = new ArrayList<>();
        String sql = "SELECT * FROM operators";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                operators.add(new Operator(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"), rs.getDate("passcode_expiry_date"), rs.getInt("passwd_failure_retry"), rs.getDate("last_passwd_failure_date"), rs.getInt("permission_profile_id")));
            }
        }
        return operators;
    }

    public void update(Operator operator) throws SQLException {
        String sql = "UPDATE operators SET first_name = ?, last_name = ?, email = ?, password = ?, passcode_expiry_date = ?, passwd_failure_retry = ?, last_passwd_failure_date = ?, permission_profile_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operator.getFirstName());
            stmt.setString(2, operator.getLastName());
            stmt.setString(3, operator.getEmail());
            stmt.setString(4, operator.getPassword());
            stmt.setDate(5, new java.sql.Date(operator.getPasscodeExpiryDate().getTime()));
            stmt.setInt(6, operator.getPasswdFailureRetry());
            stmt.setDate(7, operator.getLastPasswdFailureDate() != null ? new java.sql.Date(operator.getLastPasswdFailureDate().getTime()) : null);
            stmt.setInt(8, operator.getPermissionProfileId());
            stmt.setInt(9, operator.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM operators WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
