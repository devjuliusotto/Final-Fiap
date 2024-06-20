package br.com.fiap.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.entity.Transaction;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (id, transaction_num, operation_id, trans_datetime, total, payment_id, operator_id, type_operation_id, category, expense_type, payment_date, payment_method, classification) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getId());
            stmt.setLong(2, transaction.getTransactionNum());
            stmt.setInt(3, transaction.getOperationId());
            stmt.setDate(4, new java.sql.Date(transaction.getTransDatetime().getTime()));
            stmt.setDouble(5, transaction.getTotal());
            stmt.setInt(6, transaction.getPaymentId());
            stmt.setInt(7, transaction.getOperatorId());
            stmt.setInt(8, transaction.getTypeOperationId());
            stmt.setString(9, transaction.getCategory());
            stmt.setString(10, transaction.getExpenseType());
            stmt.setDate(11, new java.sql.Date(transaction.getPaymentDate().getTime()));
            stmt.setString(12, transaction.getPaymentMethod());
            stmt.setString(13, transaction.getClassification());
            stmt.executeUpdate();
        }
    }

    public Transaction findById(int id) throws SQLException {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Transaction(rs.getInt("id"), rs.getLong("transaction_num"), rs.getInt("operation_id"), rs.getDate("trans_datetime"), rs.getDouble("total"), rs.getInt("payment_id"), rs.getInt("operator_id"), rs.getInt("type_operation_id"), sql, sql, null, sql, sql);
                }
            }
        }
        return null;
    }

    public List<Transaction> findAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(rs.getInt("id"), rs.getLong("transaction_num"), rs.getInt("operation_id"), rs.getDate("trans_datetime"), rs.getDouble("total"), rs.getInt("payment_id"), rs.getInt("operator_id"), rs.getInt("type_operation_id"), sql, sql, null, sql, sql));
            }
        }
        return transactions;
    }

    public void update(Transaction transaction) throws SQLException {
        String sql = "UPDATE transactions SET transaction_num = ?, operation_id = ?, trans_datetime = ?, total = ?, payment_id = ?, operator_id = ?, type_operation_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, transaction.getTransactionNum());
            stmt.setInt(2, transaction.getOperationId());
            stmt.setDate(3, new java.sql.Date(transaction.getTransDatetime().getTime()));
            stmt.setDouble(4, transaction.getTotal());
            stmt.setInt(5, transaction.getPaymentId());
            stmt.setInt(6, transaction.getOperatorId());
            stmt.setInt(7, transaction.getTypeOperationId());
            stmt.setInt(8, transaction.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
