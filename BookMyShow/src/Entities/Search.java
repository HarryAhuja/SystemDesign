package Entities;

/*
 * Why search is not made interface or abstract class
 * Why it is kept normal class for association
 * Interface-> Search mechanism is same for all users(assumption)
 * Abstract-> no abstract method, we are providing defination
 * Normal class-> Search mechanism is same for all users(assumption)-> Inheritance
 */

public class Search
{
	public List<Movie> search_movies_by_name(String name);
	public List<Movie> search_movies_by_genre(String genre);
	public List<Movie> search_movies_by_language(String language);
	public List<Movie> search_movies_by_date(Date release_date);
}
