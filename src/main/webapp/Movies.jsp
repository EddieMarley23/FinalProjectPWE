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

<nav><%
String username = (String) session.getAttribute("userName");
if (username != null) {
  out.print("Bem vindo " + username);
  if (username.equals("eddie.sys")) {%>
  
  <form action="ShowMovies" method ="get">
  <input type="hidden" name="action" value="regMovieToDirect">
  <button type="submit">Cadastrar Filmes</button>
  
  </form>
<%}
} else {
  response.sendRedirect("Login.jsp");
}
%></nav>

<body>

	

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



	</table>

	<br>
	<br>


	<h2>Faça a sua Avaliação</h2>



	<form action="ShowMovies" method="get">
	<input type="hidden" name="action" value="update">
		<label for="movieTitleForm">Nome do Filme:</label> <input type="text"
			id="movieTitleForm" name="movieTitleForm" required>

		<h2>Avaliação (1 a 5):</h2>
		<label for="Asessment">1</label> <input type="radio" id="Asessment"
			name="Asessment" value="1"> <label for="Asessment">2</label>
		<input type="radio" id="Asessment" name="Asessment" value="2">
		<label for="Asessment">3</label> <input type="radio" id="Asessment"
			name="Asessment" value="3" checked> <label for="Asessment">4</label>
		<input type="radio" id="Asessment" name="Asessment" value="4">
		<label for="Asessment">5</label> <input type="radio" id="Asessment"
			name="Asessment" value="5"> <br>

		<button type="submit">Enviar Avaliação</button>
	</form>

	<h2>Busca Personalizada</h2>
	
	<h4>Atenção preencha apenas 1 dos campos para fazer a pesquisa</h4>

	<form action = "ShowMovies" method="get">
	<input type="hidden" name="action" value="Search">  
		<label for="movieTitleSearch">Título:</label> <input type="text" id="movieTitleSearch"
			name="movieTitleSearch" placeholder="Insira o título do filme"> <label
			for="movieDirectorSearch">Diretor:</label> <input type="text" id="movieDirectorSearch"
			name="movieDirectorSearch" placeholder="Insira o nome do diretor"> 
			<label for="movieAssessment">Média de Avaliações:</label> <input type="text" id="movieAssessment"
			name="movieAssessment" placeholder="Insira 'Média' de Avaliação"> 

		<button type="submit">Pesquisar</button>
	</form>


	<table>
		<tr>
			<th>Título</th>
			<th>Diretor</th>
			<th>Avaliação</th>

		</tr>
		<%
		
		List<Movie> moviesResearch = (List<Movie>) request.getAttribute("searchResult");
		
		if (moviesResearch != null) {

			for (Movie movie : moviesResearch) {
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



	</table>





	<form action="LogOut.jsp">
		<input type="submit" value="Deslogar">

	</form>




</body>
</html>
</html>