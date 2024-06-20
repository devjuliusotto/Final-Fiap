<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mensagem de Sucesso</title>
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
            text-align: center;
        }

        h1 {
            font-size: 24px;
            color: #72ffb8;
        }

        a {
            font-size: 16px;
            color: #3faffa;
            text-decoration: none;
            margin-top: 20px;
        }

        a:hover {
            text-decoration: underline;
        }

        .success-message {
            color: #2f2841;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="success-message">Valor registrado com sucesso!</h1>
        <a href="dashboard.jsp">Voltar para a home page</a>
    </div>
</body>
</html>
