package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.PasswordPolicy;

public class PasswordPolicyDAO {
    private Connection connection;

    public PasswordPolicyDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(PasswordPolicy passwordPolicy) throws SQLException {
        String sql = "INSERT INTO password_policies (id, code, description, password_length, number_alpha_characters, number_numeric_characters, number_special_characters, number_uppercase_characters, password_reuse_history, password_expiration_days, failed_login_attempts) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, passwordPolicy.getId());
            stmt.setLong(2, passwordPolicy.getCode());
            stmt.setString(3, passwordPolicy.getDescription());
            stmt.setInt(4, passwordPolicy.getPasswordLength());
            stmt.setInt(5, passwordPolicy.getNumberAlphaCharacters());
            stmt.setInt(6, passwordPolicy.getNumberNumericCharacters());
            stmt.setInt(7, passwordPolicy.getNumberSpecialCharacters());
            stmt.setInt(8, passwordPolicy.getNumberUppercaseCharacters());
            stmt.setInt(9, passwordPolicy.getPasswordReuseHistory());
            stmt.setInt(10, passwordPolicy.getPasswordExpirationDays());
            stmt.setInt(11, passwordPolicy.getFailedLoginAttempts());
            stmt.executeUpdate();
        }
    }

    public PasswordPolicy findById(int id) throws SQLException {
        String sql = "SELECT * FROM password_policies WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PasswordPolicy(rs.getInt("id"), rs.getLong("code"), rs.getString("description"), rs.getInt("password_length"), rs.getInt("number_alpha_characters"), rs.getInt("number_numeric_characters"), rs.getInt("number_special_characters"), rs.getInt("number_uppercase_characters"), rs.getInt("password_reuse_history"), rs.getInt("password_expiration_days"), rs.getInt("failed_login_attempts"));
                }
            }
        }
        return null;
    }

    public List<PasswordPolicy> findAll() throws SQLException {
        List<PasswordPolicy> passwordPolicies = new ArrayList<>();
        String sql = "SELECT * FROM password_policies";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                passwordPolicies.add(new PasswordPolicy(rs.getInt("id"), rs.getLong("code"), rs.getString("description"), rs.getInt("password_length"), rs.getInt("number_alpha_characters"), rs.getInt("number_numeric_characters"), rs.getInt("number_special_characters"), rs.getInt("number_uppercase_characters"), rs.getInt("password_reuse_history"), rs.getInt("password_expiration_days"), rs.getInt("failed_login_attempts")));
            }
        }
        return passwordPolicies;
    }

    public void update(PasswordPolicy passwordPolicy) throws SQLException {
        String sql = "UPDATE password_policies SET code = ?, description = ?, password_length = ?, number_alpha_characters = ?, number_numeric_characters = ?, number_special_characters = ?, number_uppercase_characters = ?, password_reuse_history = ?, password_expiration_days = ?, failed_login_attempts = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, passwordPolicy.getCode());
            stmt.setString(2, passwordPolicy.getDescription());
            stmt.setInt(3, passwordPolicy.getPasswordLength());
            stmt.setInt(4, passwordPolicy.getNumberAlphaCharacters());
            stmt.setInt(5, passwordPolicy.getNumberNumericCharacters());
            stmt.setInt(6, passwordPolicy.getNumberSpecialCharacters());
            stmt.setInt(7, passwordPolicy.getNumberUppercaseCharacters());
            stmt.setInt(8, passwordPolicy.getPasswordReuseHistory());
            stmt.setInt(9, passwordPolicy.getPasswordExpirationDays());
            stmt.setInt(10, passwordPolicy.getFailedLoginAttempts());
            stmt.setInt(11, passwordPolicy.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM password_policies WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
