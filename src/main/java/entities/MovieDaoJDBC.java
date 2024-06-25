package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DBException;

public class MovieDaoJDBC implements MovieDao {

	private Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public MovieDaoJDBC() {

		try {
			conn = DB.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateMovie(Movie movie) {

		PreparedStatement st = null;

		try {

			conn.setAutoCommit(false);
			String sql = "UPDATE Movie SET movieAssessment = movieAssessment + ?, movieQtdAssessment = movieQtdAssessment + ? WHERE movieTitle = ?";
			st = conn.prepareStatement(sql);

			st.setDouble(1, movie.getAssessment());
			st.setInt(2, movie.getQtdAssessment());
			st.setString(3, movie.getTitle());

			int rowsAffected = st.executeUpdate();

			conn.commit();
			System.out.println("Fui até aqui");

			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				conn.rollback();
				throw new DBException("Transaction rolled back!Caused by" + e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("Error trying to rollback! Caused by: " + e1.getMessage());

			}
		}

	}

	@Override
	public void InsertData(Movie movie) throws SQLException {

		st = conn.prepareStatement(
				"INSERT INTO Movie (movieTitle, movieDirector, movieGenre, movieAssessment, movieQtdAssessment) VALUES (?, ?, ?, ?, ?)");
		st.setString(1, movie.getTitle());
		st.setString(2, movie.getDirector());
		st.setString(3, movie.getGenre());
		st.setDouble(4, movie.getAssessment());
		st.setInt(5, movie.getQtdAssessment());

		int rowsAffected = st.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Dados inseridos com sucesso!" + rowsAffected);
		} else {
			System.out.println("Falha na inserção!");
		}

	}

	@Override

	public List<Movie> ListMovies(List<Movie> movies) {

		System.out.println("Fui até aqui");
		try {
			st = conn.prepareStatement("select * from Movie");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				Movie movieDb = new Movie();
				movieDb.setTitle(rs.getString("movieTitle"));
				movieDb.setDirector(rs.getString("movieDirector"));
				movieDb.setGenre(rs.getString("movieGenre"));
				movieDb.setAssessment(rs.getDouble("movieAssessment"));
				movieDb.setQtdAssessment(rs.getInt("movieQtdAssessment"));
				movies.add(movieDb);
			}

			for (Movie obj : movies) {
				System.out.println(obj.getDirector());
			}

			return movies;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<Movie> ListMoviesSearch(List<Movie> movies, Movie movie) throws SQLException {

		try {
			if (movie.getTitle() != "") {
			st = conn.prepareStatement("select * from Movie Where movieTitle = ?");
				st.setString(1, movie.getTitle());
				
			} else if(movie.getDirector() !=""){
				
				st = conn.prepareStatement("select * from Movie Where movieDirector = ?");
				st.setString(1, movie.getDirector());
				
				}else if(movie.getAssessment() !=11.00000000000000){
					System.out.println("Fui pesquisar a AVALIAÇÂO");
					st = conn.prepareStatement("select * from Movie where round(movieAssessment / movieQtdAssessment,1) >=?");
					st.setDouble(1, movie.getAssessment());
					
					
				}
				

			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					Movie movieDb = new Movie();
					movieDb.setTitle(rs.getString("movieTitle"));
					movieDb.setDirector(rs.getString("movieDirector"));
					movieDb.setGenre(rs.getString("movieGenre"));
					movieDb.setAssessment(rs.getDouble("movieAssessment"));
					movieDb.setQtdAssessment(rs.getInt("movieQtdAssessment"));
					movies.add(movieDb);
				}

	
				return movies;
			}

		}catch(

	SQLException e)
	{
		
		System.err.println("Erro ao executar a consulta: " + e.getMessage());
		throw e; 
	}
}}
