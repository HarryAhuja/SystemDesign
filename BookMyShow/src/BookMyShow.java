import java.util.Date;
import java.util.List;

import Entities.CinemaHall;
import Entities.Movie;

public class BookMyShow
{
	// Have Event instead of CinemallHall for extending to other events also
	// Create base class as event and create child like cinemaHall
	List<CinemaHall> cinemas;
	
	public List<Movie>		get_movies(Date date,String city);
	public List<CinemaHall> get_cinema_halls(String city);
}
