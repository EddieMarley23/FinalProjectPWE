<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Login Admin</title>
    <link rel="stylesheet" href="Style.css">
</head>
<body>
<div class="container">
    <h2>Faça Login Como Administrador</h2>

    <form action="/Final_ProjectPWE/UsuarioServlet" method="post" class="login-form">
        <input type="hidden" name="action" value="loginAdmin">
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Enviar</button>
    </form>

</div>
</body>
</html>
