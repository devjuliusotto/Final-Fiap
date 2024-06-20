package br.com.fiap.DAO;

import br.com.fiap.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardDAO {
    public double getEntradas() throws SQLException {
        String sql = "SELECT SUM(valor) FROM receitas";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0;
    }

    public double getDespesas() throws SQLException {
        String sql = "SELECT SUM(valor) FROM despesas";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0;
    }

    public double getEconomia() throws SQLException {
        // Implemente a lógica para calcular a economia
        return getEntradas() - getDespesas();
    }

    // Adicione mais métodos conforme necessário para buscar os detalhes
}
