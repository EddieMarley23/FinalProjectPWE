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
    <form action="UsuarioServlet" method="post" class="login-form">
        <input type="hidden" name="action" value="login">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <input type="submit" value="Enviar">
    </form>

    <form action="UsuarioServlet" method="post" class="login-form">
        <input type="hidden" name="action" value="directToAdmin">
        <input type="submit" value="Login Admin">
    </form>

    <form action="RegisterUser.jsp" class="login-form">
        <input type="hidden" name="action" value="directToAdmin">
        <input type="submit" value="Realizar Cadastro">
    </form>
</div>
</body>
</html>
