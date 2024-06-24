package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Movie;
import entities.MovieDaoJDBC;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String movieTitle = request.getParameter("movieTitleForm");
		String movieAsessmentParam = request.getParameter("Asessment");
		

		String movieTitleSearch = request.getParameter("movieTitleSearch");
		String movieDirectorSearch = request.getParameter("movieDirectorSearch");
		
		System.out.println("Titulo: "+ movieTitleSearch);
		System.out.println("FormYitle: "+ movieTitle);
		System.out.println("Diretor: "+ movieDirectorSearch);

		String action = request.getParameter("action");

		MovieDaoJDBC movieDao = new MovieDaoJDBC();

		if (action != null && action.equals("Search")) {
				
			Movie movie = new Movie();

			movie.setTitle(movieTitleSearch);
			movie.setDirector(movieDirectorSearch);
			
			

			List<Movie> movies = new ArrayList<>();

			List<Movie> listMovies = null;
			try {
				listMovies = movieDao.ListMoviesSearch(movies, movie);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			for(Movie obj: listMovies) {
				System.out.println("Título for each ShowMovies: "+ obj.getTitle());
			}

			if (listMovies != null) {
				request.setAttribute("searchResult", listMovies);
			} else {
				System.out.println("Movies é null");
			}
			
			List<Movie> movies2 = new ArrayList<>();

			List<Movie> listMovies2 = movieDao.ListMovies(movies2);

			for (Movie obj : listMovies2) {
				System.out.println(obj.getDirector());
			}

			if (listMovies2 != null) {
				request.setAttribute("movies", listMovies2);
			} else {
				System.out.println("Movies é null");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Movies.jsp");
			dispatcher.forward(request, response);

		} else if (action != null && action.equals("update")) {

			Integer movieAsessment = Integer.parseInt(movieAsessmentParam);

			Movie movie = new Movie();

			movie.setTitle(movieTitle);
			movie.addAsessment(movieAsessment);

			movieDao.UpdateMovie(movie);

			List<Movie> movies = new ArrayList<>();

			List<Movie> listMovies = movieDao.ListMovies(movies);

			for (Movie obj : listMovies) {
				System.out.println(obj.getDirector());
			}

			if (movies != null) {
				request.setAttribute("movies", listMovies);
			} else {
				System.out.println("Movies é null");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Movies.jsp");
			dispatcher.forward(request, response);

		} else {

			System.out.println("Fui até aqui DoGet");

			List<Movie> movies2 = new ArrayList<>();

			List<Movie> listMovies2 = movieDao.ListMovies(movies2);

			for (Movie obj : listMovies2) {
				System.out.println(obj.getDirector());
			}

			if (listMovies2 != null) {
				request.setAttribute("movies", listMovies2);
			} else {
				System.out.println("Movies é null");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Movies.jsp");
			dispatcher.forward(request, response);
		}

	}
}