<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    
    <div class="main-login">
        <div class="left-login">
            <h1>Athenas Finance Control</h1>
            <img src="./Athens-pana.svg" alt="Animação" class="left-login-image"> 
        </div>
        <div class="right-login">
            <div class="card-login">
                <h1>LOGIN</h1>
                <form action="<%= request.getContextPath() %>/login" method="post">
                    <div class="textfield">
                        <label for="usuario">Usuario</label>
                        <input type="text" id="usuario" name="usuario" placeholder="Usuário">
                    </div>
                    <div class="textfield">
                        <label for="senha">Senha</label>
                        <input type="password" id="senha" name="senha" placeholder="Password">
                    </div>
                    <button type="submit" class="btn-login">Entrar</button>
                </form>
            </div>
        </div>
    </div>
    
</body>
</html>
