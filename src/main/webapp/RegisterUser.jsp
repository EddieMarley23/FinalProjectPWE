<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Faça seu cadastro</h1>

  <form action="UsuarioServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="name" required>
       <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
       <br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="password" required>
       <br>
        <button type="submit">Cadastrar</button>
    </form>

</body>
</html>