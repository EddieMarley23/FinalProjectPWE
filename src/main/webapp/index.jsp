<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Login</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<div class="container">
    <h2>Formulário de Login</h2>
    <form action="/Final_ProjectPWE/UsuarioServlet" method="post" class="login-form">
        <input type="hidden" name="action" value="login">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class = "form-group">
        <button type="submit"> Fazer Login</button>
        </div>
    </form>

    <form action="/Final_ProjectPWE/UsuarioServlet" method="post" class="login-form">
    <div class = "form-group">
        <input type="hidden" name="action" value="directToAdmin">
        <button type="submit">Login Admin</button>
         </div>
    </form>

    <form action="/Final_ProjectPWE/UsuarioServlet" class="login-form" method ="post">
    <div class = "form-group">
        <input type="hidden" name="action" value="directToUser">
        <button type="submit">Realizar Cadastro</button>
        </div>
    </form>
    
</div>
</body>
</html>
