package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo os parâmetros do formulário
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        // Verificação de credenciais (essa é uma verificação simples; em um cenário real, você faria uma consulta a um banco de dados)
        if (usuario.equals("123") && senha.equals("123")) {
            // Sucesso no login
            response.sendRedirect("dashboard.jsp");
        } else {
            // Falha no login
            response.sendRedirect("error.jsp");
        }
    }
}
