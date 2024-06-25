<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="entities.Movie"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page import="db.DB"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String username = (String) session.getAttribute("userName");
	if (username == null) {

		response.sendRedirect("LoginADM.jsp");
	} else {
		out.print("Bem vindo " + username);
	}
	%>

	<br>


	<h1>Lista de Filmes</h1>

	<table>
		<tr>
			<th>Título</th>
			<th>Diretor</th>
			<th>Avaliação</th>

		</tr>
		<%
		
		List<Movie> movies = (List<Movie>) request.getAttribute("movies");
		
		if (movies != null) {

			for (Movie movie : movies) {
		%>
		<td><%=movie.getTitle()%></td>
		<td><%=movie.getDirector()%></td>
		<td><%=movie.CalculatedAverage() %></td>
		</tr>
		<%
		}
		} else {
		
		out.print("Não há filmes disponíveis.");
		}
		%>
		
		

<h3>Faça o Cadastro de um Filme</h3>

  <form action="ShowMovies" method="get">
  <input type="hidden" name="action" value="registerMovie">
        <label for="movieTitle">Nome do Filme:</label>
        <input type="text" id="movieTitle" name="movieTitle" required>
       <br>
        <label for="movieDirector">Diretor:</label>
        <input type="text" id="movieDirector" name="movieDirector" required>
       <br>
        <label for="movieGenre">Gênero:</label>
        <input type="text" id="movieGenre" name="movieGenre" required>
       <br>
        <button type="submit">Cadastrar</button>
    </form>

</body>
</html>



	</table>

</body>
</html>