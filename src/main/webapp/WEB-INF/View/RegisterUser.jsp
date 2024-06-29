<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>

<div class="container">
    <h1>Faça seu cadastro</h1>
    
    <form action="UsuarioServlet" method="post" class="login-form">
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="password" required>
        </div>
        <button type="submit">Cadastrar</button>
        <br>
 
    </form>
    
             
    <form action="index.jsp" class ="login-form" >
    <div class="form-group">
     <button type="submit">Fazer Login</button>
     </div>

    </form>
     
   
</div>

</body>
</html>