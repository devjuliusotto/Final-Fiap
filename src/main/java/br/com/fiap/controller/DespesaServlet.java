package br.com.fiap.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DespesaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aqui você pode processar qualquer lógica necessária antes de redirecionar
        // Por exemplo, redirecionar para a página de despesas.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("despesas.jsp");
        dispatcher.forward(request, response);
    }
}
