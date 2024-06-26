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

		

		

		

		String action = request.getParameter("action");

		MovieDaoJDBC movieDao = new MovieDaoJDBC();

		if(action != null && action.equals("registerMovie")){
			
			
			
			String movieTitle = request.getParameter("movieTitle");
			String movieDirector = request.getParameter("movieDirector");
			String movieGenre = request.getParameter("movieDirector");
			Movie movie = new Movie(movieTitle, movieDirector, movieGenre);
			try {
				movieDao.InsertData(movie);
			} catch (SQLException e) {
				
				e.printStackTrace();
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

			RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterMovies.jsp");
			dispatcher.forward(request, response);
			
			
	}else if (action != null && action.equals("regMovieToDirect")) {
		
						
		

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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterMovies.jsp");
		dispatcher.forward(request, response);
			
			

		} else if (action != null && action.equals("Search")) {
			
			String movieTitleSearch = request.getParameter("movieTitleSearch");
			String movieDirectorSearch = request.getParameter("movieDirectorSearch");
			String movieAssessmentParam = request.getParameter("movieAssessment");
			
			
			    
			Double movieAssessment = 0.0;
			
			if(movieAssessmentParam != null && !movieAssessmentParam.isEmpty()) {
				movieAssessment = Double.parseDouble(movieAssessmentParam);
				
			}else {
				movieAssessment = 0.0;
			}

			Movie movie = new Movie();

			movie.setTitle(movieTitleSearch);
			movie.setDirector(movieDirectorSearch);
			movie.setAssessment(movieAssessment);

			System.out.println("vALOR RECEBIDO POR movieAssessmentParam "+ movie.getAssessment());
			List<Movie> movies = new ArrayList<>();

			List<Movie> listMovies = null;
			
			try {
				System.out.println("Fui até a função:");
				listMovies = movieDao.ListMoviesSearch(movies, movie);
			} catch (SQLException e) {

				e.printStackTrace();
			}

			for (Movie obj : listMovies) {
				System.out.println("Resultado diretor: "+obj.getDirector());
			}

			if (listMovies != null) {
				request.setAttribute("searchResult", listMovies);
			} else {
				System.out.println("Movies é null");
			}

			List<Movie> movies2 = new ArrayList<>();

			List<Movie> listMovies2 = movieDao.ListMovies(movies2);

			

			if (listMovies2 != null) {
				request.setAttribute("movies", listMovies2);
			} else {
				System.out.println("Movies é null");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Movies.jsp");
			dispatcher.forward(request, response);

		} else if (action != null && action.equals("update")) {
			
			String movieTitle = request.getParameter("movieTitleForm");
			String movieAsessmentParam = request.getParameter("Asessment");

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
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("RedirectServlet");
			dispatcher.forward(request, response);

		} else {

			

			List<Movie> movies2 = new ArrayList<>();

			List<Movie> listMovies2 = movieDao.ListMovies(movies2);

			

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