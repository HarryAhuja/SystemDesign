package Entities;

public class CinemaHall
{
	int 	cinema_hall_id;
	String  cinema_hall_name;
	Address address;
	
	List<Audi> audi_list;
	
	public Map<Date,Movies> get_movies(List<Date> date_list);
	public Map<Date,Show>   get_shows(List<Date> date_list);
}
