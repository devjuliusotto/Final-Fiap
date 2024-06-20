package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.fiap.util.DatabaseConnection;

@WebServlet("/addRevenueServlet")
public class AddRevenueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String category = request.getParameter("category");
        String value = request.getParameter("value");
        String paymentMethod = request.getParameter("paymentMethod");

        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO revenues (date, category, value, payment_method) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, date);
            stmt.setString(2, category);
            stmt.setDouble(3, Double.parseDouble(value));
            stmt.setString(4, paymentMethod);

            stmt.executeUpdate();
            stmt.close();
            connection.close();

            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("receita.jsp?error=true");
        }
    }
}
