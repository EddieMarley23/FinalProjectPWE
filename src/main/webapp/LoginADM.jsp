<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Formulário de Login Admin</title>
</head>
<body>

  <h2>Faça Login Como Administrador</h2>
  
  <form action="UsuarioServlet" method="post">
    <input type="hidden" name="action" value="loginAdmin">  
    
    <label for="name">Name:</label> <input type="text" id="name"
      name="name" required><br>
    <br> <label for="password">Senha:</label> <input
      type="password" id="password" name="password" required><br>
    <br> <input type="submit" value="Enviar">
  </form>


 

</body>
</html>