package br.com.fiap.controller;

import br.com.fiap.DAO.TransactionDAO;
import br.com.fiap.entity.Transaction;
import br.com.fiap.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addTransactionServlet")
public class AddTransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo os parâmetros do formulário
        String dateStr = request.getParameter("date");
        String category = request.getParameter("category");
        String valueStr = request.getParameter("value");
        String paymentDateStr = request.getParameter("paymentDate");

        // Verificando se os parâmetros são nulos
        if (dateStr == null || category == null || valueStr == null || paymentDateStr == null) {
            response.sendRedirect("addTransaction.jsp?error=true");
            return;
        }

        // Convertendo os parâmetros
        Date date = null;
        Date paymentDate = null;
        double value = 0.0;

        try {
            date = Date.valueOf(dateStr.trim()); // Convertendo a string para java.sql.Date
            paymentDate = Date.valueOf(paymentDateStr.trim()); // Convertendo a string para java.sql.Date
            value = Double.parseDouble(valueStr.trim()); // Convertendo a string para double
        } catch (IllegalArgumentException e) {
            // Se houver um erro na conversão, redirecione para o formulário com uma mensagem de erro
            response.sendRedirect("addTransaction.jsp?error=true");
            return;
        }

        // Criando a instância da transação
        Transaction transaction = new Transaction();
        transaction.setTransDatetime(date);
        transaction.setTotal(value);
        transaction.setCategory(category);
        transaction.setPaymentDate(paymentDate);

        // Salvando a transação no banco de dados
        try (Connection connection = DbUtil.getConnection()) {
            TransactionDAO transactionDAO = new TransactionDAO(connection);
            transactionDAO.insert(transaction);
            response.sendRedirect("dashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("addTransaction.jsp?error=true");
        }
    }
}
