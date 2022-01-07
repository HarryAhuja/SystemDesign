package Entities;

public class Audi
{
	int    		audi_id;
	String 		audi_name;
	int    		total_seats;
	// CinemaHall-> reverse mapping
	List<Shows> shows;
	
	/*
	 * Dont add get_all_shows(date) here bcs we never ask audi to give shows/movies
	 * We ask cinemaHall -> it will search for every audi for particular date
	 * Can add api for cinemaHall helper not user
	 */
}
