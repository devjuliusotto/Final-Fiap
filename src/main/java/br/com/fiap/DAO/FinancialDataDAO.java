package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.util.DbUtil;

public class FinancialDataDAO {

    public static double getTotalEntradas() throws SQLException {
        String sql = "SELECT SUM(valor) FROM transacoes WHERE tipo = 'entrada'";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0;
    }

    public static double getTotalDespesas() throws SQLException {
        String sql = "SELECT SUM(valor) FROM transacoes WHERE tipo = 'despesa'";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0;
    }

    public static double getTotalEconomia() throws SQLException {
        String sql = "SELECT (SUM(CASE WHEN tipo = 'entrada' THEN valor ELSE 0 END) - SUM(CASE WHEN tipo = 'despesa' THEN valor ELSE 0 END)) AS economia FROM transacoes";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0;
    }
}
