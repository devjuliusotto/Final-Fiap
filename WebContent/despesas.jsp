<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Transação - Despesa</title>
    <style>
    /* Global Styles */
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: 'Arial', sans-serif;
        background-color: #2f2841;
    }
    .vermelho {
        font-weight: bold;
        color: red;
    }
    .container {
        background-color: #fff;
        border-radius: 40px;
        box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 
                    0 10px 10px rgba(0, 0, 0, 0.22);
        display: flex;
        width: 600px; /* Increased width */
        max-width: 100%;
        padding: 30px;
        flex-direction: column;
        align-items: center;
    }
    .form-container {
        width: 100%;
    }
    .add-transaction-container {
        flex-direction: column;
        align-items: center;
        text-align: left;
    }
    .header {
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin-bottom: 20px;
    }
    .header h1 {
        font-size: 24px;
    }
    .profile-pic {
        width: 50px;
        height: 50px;
        border-radius: 50%;
        object-fit: cover;
    }
    .balance {
        width: 100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
        padding: 10px;
        background-color: #f8f9fa;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    .balance h2 {
        margin: 0;
        font-size: 18px;
    }
    label {
        font-weight: bold;
        margin-top: 10px;
    }
    input, select {
        width: 100%;
        padding: 12px;
        margin-top: 8px;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 16px;
        transition: border-color 0.3s, box-shadow 0.3s;
    }
    input:focus, select:focus {
        border-color: #3faffa;
        box-shadow: 0 0 8px rgba(63, 175, 250, 0.5);
    }
    button {
        width: 100%;
        padding: 12px;
        margin-top: 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    .btn-success {
        background-color: #72ffb8;
        color: white;
    }
    .btn-success:hover {
        background-color: #77ffc0;
    }
    .btn-secondary {
        background-color: #aaa;
        color: white;
    }
    .btn-secondary:hover {
        background-color: #777;
    }
    .text-center {
        display: flex;
        justify-content: space-between;
        gap: 10px;
    }
    .error {
        color: red;
        font-size: 14px;
        margin-top: 10px;
    }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container add-transaction-container">
            <div class="header">
                <h1>Adicionar Transação - <b class="vermelho"> Despesa </b></h1>
                <img src="profile.jpg" alt="Profile Picture" class="profile-pic">
            </div>
            <div class="balance">
                <h2>Saldo Atual: R$ 5.000,00</h2>
            </div>
            <form action="<%= request.getContextPath() %>/addTransactionServlet" method="post">
                <div class="form-group mb-3">
                    <label for="dataLancamento" class="form-label">Data</label>
                    <input type="date" class="form-control" id="dataLancamento" name="date" required>
                </div>
                <div class="form-group mb-3">
                    <label for="categoria" class="form-label">Categoria</label>
                    <div class="input-group">
                        <select class="form-select" id="categoria" name="category" required>
                            <option selected>Categoria...</option>
                            <option value="Conta de Consumo">Conta de Consumo</option>
                            <option value="Cartão de Crédito">Cartão de Crédito</option>
                            <option value="Viagens">Viagens</option>
                            <option value="Almoço">Almoço</option>
                            <option value="Higiene">Higiene</option>
                        </select>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label for="tipoGasto" class="form-label">Tipo Gasto</label>
                    <div class="input-group">
                        <select class="form-select" id="tipoGasto" name="expenseType" required>
                            <option selected>Tipo de gasto...</option>
                            <option value="Produto">Produto</option>
                            <option value="Serviço">Serviço</option>
                        </select>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label for="dataPgto" class="form-label">Data Pgto</label>
                    <input type="date" class="form-control" id="dataPgto" name="paymentDate" required>
                </div>
                <div class="form-group mb-3">
                    <label for="formaPgto" class="form-label">Forma Pgto</label>
                    <div class="input-group">
                        <select class="form-select" id="formaPgto" name="paymentMethod" required>
                            <option selected>Forma de Pagamento...</option>
                            <option value="Dinheiro">Dinheiro</option>
                            <option value="Cartão de Crédito">Cartão de Crédito</option>
                            <option value="Cartão de Débito">Cartão de Débito</option>
                            <option value="Cheque">Cheque</option>
                            <option value="Pix">Pix</option>
                        </select>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label for="classificacao" class="form-label">Classificação</label>
                    <div class="input-group">
                        <select class="form-select" id="classificacao" name="classification" required>
                            <option selected>Classificação...</option>
                            <option value="Lazer">Lazer</option>
                            <option value="Saúde">Saúde</option>
                            <option value="Supérfluo">Supérfluo</option>
                            <option value="Consumo">Consumo</option>
                        </select>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label for="valor" class="form-label">Valor</label>
                    <input type="number" step="0.01" class="form-control" id="valor" name="value" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-success">SALVAR</button>
                </div>
                <button type="button" class="btn btn-secondary" onclick="window.location.href='dashboard.jsp'">Voltar</button>
                <%
                    String error = request.getParameter("error");
                    if (error != null && error.equals("true")) {
                        out.println("<p class='error'>Erro ao tentar se conectar ao banco de dados. Tente novamente.</p>");

                    }
                %>
            </form>
        </div>
    </div>
</body>
</html>
