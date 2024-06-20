<%@ page import="br.com.fiap.DAO.FinancialDataDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Projeto Fintech</title>
    <link rel="stylesheet" href="./main.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="container-0">
                <h1 class="titulo">Athenas Finance Control</h1>
            </div>
        </nav>
    </header>

    <main class="dashboard">
        <section class="section-estatisticas">
            <div class="container-1">
                <div class="statistics">
                    <h2>Estatísticas</h2>
                </div>
                <div class="grid-container">
                    <div class="estatistica">
                        <p class="estatistica-titulo">Entradas</p>
                        <p class="estatistica-valor">
                            <%
                                double entradas;
                                try {
                                    entradas = FinancialDataDAO.getTotalEntradas();
                                } catch (SQLException e) {
                                    entradas = 10000.00; // Valor fictício
                                }
                                out.print("R$ " + entradas);
                            %>
                        </p>
                    </div>
                    <div class="estatistica">
                        <p class="estatistica-titulo">Despesas</p>
                        <p class="estatistica-valor">
                            <%
                                double despesas;
                                try {
                                    despesas = FinancialDataDAO.getTotalDespesas();
                                } catch (SQLException e) {
                                    despesas = 5000.00; // Valor fictício
                                }
                                out.print("R$ " + despesas);
                            %>
                        </p>
                    </div>
                    <div class="estatistica">
                        <p class="estatistica-titulo">Economia</p>
                        <p class="estatistica-valor">
                            <%
                                double economia;
                                try {
                                    economia = FinancialDataDAO.getTotalEconomia();
                                } catch (SQLException e) {
                                    economia = 5000.00; // Valor fictício
                                }
                                out.print("R$ " + economia);
                            %>
                        </p>
                    </div>
                </div>
            </div>
        </section>

        <section id="section-graficos">
            <div class="container-2">
                <div class="section-title-2">
                    <h2>Gráficos</h2>
                </div>
                <div class="charts">
                    <div class="chart1">
                        <h2>Bitcoin</h2>
                        <canvas id="myChart"></canvas>
                    </div>
                    <div class="chart2">
                        <h2>Investimentos</h2>
                        <canvas id="myDoughnutChart"></canvas>
                    </div>
                </div>
            </div>
        </section>

        <section id="section-detalhes">
            <div class="container-3">
                <div class="title2">
                    <h2 class="section-title">Detalhes</h2>
                </div>
                <div class="detalhes-container">
                    <div class="detalhe">
                        <p class="detalhe-titulo">Horas Extras</p>
                        <p class="detalhe-valor">R$ 2000.00</p> <!-- Valor fictício -->
                    </div>
                    <div class="detalhe">
                        <p class="detalhe-titulo">Dividendos</p>
                        <p class="detalhe-valor">R$ 1500.00</p> <!-- Valor fictício -->
                    </div>
                    <div class="detalhe">
                        <p class="detalhe-titulo">Cartão de Crédito</p>
                        <p class="detalhe-valor">R$ 1000.00</p> <!-- Valor fictício -->
                    </div>
                    <div class="detalhe">
                        <p class="detalhe-titulo">Condomínio</p>
                        <p class="detalhe-valor">R$ 800.00</p> <!-- Valor fictício -->
                    </div>
                    <div class="detalhe">
                        <p class="detalhe-titulo">Internet</p>
                        <p class="detalhe-valor">R$ 300.00</p> <!-- Valor fictício -->
                    </div>
                </div>
            </div>
        </section>
    </main>

    <footer>
        <div class="container-4">
            <nav class="navbar-footer">
                <ul class="menu">
                    <li><a href="#section-graficos">Dashboard</a></li>
                    <li><a href="despesas.jsp">Despesa</a></li>
                    <li><a href="receitas.jsp">Receita</a></li>
                </ul>
            </nav>
        </div>
    </footer>

    <script src="js/charts.js"></script>
    <script src="JS/chart2.js"></script>
    <script src="./charts.js"></script>
</body>
</html>
