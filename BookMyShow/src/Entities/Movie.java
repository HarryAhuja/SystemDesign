package Entities;

public class Movie
{
	String movie_name;
	int    movie_id;
	int    duration_in_mins;
	Genre  genre;
	String language;
	Date   release_date;
	
	// which city has which shows
	// List all the shows of that particular movie and city
	Map<String, List<Show>> city_show_map;
}
