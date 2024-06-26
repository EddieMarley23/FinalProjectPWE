package entities;

import java.text.DecimalFormat;

public class Movie {

	private String Title;
	private String Director;
	private String Genre;
	private Double Assessment = 0.0;
	private Integer QtdAssessment = 0;

	public Movie() {

	}

	public Movie(String title, String director, String genre) {
		Title = title;
		Director = director;
		Genre = genre;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public Double getAssessment() {
		return Assessment;
	}

	public void setAssessment(Double assessment) {
		Assessment = assessment;
	}

	public Integer getQtdAssessment() {
		return QtdAssessment;
	}

	public void setQtdAssessment(Integer qtdAssessment) {
		QtdAssessment = qtdAssessment;
	}

	public void addAsessment(Integer assessment) {
		Assessment += assessment;
		QtdAssessment += 1;
	}

	public double CalculatedAverage() {

		if (QtdAssessment == 0) {
			return 0.0;
		} else {
			 
			
			return Assessment / QtdAssessment;
		}
	}

}
