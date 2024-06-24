package entities;

import java.sql.SQLException;
import java.util.List;

public interface MovieDao {
	
	public void InsertData(Movie movie) throws SQLException;
	
	public void UpdateMovie(Movie movie);
	
	public List<Movie> ListMovies(List<Movie> movies);


}
