<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Formulário de Login</title>
</head>
<body>

  <h2>Formulário de Login</h2>
  
  <form action="UsuarioServlet" method="post">
    <input type="hidden" name="action" value="login">  
    
    <label for="email">Email:</label> <input type="email" id="email"
      name="email" required><br>
    <br> <label for="password">Senha:</label> <input
      type="password" id="password" name="password" required><br>
    <br> <input type="submit" value="Enviar">
  </form>
  
  
  <form action= "UsuarioServlet" method="post" >
  <input type="hidden" name="action" value="directToAdmin">
 <input type="submit" value="Login Admin">
  
  </form>


 

</body>
</html>