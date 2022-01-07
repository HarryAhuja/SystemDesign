package Entities;

public class Search
{
	public List<Movie> search_movies_by_name(String name);
	public List<Movie> search_movies_by_genre(String genre);
	public List<Movie> search_movies_by_language(String language);
	public List<Movie> search_movies_by_date(Date release_date);
}
