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
    <%
    String username = (String) session.getAttribute("userName");
    if (username == null) {
        response.sendRedirect("LoginADM.jsp");
    } else {
        out.print("<h2>Bem vindo " + username + "</h2>");
    }
    %>

    <br>

    <h1>Lista de Filmes</h1>

    <table class="movie-table">
        <thead>
        <tr>
            <th>Título</th>
            <th>Diretor</th>
            <th>Avaliação</th>
        </tr>
        </thead>
        <tbody>
        <%
        List<Movie> movies = (List<Movie>) request.getAttribute("movies");

        if (movies != null) {
            for (Movie movie : movies) {
        %>
        <tr>
            <td><%= movie.getTitle() %></td>
            <td><%= movie.getDirector() %></td>
            <td><%= String.format("%.2f",movie.CalculatedAverage()) %></td>
        </tr>
        <%
            }
        } else {
            out.print("<tr><td colspan=\"3\">Não há filmes disponíveis.</td></tr>");
        }
        %>
        </tbody>
    </table>

    <h3>Faça o Cadastro de um Filme</h3>

    <form action="ShowMovies" method="get" class="movie-form">
        <input type="hidden" name="action" value="registerMovie">
        <div class="form-group">
            <label for="movieTitle">Nome do Filme:</label>
            <input type="text" id="movieTitle" name="movieTitle" required>
        </div>
        <div class="form-group">
            <label for="movieDirector">Diretor:</label>
            <input type="text" id="movieDirector" name="movieDirector" required>
        </div>
        <div class="form-group">
            <label for="movieGenre">Gênero:</label>
            <input type="text" id="movieGenre" name="movieGenre" required>
        </div>
        <button type="submit">Cadastrar</button>
    </form>

    <form action="ShowMovies" method="get" class="movie-form">
        <input type="hidden" name="action" value="directToAdmin">
        <button type="submit">Voltar</button>
    </form>
</div>
</body>
</html>
