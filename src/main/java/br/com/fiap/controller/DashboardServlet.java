package br.com.fiap.controller;

import br.com.fiap.DAO.DashboardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DashboardDAO dao = new DashboardDAO();
        try {
            double entradas = dao.getEntradas();
            double despesas = dao.getDespesas();
            double economia = dao.getEconomia();

            // Adicione mais atributos conforme necessário
            request.setAttribute("entradas", entradas);
            request.setAttribute("despesas", despesas);
            request.setAttribute("economia", economia);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
