package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.PermissionProfile;

public class PermissionProfileDAO {
    private Connection connection;

    public PermissionProfileDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(PermissionProfile permissionProfile) throws SQLException {
        String sql = "INSERT INTO permission_profiles (id, code, description, access_level, password_policies_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, permissionProfile.getId());
            stmt.setString(2, permissionProfile.getCode());
            stmt.setString(3, permissionProfile.getDescription());
            stmt.setInt(4, permissionProfile.getAccessLevel());
            stmt.setInt(5, permissionProfile.getPasswordPoliciesId());
            stmt.executeUpdate();
        }
    }

    public PermissionProfile findById(int id) throws SQLException {
        String sql = "SELECT * FROM permission_profiles WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PermissionProfile(rs.getInt("id"), rs.getString("code"), rs.getString("description"), rs.getInt("access_level"), rs.getInt("password_policies_id"));
                }
            }
        }
        return null;
    }

    public List<PermissionProfile> findAll() throws SQLException {
        List<PermissionProfile> permissionProfiles = new ArrayList<>();
        String sql = "SELECT * FROM permission_profiles";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                permissionProfiles.add(new PermissionProfile(rs.getInt("id"), rs.getString("code"), rs.getString("description"), rs.getInt("access_level"), rs.getInt("password_policies_id")));
            }
        }
        return permissionProfiles;
    }

    public void update(PermissionProfile permissionProfile) throws SQLException {
        String sql = "UPDATE permission_profiles SET code = ?, description = ?, access_level = ?, password_policies_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, permissionProfile.getCode());
            stmt.setString(2, permissionProfile.getDescription());
            stmt.setInt(3, permissionProfile.getAccessLevel());
            stmt.setInt(4, permissionProfile.getPasswordPoliciesId());
            stmt.setInt(5, permissionProfile.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM permission_profiles WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
