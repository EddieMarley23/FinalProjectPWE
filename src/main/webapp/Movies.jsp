<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Movie" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="db.DB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Filmes</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
<div class="container">
    <header>
        <h1 class="main-title">
            <%
            String username = (String) session.getAttribute("userName");
            if (username != null) {
                out.print("Bem vindo " + username);
                if (username.equals("eddie.sys")) {
            %>
        </h1>
    </header>
    <form action="ShowMovies" method="get" style="display: inline-block;">
        <input type="hidden" name="action" value="regMovieToDirect">
        <button type="submit">Cadastrar Filmes</button>
    </form>
    <br>
    <% } %>
    <form action="LogOut.jsp">
        <button type="submit">Deslogar</button>
    </form>
    <% } else {
        response.sendRedirect("Login.jsp");
        }
    %>
    <br>
    <h1 class="main-title">Lista de Filmes</h1>
    <div class="container-filmes">
        <table>
            <%
            List<Movie> movies = (List<Movie>) request.getAttribute("movies");

            if (movies != null) {
                for (Movie movie : movies) {
            %>
            <div class="movie-item">
                <h2><%= movie.getTitle() %></h2>
                <p><b>Diretor:</b> <%= movie.getDirector() %></p>
                <p><b>Avaliação:</b> <%= String.format("%.2f", movie.CalculatedAverage()) %></p>
            </div>
            <% } %>
            <% } else {
               out.print("Não há filmes disponíveis.");
            }
            %>
        </table>
    </div>
    <br>
    <div class="avaliacao">
        <h2>Faça a sua Avaliação</h2>
        <form action="ShowMovies" method="get">
            <input type="hidden" name="action" value="update">
            <label for="movieTitleForm">Nome do Filme:</label>
            <input type="text" id="movieTitleForm" name="movieTitleForm" required>
            <h2>Avaliação (1 a 10):</h2>
            <label for="Asessment">1</label>
            <input type="radio" id="Asessment" name="Asessment" value="1">
            <label for="Asessment">2</label>
            <input type="radio" id="Asessment" name="Asessment" value="2">
            <label for="Asessment">3</label>
            <input type="radio" id="Asessment" name="Asessment" value="3" checked>
            <label for="Asessment">4</label>
            <input type="radio" id="Asessment" name="Asessment" value="4">
            <label for="Asessment">5</label>
            <input type="radio" id="Asessment" name="Asessment" value="5">
            <label for="Asessment">6</label>
            <input type="radio" id="Asessment" name="Asessment" value="6">
            <label for="Asessment">7</label>
            <input type="radio" id="Asessment" name="Asessment" value="7">
            <label for="Asessment">8</label>
            <input type="radio" id="Asessment" name="Asessment" value="8">
            <label for="Asessment">9</label>
            <input type="radio" id="Asessment" name="Asessment" value="9">
            <label for="Asessment">10</label>
            <input type="radio" id="Asessment" name="Asessment" value="10">
            <br>
            <button type="submit">Enviar Avaliação</button>
        </form>
    </div>
    <div class="search">
        <h2>Busca Personalizada</h2>
        <h4>Atenção preencha apenas 1 dos campos para fazer a pesquisa</h4>
        <form action="ShowMovies" method="get">
            <input type="hidden" name="action" value="Search">
            <label for="movieTitleSearch">Título:</label>
            <input type="text" id="movieTitleSearch" name="movieTitleSearch" placeholder="Insira o título do filme">
            <label for="movieDirectorSearch">Diretor:</label>
            <input type="text" id="movieDirectorSearch" name="movieDirectorSearch" placeholder="Insira o nome do diretor">
            <label for="movieAssessment">Média de Avaliações:</label>
            <input type="text" id="movieAssessment" name="movieAssessment" placeholder="Insira 'Média' de Avaliação">
            <button type="submit">Pesquisar</button>
        </form>
    </div>
    <div class="container-filmes2">
        <table>
            <%
            List<Movie> moviesResearch = (List<Movie>) request.getAttribute("searchResult");

            if (moviesResearch != null) {
                for (Movie movie : moviesResearch) {
            %>
            <div class="movie-item2">
                <h2><%= movie.getTitle() %></h2>
                <p><b>Diretor:</b> <%= movie.getDirector() %></p>
                <p><b>Avaliação:</b> <%= String.format("%.2f", movie.CalculatedAverage()) %></p>
            </div>
            <% } %>
            <% } else {
               out.print("Não há filmes disponíveis.");
            }
            %>
        </table>
    </div>
</div>
</body>
</html>
